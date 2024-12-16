package com.example.sbrfirebaseexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.List;
import java.util.function.Supplier;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_view_table3 extends Fragment {
    TextView textView;
    public fragment_view_table3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_table3, container, false);
        textView = view.findViewById(R.id.txtquery_table3);
        List<OurOrders> orders = MainActivity.myAppDatabase.myDao().getOrder();
        String result ="";
        for (OurOrders s: orders) {
            int code = s.getO_id();
            int amount = s.getO_amount();
            String brand = s.getO_brand();
            String cat = s.getO_cat();
            result = result + "\n Id: " + code + "\n Brand: " + brand + "\n Category: "+ cat +"\n Amount: " + amount + "\n";

        }
        textView.setText(result);
        return view;
    }
}
