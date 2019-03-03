package com.example.jeffreyplett.fragmenttutorialapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Anchor1 extends Fragment {
    private Button btnNextFragment;
    private Button btnSubmitAnchor;
    private MyCanvasView vMapView;
    private Anchor tempAnchor;
    private Anchor receivedAnchor;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.anchor1_layout, container, false);

        btnNextFragment = (Button) view.findViewById(R.id.btnNextFragment);
        btnSubmitAnchor = (Button) view.findViewById(R.id.btnSubmitAnchor);
        vMapView = (MyCanvasView) view.findViewById(R.id.mapView1);

        btnNextFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            ((SelectAnchorsActivity)getActivity()).setViewPager(1);
            }
        });

        btnSubmitAnchor.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.i("TAG", "Trying to submit anchor");
//                receivedAnchor = vMapView.getTempAnchor();
                try {
                    receivedAnchor = tempAnchor;
                    receivedAnchor.setName("Anchor 1");
                    Log.i("TAG", "Received anchor 1:\n" + receivedAnchor.getName() + "\n" + receivedAnchor.getAnchorX() + "\n" + receivedAnchor.getAnchorY());
                    ((SelectAnchorsActivity) getActivity()).setAnchor1(receivedAnchor);
                } catch (Exception e){
                    Log.i("TAG","no anchor was received");
                }
            }
        });

        return view;
    }

    public void setTempAnchor(Anchor tempAnchor) {
        this.tempAnchor = tempAnchor;
    }
}
