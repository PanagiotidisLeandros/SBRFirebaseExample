package com.example.sbrfirebaseexample;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "item_fridge")
public class fitem {
    @PrimaryKey
    private int item_fridge_id;

    @ColumnInfo(name = "item_fridge_name")
    private String i_f_name;

    @ColumnInfo (name = "item_fridge_category")
    private String i_f_category;

    @ColumnInfo (name = "item_fridge_brand")
    private String i_f_brand;

    @ColumnInfo (name = "item_fridge_quantity")
    private int i_f_quantity;

    public int getItem_fridge_id() {
        return item_fridge_id;
    }

    public void setItem_fridge_id(int item_fridge_id) {
        this.item_fridge_id = item_fridge_id;
    }

    public String getI_f_name() {
        return i_f_name;
    }

    public void setI_f_name(String i_f_name) {
        this.i_f_name = i_f_name;
    }

    public String getI_f_category() {
        return i_f_category;
    }

    public void setI_f_category(String i_f_category) {
        this.i_f_category = i_f_category;
    }

    public String getI_f_brand() {
        return i_f_brand;
    }

    public void setI_f_brand(String i_f_brand) {
        this.i_f_brand = i_f_brand;
    }

    public int getI_f_quantity() {
        return i_f_quantity;
    }

    public void setI_f_quantity(int i_f_quantity) {
        this.i_f_quantity = i_f_quantity;
    }
}
