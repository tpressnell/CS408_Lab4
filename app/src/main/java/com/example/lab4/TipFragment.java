package com.example.lab4;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TipFragment extends Fragment {

    private TextView output;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.tip_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        output = (TextView) view.findViewById(R.id.output);
        view.findViewById(R.id.calculateBtn).setOnClickListener(this::onClick);
    }

    public void onClick(View v) {
        output.setText("Hello, World!");
    }
}
