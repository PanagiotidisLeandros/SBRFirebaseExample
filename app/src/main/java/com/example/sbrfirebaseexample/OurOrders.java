package com.example.sbrfirebaseexample;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(tableName = "OurOrder", primaryKeys = {"o_id","o_amount","o_cat","o_brand"},
        foreignKeys = {
        @ForeignKey(entity = Suppliers.class,
        parentColumns="Brand",
        childColumns = "o_brand",
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE),
        @ForeignKey(entity = Items.class,
        parentColumns = "item_id",
        childColumns ="o_id",
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE)
}
)
public class OurOrders {

    @ColumnInfo (name = "o_id") @NonNull
    private int o_id;

    @ColumnInfo (name="o_amount") @NonNull
    private int o_amount;

    @ColumnInfo (name="o_cat") @NonNull
    private String o_cat;

    @ColumnInfo (name="o_brand") @NonNull
    private String o_brand;

    public int getO_id() {
        return o_id;
    }

    public void setO_id(int o_id) {
        this.o_id = o_id;
    }

    public int getO_amount() {
        return o_amount;
    }

    public void setO_amount(int o_amount) {
        this.o_amount = o_amount;
    }

    @NonNull
    public String getO_cat() {
        return o_cat;
    }

    public void setO_cat(@NonNull String o_cat) {
        this.o_cat = o_cat;
    }

    @NonNull
    public String getO_brand() {
        return o_brand;
    }

    public void setO_brand(@NonNull String o_brand) {
        this.o_brand = o_brand;
    }
}
