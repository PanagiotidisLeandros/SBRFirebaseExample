package com.example.sbrfirebaseexample;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Supplier")
public class Suppliers {

    @ColumnInfo (name = "sup_id") @NonNull
    private int sup_id;

    @PrimaryKey @ColumnInfo(name = "Brand") @NonNull
    private String brand;

    @ColumnInfo (name = "supplier_email") @NonNull
    private String email;

    @ColumnInfo (name = "supplier_addres") @NonNull
    private String addres;

    public int getSup_id() {
        return sup_id;
    }

    public void setSup_id(int sup_id) {
        this.sup_id = sup_id;
    }

    @NonNull
    public String getBrand() {
        return brand;
    }

    public void setBrand(@NonNull String brand) {
        this.brand = brand;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    @NonNull
    public String getAddres() {
        return addres;
    }

    public void setAddres(@NonNull String addres) {
        this.addres = addres;
    }
}
