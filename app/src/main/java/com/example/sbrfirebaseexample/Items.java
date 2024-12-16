package com.example.sbrfirebaseexample;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "Item")
public class Items {

    @PrimaryKey @ColumnInfo (name = "item_id") @NonNull
    private int item_id;

    @ColumnInfo (name="Amount") @NonNull
    private int quantity;

    @ColumnInfo (name="Category") @NonNull
    private String i_category;

    @ColumnInfo (name="ibrand") @NonNull
    private String ibrand;

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @NonNull
    public String getI_category() {
        return i_category;
    }

    public void setI_category(@NonNull String i_category) {
        this.i_category = i_category;
    }

    @NonNull
    public String getIbrand() {
        return ibrand;
    }

    public void setIbrand(@NonNull String ibrand) {
        this.ibrand = ibrand;
    }
}
