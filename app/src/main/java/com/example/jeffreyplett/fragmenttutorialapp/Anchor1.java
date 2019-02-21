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
    private Anchor receivedAnchor;
//    Intent mIntent = new Intent(this, MainActivity.class);
    private Anchor1Listener listener;

    public interface Anchor1Listener{
        void onInputAnchor1Send(Anchor input);
    }

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
//                Toast.makeText(getActivity(),"Going to next anchor", Toast.LENGTH_SHORT).show();
                ((SelectAnchorsActivity)getActivity()).setViewPager(1);
            }
        });

        btnSubmitAnchor.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                try {
                    Log.i("TAG","Trying to receive an anchor");
                    receivedAnchor = vMapView.getTempAnchor();
                    receivedAnchor.setName("Anchor1");
                    Log.i("TAG", "receivedAnchor: \n" + receivedAnchor.getName() + "\n" + receivedAnchor.getAnchorX() + "\n" + receivedAnchor.getAnchorY());
                    Toast.makeText(getContext(),"Submitted anchor: \n" + receivedAnchor.getName() + "\n" + receivedAnchor.getAnchorX() + "\n" + receivedAnchor.getAnchorY(),Toast.LENGTH_LONG).show();
                } catch (Exception e){
                    Toast.makeText(getContext(),"No anchor was received",Toast.LENGTH_SHORT).show();
                    Log.i("TAG","no anchor was received");
                }
            }
        });


        return view;
    }
}
