package com.example.jeffreyplett.fragmenttutorialapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

//    private Button btnToFrag1;

    private static final String TAG = "MainActivity";
    private Anchor Anchor1;
    private Anchor Anchor2;
    private Anchor Anchor3;
    private Anchor Anchor4;
    private TextView anchor1Name;
    private TextView anchor1x;
    private TextView anchor1y;
    private TextView anchor2Name;
    private TextView anchor2x;
    private TextView anchor2y;
    private TextView anchor3Name;
    private TextView anchor3x;
    private TextView anchor3y;
    private TextView anchor4Name;
    private TextView anchor4x;
    private TextView anchor4y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anchor1Name = (TextView) findViewById(R.id.Anchor1_name);
        anchor1x = (TextView) findViewById(R.id.Anchor1_x);
        anchor1y = (TextView) findViewById(R.id.Anchor1_y);
        anchor2Name = (TextView) findViewById(R.id.Anchor2_name);
        anchor2x = (TextView) findViewById(R.id.Anchor2_x);
        anchor2y = (TextView) findViewById(R.id.Anchor2_y);
        anchor3Name = (TextView) findViewById(R.id.Anchor3_name);
        anchor3x = (TextView) findViewById(R.id.Anchor3_x);
        anchor3y = (TextView) findViewById(R.id.Anchor3_y);
        anchor4Name = (TextView) findViewById(R.id.Anchor4_name);
        anchor4x = (TextView) findViewById(R.id.Anchor4_x);
        anchor4y = (TextView) findViewById(R.id.Anchor4_y);
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
            Intent intent = getIntent();
            Anchor1 = intent.getParcelableExtra("Anchor1");
            Anchor2 = intent.getParcelableExtra("Anchor2");
            Anchor3 = intent.getParcelableExtra("Anchor3");
            Anchor4 = intent.getParcelableExtra("Anchor4");
            try{
                anchor1Name.setText(Anchor1.getName());
            } catch (Exception e){
                anchor1Name.setText("");
                Log.i("TAG","Problem with Anchor1 name");
            }
            try{
                anchor1x.setText(String.format("%.2f", Anchor1.getAnchorX()));
            } catch (Exception e){
                anchor1x.setText("");
                Log.i("TAG","Problem with Anchor1 x");
            }
            try{
                anchor1y.setText(String.format("%.2f", Anchor1.getAnchorY()));
            } catch (Exception e){
                anchor1y.setText("");
                Log.i("TAG","Problem with Anchor1 y");
            }
            try{
                anchor2Name.setText(Anchor2.getName());
            } catch (Exception e){
                anchor2Name.setText("");
                Log.i("TAG","Problem with Anchor2 name");
            }
            try{
                anchor2x.setText(String.format("%.2f", Anchor2.getAnchorX()));
            } catch (Exception e){
                anchor2x.setText("");
                Log.i("TAG","Problem with Anchor2 x");
            }
            try{
                anchor2y.setText(String.format("%.2f", Anchor2.getAnchorY()));
            } catch (Exception e){
                anchor2y.setText("");
                Log.i("TAG","Problem with Anchor2 y");
            }
            try{
                anchor3Name.setText(Anchor3.getName());
            } catch (Exception e){
                anchor3Name.setText("");
                Log.i("TAG","Problem with Anchor3 name");
            }
            try{
                anchor3x.setText(String.format("%.2f", Anchor3.getAnchorX()));
            } catch (Exception e){
                anchor3x.setText("");
                Log.i("TAG","Problem with Anchor3 x");
            }
            try{
                anchor3y.setText(String.format("%.2f", Anchor3.getAnchorY()));
            } catch (Exception e){
                anchor3y.setText("");
                Log.i("TAG","Problem with Anchor3 y");
            }
            try{
                anchor4Name.setText(Anchor4.getName());
            } catch (Exception e){
                anchor4Name.setText("");
                Log.i("TAG","Problem with Anchor4 name");
            }
            try{
                anchor4x.setText(String.format("%.2f", Anchor4.getAnchorX()));
            } catch (Exception e){
                anchor4x.setText("");
                Log.i("TAG","Problem with Anchor4 x");
            }
            try{
                anchor4y.setText(String.format("%.2f", Anchor4.getAnchorY()));
            } catch (Exception e){
                anchor4y.setText("");
                Log.i("TAG","Problem with Anchor4 y");
            }
        } catch (Exception e) {
            Log.i("TAG","No anchor list");
        }
    }
}
