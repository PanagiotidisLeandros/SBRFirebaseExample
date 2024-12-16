package com.example.sbrfirebaseexample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InsertFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InsertFragment extends Fragment implements View.OnClickListener {

    Button In_St,In_F,In_Sup,In_Sale,View_St,View_F,View_Sup,View_Sale,Edit_St,Edit_F,Edit_Sup,Edit_Sale,Del_St,Del_F,Del_Sup,Del_Sale;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InsertFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InsertFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InsertFragment newInstance(String param1, String param2) {
        InsertFragment fragment = new InsertFragment();
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
        View view = inflater.inflate(R.layout.fragment_insert, container, false);
        In_St = view.findViewById(R.id.insertStorageButton);
        In_St.setOnClickListener(this);
        In_F = view.findViewById(R.id.insertOrderButton);
        In_F.setOnClickListener(this);
        In_Sup = view.findViewById(R.id.insertSupplierButton);
        In_Sup.setOnClickListener(this);
        In_Sale = view.findViewById(R.id.InsertSaleButton);
        In_Sale.setOnClickListener(this);
        View_St = view.findViewById(R.id.ViewStorageButton);
        View_St.setOnClickListener(this);
        View_F = view.findViewById(R.id.ViewOrderButton);
        View_F.setOnClickListener(this);
        View_Sup = view.findViewById(R.id.ViewSupplierButton);
        View_Sup.setOnClickListener(this);
        View_Sale = view.findViewById(R.id.ViewSalesButton);
        View_Sale.setOnClickListener(this);
        Edit_St = view.findViewById(R.id.EditStorageButton);
        Edit_St.setOnClickListener(this);
        Edit_F = view.findViewById(R.id.EditOrderButton);
        Edit_F.setOnClickListener(this);
        Edit_Sup = view.findViewById(R.id.EditSupplierButton);
        Edit_Sup.setOnClickListener(this);
        Edit_Sale = view.findViewById(R.id.EditSalesButton);
        Edit_Sale.setOnClickListener(this);
        Del_St = view.findViewById(R.id.DeleteStorageButton);
        Del_St.setOnClickListener(this);
        Del_F = view.findViewById(R.id.DeleteOrderButton);
        Del_F.setOnClickListener(this);
        Del_Sup = view.findViewById(R.id.DeleteSupplierButton);
        Del_Sup.setOnClickListener(this);
        Del_Sale = view.findViewById(R.id.DeleteSalesButton);
        Del_Sale.setOnClickListener(this);


        return view;    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.insertStorageButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new InsertFragment_table1()).addToBackStack(null).commit();
                break;
            case R.id.insertOrderButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new InsertFragment_table3()).addToBackStack(null).commit();
                break;
            case R.id.insertSupplierButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new InsertFragment_table2()).addToBackStack(null).commit();
                break;
            case R.id.InsertSaleButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new InsertFragment_table4()).addToBackStack(null).commit();
                break;
            case R.id.ViewStorageButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new fragment_view_table1()).addToBackStack(null).commit();
                break;
            case R.id.ViewOrderButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new fragment_view_table3()).addToBackStack(null).commit();
                break;
            case R.id.ViewSupplierButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new fragment_view_table2()).addToBackStack(null).commit();
                break;
            case R.id.ViewSalesButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new fragment_view_table4()).addToBackStack(null).commit();
                break;
            case R.id.EditStorageButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new UpdateFragment_table1()).addToBackStack(null).commit();
                break;
            case R.id.EditOrderButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new UpdateFragment_table3()).addToBackStack(null).commit();
                break;
            case R.id.EditSupplierButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new UpdateFragment_table2()).addToBackStack(null).commit();
                break;
            case R.id.EditSalesButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new UpdateFragment_table4()).addToBackStack(null).commit();
                break;
            case R.id.DeleteStorageButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new DeleteFragment_table1()).addToBackStack(null).commit();
                break;
            case R.id.DeleteOrderButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new DeleteFragment_table3()).addToBackStack(null).commit();
                break;
            case R.id.DeleteSupplierButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new DeleteFragment_table2()).addToBackStack(null).commit();
                break;
            case R.id.DeleteSalesButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new DeleteFragment_table4()).addToBackStack(null).commit();
                break;
        }
    }
}