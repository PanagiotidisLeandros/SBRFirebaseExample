package com.example.sbrfirebaseexample;

import com.google.firebase.firestore.DocumentReference;

public class Reserves {
    private DocumentReference sid;
    private DocumentReference bid;
    private String res_day;

    public DocumentReference getSid() {
        return sid;
    }

    public void setSid(DocumentReference sid) {
        this.sid = sid;
    }

    public DocumentReference getBid() {
        return bid;
    }

    public void setBid(DocumentReference bid) {
        this.bid = bid;
    }

    public String getRes_day() {
        return res_day;
    }

    public void setRes_day(String res_day) {
        this.res_day = res_day;
    }
}
