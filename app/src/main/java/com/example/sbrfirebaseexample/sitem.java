package com.example.sbrfirebaseexample;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "item_storage")
public class sitem {
    @PrimaryKey
    private int item_storage_id;

    @ColumnInfo(name = "item_storage_name")
    private String i_s_name;

    @ColumnInfo (name = "item_storage_category")
    private String i_s_category;

    @ColumnInfo (name = "item_storage_brand")
    private String i_s_brand;

    @ColumnInfo (name = "item_storage_quantity")
    private int i_s_quantity;


    public int getItem_storage_id() {
        return item_storage_id;
    }

    public void setItem_storage_id(int item_storage_id) {
        this.item_storage_id = item_storage_id;
    }

    public String getI_s_name() {
        return i_s_name;
    }

    public void setI_s_name(String i_s_name) {
        this.i_s_name = i_s_name;
    }

    public String getI_s_category() {
        return i_s_category;
    }

    public void setI_s_category(String i_s_category) {
        this.i_s_category = i_s_category;
    }

    public String getI_s_brand() {
        return i_s_brand;
    }

    public void setI_s_brand(String i_s_brand) {
        this.i_s_brand = i_s_brand;
    }

    public int getI_s_quantity() {
        return i_s_quantity;
    }

    public void setI_s_quantity(int i_s_quantity) {
        this.i_s_quantity = i_s_quantity;
    }
}
