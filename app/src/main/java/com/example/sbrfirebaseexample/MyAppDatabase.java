package com.example.sbrfirebaseexample;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {sitem.class, fitem.class, supplier.class, Items.class,Suppliers.class, OurOrders.class}, version = 2)
public abstract class MyAppDatabase extends RoomDatabase {
    public abstract MyDao myDao();

}
