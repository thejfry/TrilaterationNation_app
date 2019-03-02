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

public class SelectAnchorsActivity extends AppCompatActivity implements /*Anchor1.Anchor1Listener, Anchor2.Anchor2Listener, */Anchor3.Anchor3Listener, Anchor4.Anchor4Listener {

    private SectionsStatePagerAdapter mSectionsStatePagerAdapter;
    private ViewPager mViewPager;
    public static ArrayList<Anchor> anchorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_anchors);

        mSectionsStatePagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        anchorList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            anchorList.add(new Anchor());
            anchorList.get(i).setName("Anchor " + (i+1));
        }

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
//        Log.i("TAG","Anchor 1 in selectAnchorsActivity:\n" + anchorList.get(0).getName() + "\n" + anchorList.get(0).getAnchorX() + "\n" + anchorList.get(0).getAnchorY());
//        Log.i("TAG","Anchor 2 in selectAnchorsActivity:\n" + anchorList.get(1).getName() + "\n" + anchorList.get(1).getAnchorX() + "\n" + anchorList.get(1).getAnchorY());
//        Log.i("TAG","Anchor 3 in selectAnchorsActivity:\n" + anchorList.get(2).getName() + "\n" + anchorList.get(2).getAnchorX() + "\n" + anchorList.get(2).getAnchorY());
//        Log.i("TAG","Anchor 4 in selectAnchorsActivity:\n" + anchorList.get(3).getName() + "\n" + anchorList.get(3).getAnchorX() + "\n" + anchorList.get(3).getAnchorY());
        Log.i("TAG","Anchor 1 in SelectAnchorsActivity:\n" + SelectAnchorsActivity.anchorList.get(0).getName() + "\n" + SelectAnchorsActivity.anchorList.get(0).getAnchorX() + "\n" + SelectAnchorsActivity.anchorList.get(0).getAnchorY());
        Log.i("TAG","Anchor 2 in SelectAnchorsActivity:\n" + SelectAnchorsActivity.anchorList.get(1).getName() + "\n" + SelectAnchorsActivity.anchorList.get(1).getAnchorX() + "\n" + SelectAnchorsActivity.anchorList.get(1).getAnchorY());
        Log.i("TAG","Anchor 3 in SelectAnchorsActivity:\n" + SelectAnchorsActivity.anchorList.get(2).getName() + "\n" + SelectAnchorsActivity.anchorList.get(2).getAnchorX() + "\n" + SelectAnchorsActivity.anchorList.get(2).getAnchorY());
        Log.i("TAG","Anchor 4 in SelectAnchorsActivity:\n" + SelectAnchorsActivity.anchorList.get(3).getName() + "\n" + SelectAnchorsActivity.anchorList.get(3).getAnchorX() + "\n" + SelectAnchorsActivity.anchorList.get(3).getAnchorY());
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

//    @Override
//    public void onInputAnchor1Sent(Anchor anchor) {
//        anchorList.set(0,anchor);
////        anchorList.add(anchor);
//        Log.i("TAG","In anchorList: \n" + anchorList.get(0).getName() + "\n" + anchorList.get(0).getAnchorX() + "\n" + anchorList.get(0).getAnchorY());
//    }
//
//    @Override
//    public void onInputAnchor2Sent(Anchor anchor) {
//        Log.i("TAG","In anchorList (anchor 1 before anchor 2 is set): \n" + anchorList.get(0).getName() + "\n" + anchorList.get(0).getAnchorX() + "\n" + anchorList.get(0).getAnchorY());
//        anchorList.set(1,anchor);
//        Log.i("TAG","In anchorList (anchor 1 after anchor 2 is set): \n" + anchorList.get(0).getName() + "\n" + anchorList.get(0).getAnchorX() + "\n" + anchorList.get(0).getAnchorY());
//        Log.i("TAG","In anchorList (anchor 2): \n" + anchorList.get(1).getName() + "\n" + anchorList.get(1).getAnchorX() + "\n" + anchorList.get(1).getAnchorY());
//    }

    @Override
    public void onInputAnchor3Sent(Anchor anchor) {
        anchorList.set(2,anchor);
    }

    @Override
    public void onInputAnchor4Sent(Anchor anchor) {
        anchorList.set(3,anchor);
    }
}
