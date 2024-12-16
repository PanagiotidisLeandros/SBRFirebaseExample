package com.example.sbrfirebaseexample;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InsertReservesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InsertReservesFragment extends Fragment {
    EditText editText1, editText2, editText3;
    Button bn;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InsertReservesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InsertReservesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InsertReservesFragment newInstance(String param1, String param2) {
        InsertReservesFragment fragment = new InsertReservesFragment();
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
        View view = inflater.inflate(R.layout.fragment_insert_reserves, container, false);
        editText1 = view.findViewById(R.id.ReservesSidEditText1);
        editText2 = view.findViewById(R.id.ReservesBidEditText2);
        editText3 = view.findViewById(R.id.ReservesDateEditText3);
        bn = view.findViewById(R.id.insertReservesSubmitButton);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Var_sid = editText1.getText().toString();
                DocumentReference Var_sailorid = MainActivity.db.document("/Sailors/" + Var_sid);
                String Var_bid = editText2.getText().toString();
                DocumentReference Var_boatid = MainActivity.db.document("/Boats/" + Var_bid);
                String Var_date = editText3.getText().toString();
                try {
                    Reserves reserves = new Reserves();
                    reserves.setSid(Var_sailorid);
                    reserves.setBid(Var_boatid);
                    reserves.setRes_day(Var_date);
                    MainActivity.db.
                            collection("Reserves").
                            add(reserves).
                            addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Toast.makeText(getActivity(),"Reserves added.",Toast.LENGTH_LONG).show();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(getActivity(),"add operation failed.",Toast.LENGTH_LONG).show();
                                }
                            });
                } catch (Exception e) {
                    String message = e.getMessage();
                    Toast.makeText(getActivity(),message,Toast.LENGTH_LONG).show();
                }
                editText1.setText("");
                editText2.setText("");
                editText3.setText("");
            }
        });
        return view;    }
}