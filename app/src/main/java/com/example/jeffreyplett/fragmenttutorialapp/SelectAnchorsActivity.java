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

public class SelectAnchorsActivity extends AppCompatActivity implements Anchor1.Anchor1Listener, Anchor2.Anchor2Listener, Anchor3.Anchor3Listener, Anchor4.Anchor4Listener {

    private static final String TAG = "SelectAnchorsActivity";
    private SectionsStatePagerAdapter mSectionsStatePagerAdapter;
    private ViewPager mViewPager;
    private static ArrayList<Anchor> anchorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_anchors);

        mSectionsStatePagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        anchorList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            anchorList.add(new Anchor());
        }

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
        Intent intent = new Intent(this, MainActivity.class);
        intent.putParcelableArrayListExtra("anchorList", anchorList);
        startActivity(intent);
    }

    @Override
    public void onInputAnchor1Sent(Anchor anchor) {
        anchorList.add(0,anchor);
//        anchorList.add(anchor);
        Log.i("TAG","In anchorList: \n" + anchorList.get(0).getName() + "\n" + anchorList.get(0).getAnchorX() + "\n" + anchorList.get(0).getAnchorY());

//        Toast.makeText(this,"Final anchor location: \n" + anchorList.get(1).getName() + "\n" + anchorList.get(1).getAnchorX() + "\n" + anchorList.get(1).getAnchorY(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onInputAnchor2Sent(Anchor anchor) {
        anchorList.add(1,anchor);
//        Toast.makeText(this,"Final anchor location: \n" + anchorList.get(1).getName() + "\n" + anchorList.get(1).getAnchorX() + "\n" + anchorList.get(1).getAnchorY(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onInputAnchor3Sent(Anchor anchor) {
        anchorList.add(2,anchor);
//        Toast.makeText(this,"Final anchor location: \n" + anchorList.get(1).getName() + "\n" + anchorList.get(1).getAnchorX() + "\n" + anchorList.get(1).getAnchorY(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onInputAnchor4Sent(Anchor anchor) {
        anchorList.add(3,anchor);
//        Toast.makeText(this,"Final anchor location: \n" + anchorList.get(1).getName() + "\n" + anchorList.get(1).getAnchorX() + "\n" + anchorList.get(1).getAnchorY(),Toast.LENGTH_SHORT).show();
    }
}
