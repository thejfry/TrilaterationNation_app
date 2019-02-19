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

    private static final String TAG = "SelectAnchorsActivity";
    private SectionsStatePagerAdapter mSectionsStatePagerAdapter;
    private ViewPager mViewPager;
    private List<Anchor> mAnchors = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_anchors);

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
        Log.i("TAG","btnNavMainActivity");
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void btnSubmitAnchor(View view){

        Log.i("TAG","btnSubmitAnchor");
        Toast.makeText(this, "Anchor is submitted",Toast.LENGTH_SHORT).show();
    }

}
