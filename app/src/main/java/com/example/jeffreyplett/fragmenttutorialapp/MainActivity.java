package com.example.jeffreyplett.fragmenttutorialapp;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//    private Button btnToFrag1;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");
    }

    public void btnNavFragActivity(View view){
        Log.i("LOG","btnToFragActivity");
        Toast.makeText(this, "Welcome to fragment activity",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, FragmentActivity.class);
        startActivity(intent);
    }

//    public void btnToFrag1(View view){
//        Log.d(TAG, "btnToFrag1");
//        Toast.makeText(this ,"Going to first fragment", Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(this, FragmentActivity.class);
//        startActivity(intent);
//    }
//
//    public void btnToFrag2(View view){
//        Log.d(TAG, "btnToFrag2");
//        Toast.makeText(this ,"Going to second fragment", Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(this, FragmentActivity.class);
//        startActivity(intent);
//
//    }
//
//    public void btnToFrag3(View view){
//        Log.d(TAG, "btnToFrag3");
//        Toast.makeText(this ,"Going to third fragment", Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(this, FragmentActivity.class);
//        startActivity(intent);
//    }
}
