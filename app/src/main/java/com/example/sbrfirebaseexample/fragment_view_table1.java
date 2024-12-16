package com.example.sbrfirebaseexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_view_table1 extends Fragment {
    TextView textView;
    public fragment_view_table1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_table1, container, false);
        textView = view.findViewById(R.id.txtquery_table1);
        List<Items> item = MainActivity.myAppDatabase.myDao().getItems();
        String result ="";
        for (Items i: item) {
            int code = i.getItem_id();
            String category = i.getI_category();
            String brand = i.getIbrand();
            int quantity = i.getQuantity();
            result = result + "\n Id: " + code + "\n Category: " + category +
                    "\n brand : " + brand + "\n quantity :" + quantity + "\n";

        }
        textView.setText(result);
        return view;
    }
}
