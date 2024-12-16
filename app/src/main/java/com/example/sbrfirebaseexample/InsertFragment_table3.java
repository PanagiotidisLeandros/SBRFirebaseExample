package com.example.sbrfirebaseexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class InsertFragment_table3 extends Fragment {
    EditText editText1,editText2,editText3,editText4,editText5;
    Button addbutton;

    public InsertFragment_table3() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_insert_table3, container, false);
        editText1 = view.findViewById(R.id.editText);
        editText3 = view.findViewById(R.id.editText3);
        editText4 = view.findViewById(R.id.editText4);
        editText5 = view.findViewById(R.id.editText5);
        addbutton = view.findViewById(R.id.submit_order);
        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int Var_fitem_id = 0;
                try {
                    Var_fitem_id = Integer.parseInt(editText1.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }
                int Var_amount = 0;
                try {
                    Var_amount = Integer.parseInt(editText5.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }
                String Var_item_category = editText3.getText().toString();
                String Var_item_brand = editText4.getText().toString();
                OurOrders orders = new OurOrders();
                orders.setO_id(Var_fitem_id);
                orders.setO_cat(Var_item_category);
                orders.setO_brand(Var_item_brand);
                orders.setO_amount(Var_amount);
                MainActivity.myAppDatabase.myDao().addOrder(orders);
                Toast.makeText(getActivity(),"Ola kala",Toast.LENGTH_LONG).show();
                editText1.setText("");
                editText3.setText("");
                editText4.setText("");
                editText5.setText("");
            }
        });
        return view;
    }
}
