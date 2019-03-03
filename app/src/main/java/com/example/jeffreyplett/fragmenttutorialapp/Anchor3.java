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

public class Anchor3 extends Fragment {
    private Button btnNextFragment;
    private Button btnPrevFragment;
    private Button btnSubmitAnchor;
    private MyCanvasView vMapView;
    private Anchor receivedAnchor;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.anchor3_layout, container, false);

        btnNextFragment = (Button) view.findViewById(R.id.btnNextFragment);
        btnPrevFragment = (Button) view.findViewById(R.id.btnPrevFragment);
        btnSubmitAnchor = (Button) view.findViewById(R.id.btnSubmitAnchor);
        vMapView = (MyCanvasView) view.findViewById(R.id.mapView3);

        btnNextFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((SelectAnchorsActivity)getActivity()).setViewPager(3);
            }
        });

        btnPrevFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((SelectAnchorsActivity)getActivity()).setViewPager(1);
            }
        });

        btnSubmitAnchor.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try {
                    receivedAnchor = vMapView.getTempAnchor();
                    receivedAnchor.setName("Anchor 3");
                    Log.i("TAG", "Received anchor 3:\n" + receivedAnchor.getName() + "\n" + receivedAnchor.getAnchorX() + "\n" + receivedAnchor.getAnchorY());
                    ((SelectAnchorsActivity) getActivity()).setAnchor3(receivedAnchor);
                } catch (Exception e){
                    Log.i("TAG","no anchor was received");
                }
            }
        });

        return view;
    }

}
