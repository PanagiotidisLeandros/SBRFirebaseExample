package com.example.sbrfirebaseexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.List;

public class QueryFragment5 extends Fragment {
    TextView querytextresult;

    public QueryFragment5() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_query5, container, false);
        querytextresult = view.findViewById(R.id.txtqueryresult);
        String result = "";
        List<Items> items = MainActivity.myAppDatabase.myDao().getQuery2();
        for(Items i: items){
            int item_id = i.getItem_id();
            String Category = i.getI_category();
            String ibrand = i.getIbrand();
            int Amount = i.getQuantity();
            result = result + "\n item_id: " + item_id + "\n Category: " + Category + "\n ibrand: " + ibrand +
                    "\n Amount : " + Amount + "\n";
        }
        querytextresult.setText(result);
        return view;    }
}