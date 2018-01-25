package com.example.hdahagam.app5;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;

public class Task2 extends AppCompatActivity implements RecyclerFragment.CustomOnClickRecycleViewListener{
    Toolbar toolbar_bottom;
    Movie_Data movieData = new Movie_Data();
    RecyclerFragment recyclerFragment = new RecyclerFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar_bottom = (Toolbar) findViewById(R.id.toolbar_bottom);
        toolbar_bottom.inflateMenu(R.menu.toolbar_bottom);
        setUpToolBarItemSelected();



        FragmentManager fmanager = getSupportFragmentManager();
        FragmentTransaction ft = fmanager.beginTransaction();
        Log.d("hello", "onOptionsItemSelected: brgin log");
        ft.add(R.id.task1_framelayout,RecyclerFragment.newInstance(R.id.recycler));
        Log.d("hello", "onOptionsItemSelected: end log");
        ft.addToBackStack(null);
        ft.commit();
    }

    public void setUpToolBarItemSelected() {
        toolbar_bottom.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    default:
                    case R.id.sort_year:
                        RecyclerFragment recyclerFragment = (RecyclerFragment) getSupportFragmentManager().findFragmentById(R.id.task1_framelayout);
                        if(recyclerFragment instanceof RecyclerFragment) {
                            Toast.makeText(Task2.this,"Sorting Movie list by Year",Toast.LENGTH_SHORT).show();
                            recyclerFragment.SortByYear();
                        }
                        break;
                }
                return false;
            }
        });


        toolbar_bottom.setNavigationIcon(R.drawable.navigation_icon);
        toolbar_bottom.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                toolbar_bottom.setVisibility(View.GONE);
            }
        });


    }

    public void onRecycleViewItemClicked (View v , HashMap<String,?> movie)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fT = fm.beginTransaction();
        fT.replace(R.id.task1_framelayout, MovieDataFragment.newInstance(movie));
        fT.addToBackStack(null);
        fT.commit();
    }

}
