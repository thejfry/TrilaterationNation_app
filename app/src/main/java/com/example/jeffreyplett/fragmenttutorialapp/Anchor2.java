package com.example.jeffreyplett.fragmenttutorialapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Anchor2 extends Fragment {
    private Button btnNextFragment;
    private Button btnPrevFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.anchor2_layout, container, false);
        btnNextFragment = (Button) view.findViewById(R.id.btnNextFragment);
        btnPrevFragment = (Button) view.findViewById(R.id.btnPrevFragment);

        btnNextFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getActivity(),"Going to next anchor", Toast.LENGTH_SHORT).show();
                ((SelectAnchorsActivity)getActivity()).setViewPager(2);
            }
        });

        btnPrevFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getActivity(),"Going to next anchor", Toast.LENGTH_SHORT).show();
                ((SelectAnchorsActivity)getActivity()).setViewPager(0);
            }
        });

        return view;
    }
}
