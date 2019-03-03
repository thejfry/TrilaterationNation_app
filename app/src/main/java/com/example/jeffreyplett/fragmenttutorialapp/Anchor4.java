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

public class Anchor4 extends Fragment {
    private Button btnPrevFragment;
    private Button btnSubmitAnchor;
    private MyCanvasView vMapView;
    private Anchor receivedAnchor;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.anchor4_layout, container, false);

        btnPrevFragment = (Button) view.findViewById(R.id.btnPrevFragment);
        btnSubmitAnchor = (Button) view.findViewById(R.id.btnSubmitAnchor);
        vMapView = (MyCanvasView) view.findViewById(R.id.mapView4);

        btnPrevFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((SelectAnchorsActivity)getActivity()).setViewPager(2);
            }
        });

        btnSubmitAnchor.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try {
                    receivedAnchor = vMapView.getTempAnchor();
                    receivedAnchor.setName("Anchor 4");
                    Log.i("TAG", "Received anchor 4:\n" + receivedAnchor.getName() + "\n" + receivedAnchor.getAnchorX() + "\n" + receivedAnchor.getAnchorY());
                    ((SelectAnchorsActivity) getActivity()).setAnchor4(receivedAnchor);
                } catch (Exception e){
                    Log.i("TAG","no anchor was received");
                }
            }
        });

        return view;
    }

}
