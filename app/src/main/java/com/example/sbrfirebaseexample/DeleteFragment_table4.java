package com.example.sbrfirebaseexample;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

/*
 * A simple {@link Fragment} subclass.
 * Use the {@link DeleteFragment_table4#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DeleteFragment_table4 extends Fragment {
    EditText delTxt;
    EditText editText1, editText2, editText3, editText4;
    Button bn;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DeleteFragment_table4() {
        // Required empty public constructor
    }

    /*
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InsertSailorFragment.
     */
    // TODO: Rename and change types and number of parameters
    /*public static DeleteFragment_table4 newInstance(String param1, String param2) {
        /*DeleteFragment_table4 fragment = new DeleteFragment_table4();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }*/

    //@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_table4, container, false);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        delTxt= view.findViewById(R.id.saleDel_text);
        bn= view.findViewById(R.id.saleDel);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Var_item_id = 0;
                try {
                    Var_item_id = Integer.parseInt(delTxt.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }

                FirebaseFirestore db =FirebaseFirestore.getInstance();
                try {
                    String TAG = "DELETE";
                    CollectionReference col = db.collection("Sales");
                    DocumentReference doc = col.document(String.valueOf(Var_item_id));
                    doc.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Log.d(TAG, "DocumentSnapshot successfully deleted!");
                        }
                    })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.w(TAG, "Error deleting document", e);
                                }
                            });
//                    doc.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
//                        @Override
//                        public void onComplete(@NonNull Task<Void> task) {
//                            if (task.isSuccessful()){
//                                Toast.makeText(getActivity(),"Sales deleted.",Toast.LENGTH_LONG).show();
//                            }else {
//                                Toast.makeText(getActivity(),"delete operation failed.",Toast.LENGTH_LONG).show();
//                            }
//                        }
//                    }).addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//
//                        }
//                    });

                    delTxt.setText("");
                }
                catch (Exception ex)
                {
                    Log.e("DELETE",ex.getMessage());
                }


            }
        });
    }
}