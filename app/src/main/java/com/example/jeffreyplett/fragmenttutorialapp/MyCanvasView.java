package com.example.jeffreyplett.fragmenttutorialapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
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
    private Paint mNewAnchor;
    private Paint mExistingAnchor;
    private int colorBlack;
    private int colorRed;
    private Canvas mExtraCanvas;
    private Bitmap mExtraBitmap;
    private float mX, mY;
    private float rectWidth = 15;
    private float rectHeight = 15;
    private static final float TOUCH_TOLERANCE = 4;
    private Rect mFrame = new Rect();
    private Anchor tempAnchor = new Anchor();

    MyCanvasView(Context context){
        this(context, null);
    }

    public MyCanvasView(Context context, AttributeSet attributeSet){
        super(context);
        tempAnchor.setName("tempAnchor");

        colorBlack = ResourcesCompat.getColor(getResources(),R.color.black,null);
        colorRed = ResourcesCompat.getColor(getResources(),R.color.red,null);

        mNewAnchor = new Paint();
        mNewAnchor.setColor(colorBlack);
        mNewAnchor.setAntiAlias(true);
        mNewAnchor.setDither(true);
        mNewAnchor.setStyle(Paint.Style.STROKE);
        mNewAnchor.setTextSize(30);
        mNewAnchor.setStrokeWidth(3);

        mExistingAnchor = new Paint();
        mExistingAnchor.setColor(colorRed);
        mExistingAnchor.setAntiAlias(true);
        mExistingAnchor.setDither(true);
        mExistingAnchor.setStyle(Paint.Style.STROKE);
        mExistingAnchor.setTextSize(30);
        mExistingAnchor.setStrokeWidth(3);

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
        float x_offset, y_offset;

        if (mX > 1000) {
            x_offset = -150;
        } else if (mX > 970) {
            x_offset = -110;
        }  else if (mX > 950) {
            x_offset = -80;
        } else if (mX > 930) {
            x_offset = -60;
        } else if (mX > 910) {
            x_offset = -20;
        } else {
            x_offset = 0;
        }

        if (mY < 60){
            y_offset = 40;
        } else{
            y_offset = -20;
        }

        mExtraCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
        mExtraCanvas.drawRect(mX-(rectWidth/2),mY-(rectHeight/2),mX+(rectWidth/2),mY+(rectHeight/2),mNewAnchor);
        mExtraCanvas.drawText(coords, mX + x_offset, mY + y_offset, mNewAnchor);

        tempAnchor.setAnchorX(mX);
        tempAnchor.setAnchorY(mY);

        Log.i("TAG", "Click location: " + coords);
    }





}
