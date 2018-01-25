package com.example.hdahagam.app6;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.HashMap;

public class Task1 extends AppCompatActivity implements RecyclerFragment.CustomOnClickRecycleViewListener{

    Toolbar toolbar_bottom;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1);
        databaseHelper = new DatabaseHelper(getApplicationContext()) ;
        databaseHelper.initializeTables () ; // initialize tables
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FragmentManager fmanager = getSupportFragmentManager();
        FragmentTransaction ft = fmanager.beginTransaction();
        Log.d("hello", "onOptionsItemSelected: brgin log");
        ft.add(R.id.task1_framelayout,RecyclerFragment.newInstance(databaseHelper));
        Log.d("hello", "onOptionsItemSelected: end log");
        ft.addToBackStack(null);
        ft.commit();
    }
    public void onRecycleViewItemClicked (View v , MyMovie movie)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fT = fm.beginTransaction();
        fT.replace(R.id.task1_framelayout, MovieDataFragment.newInstance(movie));
        fT.addToBackStack(null);
        fT.commit();
    }

}
