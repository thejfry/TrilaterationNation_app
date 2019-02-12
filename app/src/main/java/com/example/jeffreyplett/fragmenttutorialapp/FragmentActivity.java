package com.example.jeffreyplett.fragmenttutorialapp;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class FragmentActivity extends AppCompatActivity {

    private static final String TAG = "FragmentActivity";
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
        adapter.addFragment(new Fragment1(), "Fragment 1");
        adapter.addFragment(new Fragment2(), "Fragment 2");
        adapter.addFragment(new Fragment3(), "Fragment 3");
        viewPager.setAdapter(adapter);
    }

    public void setViewPager(int fragmentNumber){
        mViewPager.setCurrentItem(fragmentNumber);
    }

    public void btnNavMain(View view){
        Log.i("LOG","btnNavMainActivity");
        Toast.makeText(this, "Welcome to main activity",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void btnNavAnchor1(View view){
        Log.i("LOG","btnNavAnchor1");
        Toast.makeText(this, "Welcome to anchor 1 selection",Toast.LENGTH_SHORT).show();
        this.setViewPager(0);
    }

    public void btnNavAnchor2(View view){
        Log.i("LOG","btnNavAnchor1");
        Toast.makeText(this, "Welcome to anchor 2 selection",Toast.LENGTH_SHORT).show();
        this.setViewPager(1);
    }

    public void btnNavAnchor3(View view){
        Log.i("LOG","btnNavAnchor1");
        Toast.makeText(this, "Welcome to anchor 3 selection",Toast.LENGTH_SHORT).show();
        this.setViewPager(2);
    }
}
