package com.example.sbrfirebaseexample;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "supplier_table")
public class supplier {
    @PrimaryKey
    private int suppliers_id;

    public void setSuppliers_id(int suppliers_id) {
        this.suppliers_id = suppliers_id;
    }

    @ColumnInfo(name = "supplier_brand")
    private String s_brand;

    @ColumnInfo (name = "supplier_email")
    private String s_email;

    @ColumnInfo (name = "supplier_addres")
    private String s_addres;

    public int getSuppliers_id() {
        return suppliers_id;
    }

    public void setSupplier_id(int suppliers_id) {
        this.suppliers_id = suppliers_id;
    }

    public String getS_brand() {
        return s_brand;
    }

    public void setS_brand(String s_brand) {
        this.s_brand = s_brand;
    }

    public String getS_email() {
        return s_email;
    }

    public void setS_email(String s_email) {
        this.s_email = s_email;
    }

    public String getS_addres() {
        return s_addres;
    }

    public void setS_addres(String s_addres) {
        this.s_addres = s_addres;
    }
}
