package com.example.jeffreyplett.fragmenttutorialapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Fragment1 extends Fragment {
    private Button btnNextFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1_layout, container, false);
        btnNextFragment = (Button) view.findViewById(R.id.btnNextFragment);

        btnNextFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Going to next fragment", Toast.LENGTH_SHORT).show();
                ((FragmentActivity)getActivity()).setViewPager(1);
            }
        });

        return view;
    }
}
