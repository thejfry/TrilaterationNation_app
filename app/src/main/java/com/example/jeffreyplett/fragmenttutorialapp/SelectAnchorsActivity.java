package com.example.jeffreyplett.fragmenttutorialapp;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SelectAnchorsActivity extends AppCompatActivity {

    private SectionsStatePagerAdapter mSectionsStatePagerAdapter;
    private ViewPager mViewPager;
    private Anchor Anchor1;
    private Anchor Anchor2;
    private Anchor Anchor3;
    private Anchor Anchor4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_anchors);

        mSectionsStatePagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.fragmentContainer);
        setupViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager){
        SectionsStatePagerAdapter adapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        adapter.addAnchor(new Anchor1(), "Anchor 1");
        adapter.addAnchor(new Anchor2(), "Anchor 2");
        adapter.addAnchor(new Anchor3(), "Anchor 3");
        adapter.addAnchor(new Anchor4(), "Anchor 4");
        viewPager.setAdapter(adapter);
    }

    public void setViewPager(int fragmentNumber){
        mViewPager.setCurrentItem(fragmentNumber);
    }

    public void btnNavMain(View view){
        Log.i("tag","Packaging the following anchors to send to main activity:\n" + Anchor1.getName() + "\n" + Anchor1.getAnchorX() + "\n" + Anchor1.getAnchorY() + "\n" + Anchor2.getName() + "\n" + Anchor2.getAnchorX() + "\n" + Anchor2.getAnchorY());
        Intent intent = new Intent(this, MainActivity.class);
        if(Anchor1 != null) {
            intent.putExtra("Anchor1", Anchor1);
        }
        if(Anchor2 != null) {
            intent.putExtra("Anchor2", Anchor2);
        }
        if(Anchor3 != null) {
            intent.putExtra("Anchor3", Anchor3);
        }
        if(Anchor4 != null) {
            intent.putExtra("Anchor4", Anchor4);
        }
        startActivity(intent);
    }

    public Anchor getAnchor1() {
        return Anchor1;
    }

    public void setAnchor1(Anchor anchor1) {
        Log.i("TAG", "Setting anchor 1:\n" + anchor1.getName() + "\n" + anchor1.getAnchorX() + "\n" + anchor1.getAnchorY());
        this.Anchor1 = anchor1;
    }

    public Anchor getAnchor2() {
        return Anchor2;
    }

    public void setAnchor2(Anchor anchor2) {
        Log.i("TAG", "Setting anchor 2:\n" + anchor2.getName() + "\n" + anchor2.getAnchorX() + "\n" + anchor2.getAnchorY());
        Log.i("TAG", "Setting anchor 1:\n" + Anchor1.getName() + "\n" + Anchor1.getAnchorX() + "\n" + Anchor1.getAnchorY());
        this.Anchor2 = anchor2;
    }

    public Anchor getAnchor3() {
        return Anchor3;
    }

    public void setAnchor3(Anchor anchor3) {
        this.Anchor3 = anchor3;
    }

    public Anchor getAnchor4() {
        return Anchor4;
    }

    public void setAnchor4(Anchor anchor4) {
        this.Anchor4 = anchor4;
    }
}
