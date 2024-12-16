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
public class InsertFragment_table2 extends Fragment {
    EditText editText1,editText2,editText3,editText4;
    Button addbutton;

    public InsertFragment_table2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_insert_table2, container, false);
        editText1 = view.findViewById(R.id.editText);
        editText2 = view.findViewById(R.id.editText2);
        editText3 = view.findViewById(R.id.editText3);
        editText4 = view.findViewById(R.id.editText4);
        addbutton = view.findViewById(R.id.submit_supplier);
        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int Var_supplier_id = 0;
                try {
                    Var_supplier_id = Integer.parseInt(editText1.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }
                String Var_supplier_brand = editText2.getText().toString();
                String Var_supplier_email = editText3.getText().toString();
                String Var_supplier_addres = editText4.getText().toString();
                Suppliers supplier = new Suppliers();
                supplier.setSup_id(Var_supplier_id);
                supplier.setBrand(Var_supplier_brand);
                supplier.setEmail(Var_supplier_email);
                supplier.setAddres(Var_supplier_addres);
                MainActivity.myAppDatabase.myDao().addSuppliers(supplier);
                Toast.makeText(getActivity(),"Ola kala",Toast.LENGTH_LONG).show();
                editText1.setText("");
                editText2.setText("");
                editText3.setText("");
                editText4.setText("");
            }
        });
        return view;
    }
}
