package com.example.sbrfirebaseexample;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class QueryFragment1 extends Fragment {
    TextView textView;

    private ListView list = null;
    public QueryFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_table4, container, false);
        textView = view.findViewById(R.id.txtquery_table4);
        list = view.findViewById(R.id.list);
        RefreshData();
        return view;
    }

    public void RefreshData()
    {
        CollectionReference collectionReference = MainActivity.db.
                collection("Sales");
        Query query = collectionReference.whereEqualTo("i_category", "Fridge");
        query.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                ArrayList<Sales> sales = new ArrayList<>();
                for(QueryDocumentSnapshot documentSnapshot: queryDocumentSnapshots){
                    Sales sale = documentSnapshot.toObject(Sales.class);
                    sales.add(sale);
                }
                if (sales.size()==0)
                {
                    list.setAdapter(null);
                }
                else
                    list.setAdapter(new SalesAdapter(getContext(),sales));
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(),"query operation failed.",Toast.LENGTH_LONG).show();
                list.setAdapter(null);
            }});
    }
    public class SalesAdapter extends ArrayAdapter<Sales>
    {
        private ArrayList<Sales> values;
        private Context context;

        public SalesAdapter(@NonNull Context context, @NonNull ArrayList<Sales> objects) {
            super(context, R.layout.list_sales_item, objects);
            this.values = objects;
            this.context = context;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = convertView;
            final Sales s = values.get(position);
            if (convertView == null) {
                rowView = inflater.inflate(R.layout.list_sales_item, parent, false);
            }
            TextView txtID = rowView.findViewById(R.id.item_id);
            TextView txtCateg = rowView.findViewById(R.id.item_category);
            TextView txtQuant = rowView.findViewById(R.id.item_quantity);
            TextView txtSup = rowView.findViewById(R.id.item_sup);
            TextView txtEmpty = rowView.findViewById(R.id.item_emptied);
            txtID.setText(String.valueOf(s.getItem_id()));
            txtCateg.setText(s.getI_category());
            txtQuant.setText(String.valueOf(s.getSquantity()));
            txtSup.setText(String.valueOf(s.getSup_id()));
            txtEmpty.setText(String.valueOf(s.getEmptied()));
            return rowView;
        }
    }
}
