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
public class DeleteFragment_table3 extends Fragment {
    EditText deleditText;
    Button deletebutton;
    public DeleteFragment_table3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_table3, container, false);
        deleditText = view.findViewById(R.id.editTextdel);
        deletebutton = view.findViewById(R.id.deluser);
        deletebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Var_o_item_id = 0;
                try {
                    Var_o_item_id = Integer.parseInt(deleditText.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }
                OurOrders orders = new OurOrders();
                orders.setO_id(Var_o_item_id);
                MainActivity.myAppDatabase.myDao().deleteOrder(orders);
                Toast.makeText(getActivity(),"Order deleted ",Toast.LENGTH_LONG).show();
                deleditText.setText("");

            }
        });
        return view;    }
}
