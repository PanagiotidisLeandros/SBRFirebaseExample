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
public class fragment_view_table2 extends Fragment {
    TextView textView;
    public fragment_view_table2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_table2, container, false);
        textView = view.findViewById(R.id.txtquery_table2);
        List<Suppliers> suppliers= MainActivity.myAppDatabase.myDao().getSupplier();
        String result ="";
        for (Suppliers f: suppliers) {
            int code = f.getSup_id();
            String brand = f.getBrand();
            String email = f.getEmail();
            String addres = f.getAddres();
            result = result + "\n Id: " + code + "\n Brand: " + brand + "\n Email: " + email +
                    "\n Addres :" + addres + "\n";

        }
        textView.setText(result);
        return view;
    }
}
