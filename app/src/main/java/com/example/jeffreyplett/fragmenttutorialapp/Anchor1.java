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
//    Intent mIntent = new Intent(this, MainActivity.class);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.anchor1_layout, container, false);
        btnNextFragment = (Button) view.findViewById(R.id.btnNextFragment);
        btnSubmitAnchor = (Button) view.findViewById(R.id.btnSubmitAnchor);

        btnNextFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getActivity(),"Going to next anchor", Toast.LENGTH_SHORT).show();
                ((SelectAnchorsActivity)getActivity()).setViewPager(1);
            }
        });


//        public void btnSubmitAnchor(View view){
//
//            Log.i("TAG","btnSubmitAnchor");
//            Toast.makeText(this, "Anchor is submitted",Toast.LENGTH_SHORT).show();
//        }

        btnSubmitAnchor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Submitting anchor", Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }
}
