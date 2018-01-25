package com.example.hdahagam.app9;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.HashMap;

public class  Task1 extends AppCompatActivity implements RecyclerFragment.CustomOnClickRecycleViewListener{

    Toolbar toolbar_bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fmanager = getSupportFragmentManager();
        FragmentTransaction ft = fmanager.beginTransaction();

        ft.add(R.id.first_frame,RecyclerFragment.newInstance(R.id.recycler));
        ft.addToBackStack(null);
        ft.commit();
    }


    public void onRecycleViewItemClicked (View v , HashMap<String,?> movie)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fT = fm.beginTransaction();
        fT.replace(R.id.first_frame, MovieDataFragment.newInstance(movie));
        fT.addToBackStack(null);
        fT.commit();
    }
}
