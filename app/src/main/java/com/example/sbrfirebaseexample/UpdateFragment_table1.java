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
public class UpdateFragment_table1 extends Fragment {
    EditText editText1,editText2,editText3,editText4,editText5;
    Button upbutton;
    public UpdateFragment_table1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_table1, container, false);
        editText1 = view.findViewById(R.id.upeditText1);
        editText3 = view.findViewById(R.id.upeditText3);
        editText4 = view.findViewById(R.id.upeditText4);
        editText5 = view.findViewById(R.id.upeditText5);
        upbutton = view.findViewById(R.id.updatesitem);
        upbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Var_sitem_id = 0;
                try {
                    Var_sitem_id = Integer.parseInt(editText1.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }
                int Var_sitem_quantity = 0;
                try {
                    Var_sitem_quantity = Integer.parseInt(editText5.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }
                String Var_item_category = editText3.getText().toString();
                String Var_item_brand = editText4.getText().toString();
                Items item = new Items();
                item.setItem_id(Var_sitem_id);
                item.setI_category(Var_item_category);
                item.setIbrand(Var_item_brand);
                item.setQuantity(Var_sitem_quantity);


                MainActivity.myAppDatabase.myDao().updateItem(item);
                Toast.makeText(getActivity(),"One record updated!",Toast.LENGTH_LONG).show();
                editText1.setText("");
                editText3.setText("");
                editText4.setText("");
                editText5.setText("");
            }
        });
        return view;    }
}
