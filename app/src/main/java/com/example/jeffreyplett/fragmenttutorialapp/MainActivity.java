package com.example.jeffreyplett.fragmenttutorialapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
        Toast.makeText(this, "Welcome to anchor selection",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, SelectAnchorsActivity.class);
        startActivity(intent);
    }

}
