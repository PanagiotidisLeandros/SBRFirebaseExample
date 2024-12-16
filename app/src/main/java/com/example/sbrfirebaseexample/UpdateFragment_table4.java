package com.example.sbrfirebaseexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UpdateFragment_table4#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UpdateFragment_table4 extends Fragment {
    EditText editText1, editText2, editText3, editText4,editText5;
    Button bn;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public UpdateFragment_table4() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InsertSailorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UpdateFragment_table4 newInstance(String param1, String param2) {
        UpdateFragment_table4 fragment = new UpdateFragment_table4();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_table4, container, false);
        editText1 = view.findViewById(R.id.sale_id_up);
        editText2 = view.findViewById(R.id.sale_quantity_up);
        editText3 = view.findViewById(R.id.sale_category_up);
        editText4 = view.findViewById(R.id.sale_supplier_up);
        editText5 = view.findViewById(R.id.sale_emptied_up);
        bn = view.findViewById(R.id.updatesitem);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Var_saleId = 0;
                try {
                    Var_saleId = Integer.parseInt(editText1.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }
                int Var_saleQuantity = 0;
                try {
                    Var_saleQuantity = Integer.parseInt(editText2.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }
                String Var_saleCat = editText3.getText().toString();
                int Var_saleSup = 0;
                try {
                    Var_saleSup = Integer.parseInt(editText4.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }
                int Var_saleEmpty = 0;
                try {
                    Var_saleEmpty = Integer.parseInt(editText5.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }
                try {
                    Sales sales = new Sales();
                    sales.setItem_id(Var_saleId);
                    sales.setI_category(Var_saleCat);
                    sales.setSup_id(Var_saleSup);
                    sales.setEmptied(Var_saleEmpty);
                    sales.setSquantity(Var_saleQuantity);
                    MainActivity.db.collection("Sales").
                            document(""+Var_saleId).
                            set(sales).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(getActivity(),"add operation failed.",Toast.LENGTH_LONG).show();
                                }
                            });
                } catch (Exception e) {
                    String message = e.getMessage();
                    System.out.println("PROVLIMA"+message);
                    Toast.makeText(getActivity(),message,Toast.LENGTH_LONG).show();
                }
                editText1.setText("");
                editText2.setText("");
                editText3.setText("");
                editText4.setText("");
                editText5.setText("");
            }
        });

        return view;    }
}