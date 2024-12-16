package com.example.sbrfirebaseexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public static FragmentManager fragmentManager;
    public static FirebaseFirestore db;
    private DrawerLayout drawer;

    public static MyAppDatabase myAppDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = FirebaseFirestore.getInstance();
        fragmentManager = getSupportFragmentManager();
        myAppDatabase = Room.databaseBuilder(getApplicationContext(),MyAppDatabase.class,"userBD").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        if(findViewById(R.id.fragment_container)!=null){
            if(savedInstanceState!=null){
                return;
            }
            fragmentManager.beginTransaction().add(R.id.fragment_container, new InsertFragment()).commit();
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_add_table1:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new InsertFragment_table1()).commit();
                break;
            case R.id.nav_edit_table1:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new UpdateFragment_table1()).commit();
                break;
            case R.id.nav_delete_table1:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new DeleteFragment_table1()).commit();
                break;
            case R.id.nav_view_Table1:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new fragment_view_table1()).commit();
                break;
            case R.id.nav_add_table2:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new InsertFragment_table3()).commit();
                break;
            case R.id.nav_edit_table2:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new UpdateFragment_table3()).commit();
                break;
            case R.id.nav_delete_table2:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new DeleteFragment_table3()).commit();
                break;
            case R.id.nav_view_Table2:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new fragment_view_table3()).commit();
                break;
            case R.id.nav_add_table3:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new InsertFragment_table2()).commit();
                break;
            case R.id.nav_edit_table3:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new UpdateFragment_table2()).commit();
                break;
            case R.id.nav_delete_table3:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new DeleteFragment_table2()).commit();
                break;
            case R.id.nav_view_Table3:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new fragment_view_table2()).commit();
                break;
            case R.id.nav_add_table4:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new InsertFragment_table4()).commit();
                break;
            case R.id.nav_edit_table4:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new UpdateFragment_table4()).commit();
                break;
            case R.id.nav_delete_table4:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new DeleteFragment_table4()).commit();
                break;
            case R.id.nav_view_Table4:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new fragment_view_table4()).commit();
                break;
            case R.id.query1:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new QueryFragment1()).commit();
                break;
            case R.id.query2:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new QueryFragment2()).commit();
                break;
            case R.id.query3:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new QueryFragment3()).commit();
                break;
            case R.id.query4:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new QueryFragment4()).commit();
                break;
            case R.id.query5:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new QueryFragment5()).commit();
                break;
            case R.id.query6:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new QueryFragment6()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}