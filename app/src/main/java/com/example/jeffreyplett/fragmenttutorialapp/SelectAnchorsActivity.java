package com.example.jeffreyplett.fragmenttutorialapp;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SelectAnchorsActivity extends AppCompatActivity {

    private static final String TAG = "SelectAnchorsActivity";
    private SectionsStatePagerAdapter mSectionsStatePagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        mSectionsStatePagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.fragmentContainer);

        setupViewPager(mViewPager);
        Log.d(TAG, "onCreate");
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
        Log.i("LOG","btnNavMainActivity");
//        Toast.makeText(this, "Welcome to main activity",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void btnNavAnchor1(View view){
        Log.i("LOG","btnNavAnchor1");
//        Toast.makeText(this, "Welcome to anchor 1 selection",Toast.LENGTH_SHORT).show();
        this.setViewPager(0);
    }

    public void btnNavAnchor2(View view){
        Log.i("LOG","btnNavAnchor2");
//        Toast.makeText(this, "Welcome to anchor 2 selection",Toast.LENGTH_SHORT).show();
        this.setViewPager(1);
    }

    public void btnNavAnchor3(View view){
        Log.i("LOG","btnNavAnchor3");
//        Toast.makeText(this, "Welcome to anchor 3 selection",Toast.LENGTH_SHORT).show();
        this.setViewPager(2);
    }

    public void btnNavAnchor4(View view){
        Log.i("LOG","btnNavAnchor4");
//        Toast.makeText(this, "Welcome to anchor 4 selection",Toast.LENGTH_SHORT).show();
        this.setViewPager(3);
    }
}
