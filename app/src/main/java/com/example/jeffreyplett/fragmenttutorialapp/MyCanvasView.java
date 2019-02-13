package com.example.jeffreyplett.fragmenttutorialapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.content.res.ResourcesCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/*This class has been made possible by this spectacular tutorial site:
https://codelabs.developers.google.com/codelabs/advanced-android-training-draw-on-canvas/index.html?index=..%2F..advanced-android-training#2
 */

public class MyCanvasView extends View {
    private Paint mPaint;
    private int mDrawColor;
    private Canvas mExtraCanvas;
    private Bitmap mExtraBitmap;
    private float mX, mY;
    private float rectWidth = 15;
    private float rectHeight = 15;
    private static final float TOUCH_TOLERANCE = 4;
    private Rect mFrame = new Rect();

    MyCanvasView(Context context){
        this(context, null);
    }

    public MyCanvasView(Context context, AttributeSet attributeSet){
        super(context);

//        mBackgroundColor = ResourcesCompat.getColor(getResources(),R.color.opaque_orange,null);
        mDrawColor = ResourcesCompat.getColor(getResources(),R.color.black,null);

        mPaint = new Paint();
        mPaint.setColor(mDrawColor);
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setTextSize(30);
        mPaint.setStrokeWidth(3);
        setBackgroundResource(R.drawable.end301);
        Log.i("TAG", "constructing canvas view");

    }

    @Override
    protected void onSizeChanged(int width, int height, int oldWidth, int oldHeight){
        super.onSizeChanged(width, height, oldWidth, oldHeight);
        mExtraBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        mExtraCanvas = new Canvas(mExtraBitmap);
        int inset = 40;
        mFrame = new Rect(inset, inset, width - inset, height - inset);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawBitmap(mExtraBitmap,0,0,null);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                touchDown(x,y);
                invalidate();
                break;
            default:
                //do nothing
        }
        return true;
    }

    public void touchDown(float x, float y){
        mX = x;
        mY = y;
        String coords = "("+(int)mX+", "+(int)mY+")";
        String extra = getResources().getString(R.string.anchor1_coords);

        mExtraCanvas.drawRect(mX-(rectWidth/2),mY-(rectHeight/2),mX+(rectWidth/2),mY+(rectHeight/2),mPaint);
        mExtraCanvas.drawText(coords,mX,mY - 20, mPaint);

        Log.i("TAG", "Click location: " + coords);
        Log.i("TAG", extra + coords);
    }
}
