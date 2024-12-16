package com.example.sbrfirebaseexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.List;

public class QueryFragment6 extends Fragment {
    TextView querytextresult;

    public QueryFragment6() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_query6, container, false);
        querytextresult = view.findViewById(R.id.txtqueryresult);
        String result = "";
        List<String> strings = MainActivity.myAppDatabase.myDao().getQuery3();
        for (String i: strings) {
            result = result + "\n Brand : " + i + "\n";
        }
        querytextresult.setText(result);
        querytextresult.setText(result);
        return view;    }
}