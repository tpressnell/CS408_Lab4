package com.example.lab4;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

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
        textBill = (EditText) view.findViewById(R.id.mealCost);
        textPercent = (EditText) view.findViewById(R.id.tipPercent);
        textNumPeople = (EditText) view.findViewById(R.id.numPeople);
        view.findViewById(R.id.calculateBtn).setOnClickListener(this::onClick);
    }

    public void onClick(View v) {
        double bill;
        double percent;
        double numPeople;
        double costPerPerson;
        DecimalFormat df = new DecimalFormat("#.00");

        try {

            bill = Double.parseDouble(textBill.getText().toString());
            percent = Double.parseDouble(textPercent.getText().toString());
            numPeople = Double.parseDouble(textNumPeople.getText().toString());
            percent = percent * .01;
            costPerPerson = (bill + (bill * percent)) / numPeople;
            costPerPerson = Double.parseDouble(df.format(costPerPerson));


            output.setText("$" + costPerPerson);
        }

        catch(Exception e){
            output.setText("onClickTriggered");
        }
    }
}
