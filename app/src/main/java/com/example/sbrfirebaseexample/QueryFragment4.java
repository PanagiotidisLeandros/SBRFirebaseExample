package com.example.sbrfirebaseexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.List;

public class QueryFragment4 extends Fragment {
    TextView querytextresult;

    public QueryFragment4() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_query4, container, false);
        querytextresult = view.findViewById(R.id.txtqueryresult);
        String result = "";
        List<OurOrders> OurOrders = MainActivity.myAppDatabase.myDao().getQuery1();
        for(OurOrders o: OurOrders){
            Integer o_id = o.getO_id();
            Integer o_amount = o.getO_amount();
            String o_cat = o.getO_cat();
            String o_brand = o.getO_brand();
            result = result + "\n o_id: " + o_id + "\n o_amount: " + o_amount + "\n o_cat: " + o_cat +
                    "\n o_brand : " + o_brand + "\n";
        }
        querytextresult.setText(result);
        return view;    }
}