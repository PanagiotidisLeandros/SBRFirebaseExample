package com.example.sbrfirebaseexample;

import com.google.firebase.firestore.DocumentReference;

public class Sales {
    private int item_id;
    private int squantity;
    private int emptied;
    private int sup_id;
    private String i_category;

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getSquantity() {
        return squantity;
    }

    public void setSquantity(int squantity) {
        this.squantity = squantity;
    }

    public int getEmptied() {
        return emptied;
    }

    public void setEmptied(int emptied) {
        this.emptied = emptied;
    }

    public int getSup_id() {
        return sup_id;
    }

    public void setSup_id(int sup_id) {
        this.sup_id = sup_id;
    }

    public String getI_category() {
        return i_category;
    }

    public void setI_category(String i_category) {
        this.i_category = i_category;
    }


}
