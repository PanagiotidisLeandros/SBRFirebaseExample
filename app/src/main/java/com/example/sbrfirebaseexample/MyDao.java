package com.example.sbrfirebaseexample;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MyDao {
    @Insert
    public void addSitem(sitem sitem);

    @Insert
    public void addItem(Items item);
    @Insert
    public void addSuppliers(Suppliers supplier);

    @Insert
    public void addOrder(OurOrders order);

    @Query("select * from item_storage")
    public List<sitem> getSitems();

    @Query("select * from Item") //TODO Find what this is
    public List<Items> getItems();

    @Query("select * from Item where item_id = :id") //TODO Find what this is
    public List<Items> getItem(int id);

    @Query("select * from Supplier where sup_id = :id") //TODO Find what this is
    public List<Suppliers> getSupplier(int id);

    @Query("select * from Supplier")
    public List<Suppliers> getSupplier();

    @Query("select * from OurOrder")
    public List<OurOrders> getOrder();

    @Delete
    public void deleteItem(Items item);

    @Delete
    public void deleteSuppliers(Suppliers suppliers);

    @Delete
    public void deleteOrder(OurOrders OurOrder);
    @Update
    public void updateItem(Items item);
    @Update
    public void updateSuppliers(Suppliers suppliers);
    @Update
    public void updateOrder(OurOrders orders);

    @Delete
    public void deleteSitem(sitem sitem);


    @Update
    public void updateSitem(sitem sitem);



    @Insert
    public void addFitem(fitem fitem);

    @Query("select * from item_fridge")
    public List<fitem> getFitems();

    @Delete
    public void deleteFitem(fitem fitem);

    @Update
    public void updateFitem(fitem fitem);


    @Insert
    public void addSupplier(supplier supplier);

    @Query("select * from supplier_table")
    public List<supplier> getSuppliers();

    @Delete
    public void deleteSupplier(supplier supplier);

    @Update
    public void updateSupplier(supplier supplier);

    @Query("SELECT * " +
            "FROM OurOrder O "
            + "WHERE O.o_brand = 'Mebgal' AND O.o_amount > 10 ")
    public List<OurOrders> getQuery1();

    @Query("SELECT * " +
            "FROM Item I "
            + "WHERE I.Category = 'Storage' AND I.Amount < 10 ")
    public List<Items> getQuery2();

    @Query("SELECT DISTINCT I.ibrand " +
            "FROM Item I INNER JOIN Supplier S ON I.ibrand = S.Brand " +
            "WHERE I.Category = 'Storage' " +
            "INTERSECT " +
            "SELECT DISTINCT I.ibrand " +
            "FROM Item I INNER JOIN Supplier S ON I.ibrand = S.Brand " +
            "WHERE I.Category = 'Fridge' ")
    public List<String> getQuery3();
}
