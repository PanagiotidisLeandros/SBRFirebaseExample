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
public class DeleteFragment_table1 extends Fragment {
    EditText deleditText;
    Button deletebutton;
    public DeleteFragment_table1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_table1, container, false);
        deleditText = view.findViewById(R.id.editTextdel);
        deletebutton = view.findViewById(R.id.deluser);
        deletebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Var_sitem_id = 0;
                try {
                    Var_sitem_id = Integer.parseInt(deleditText.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }
                Items item = new Items();
                item.setItem_id(Var_sitem_id);
                MainActivity.myAppDatabase.myDao().deleteItem(item);
                Toast.makeText(getActivity(),"Item deleted ",Toast.LENGTH_LONG).show();
                deleditText.setText("");

            }
        });
        return view;    }
}
