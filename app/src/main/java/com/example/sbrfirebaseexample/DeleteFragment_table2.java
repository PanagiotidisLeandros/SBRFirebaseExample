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
public class DeleteFragment_table2 extends Fragment {
    EditText deleditText;
    Button deletebutton;
    public DeleteFragment_table2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_table2, container, false);
        deleditText = view.findViewById(R.id.editTextdel);
        deletebutton = view.findViewById(R.id.delsupplier);
        deletebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Var_supplier_id = 0;
                try {
                    Var_supplier_id = Integer.parseInt(deleditText.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }
                Suppliers supplier = new Suppliers();
                supplier.setSup_id(Var_supplier_id);
                MainActivity.myAppDatabase.myDao().deleteSuppliers(supplier);
                Toast.makeText(getActivity(),"Supplier deleted ",Toast.LENGTH_LONG).show();
                deleditText.setText("");

            }
        });
        return view;    }
}
