package com.example.jeffreyplett.fragmenttutorialapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

//    private Button btnToFrag1;

    private static final String TAG = "MainActivity";
    private static ArrayList<Anchor> anchorList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anchorList = new ArrayList<Anchor>();
        Log.d(TAG, "onCreate");
    }

    public void btnNavFragActivity(View view){
        Log.i("LOG","btnToFragActivity");
        Intent intent = new Intent(this, SelectAnchorsActivity.class);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        try {
            anchorList = getIntent().getParcelableArrayListExtra("anchorList");
            Log.i("TAG","Anchor 1 in main activity:\n" + anchorList.get(0).getName() + "\n" + anchorList.get(0).getAnchorX() + "\n" + anchorList.get(0).getAnchorY());
            Log.i("TAG","Anchor 2 in main activity:\n" + anchorList.get(1).getName() + "\n" + anchorList.get(1).getAnchorX() + "\n" + anchorList.get(1).getAnchorY());
            Log.i("TAG","Anchor 3 in main activity:\n" + anchorList.get(2).getName() + "\n" + anchorList.get(2).getAnchorX() + "\n" + anchorList.get(2).getAnchorY());
            Log.i("TAG","Anchor 4 in main activity:\n" + anchorList.get(3).getName() + "\n" + anchorList.get(3).getAnchorX() + "\n" + anchorList.get(3).getAnchorY());
        } catch (Exception e) {
            Log.i("TAG","No anchor list");
        }
    }
}
