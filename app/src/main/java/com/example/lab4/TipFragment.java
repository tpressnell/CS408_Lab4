package com.example.lab4;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class TipFragment extends Fragment {

    private TextView output;
    private EditText textBill;
    private EditText textPercent;
    private EditText textNumPeople;

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
        Double bill;
        Double percent;
        int numPeople;
        Double costPerPerson;


        textBill = (EditText) v.findViewById(R.id.mealCost);
        bill = Double.parseDouble(textBill.getText().toString());

        textPercent = (EditText) v.findViewById(R.id.tipPercent);
        percent = Double.parseDouble(textPercent.getText().toString());

        textNumPeople = (EditText) v.findViewById(R.id.mealCost);
        numPeople = Integer.parseInt(textNumPeople.getText().toString());

        percent = percent * .01;

        costPerPerson = (bill + (bill * percent)) / numPeople;

        output.setText("$" + costPerPerson);
    }
}
