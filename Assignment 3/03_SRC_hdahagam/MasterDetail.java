package com.example.hdahagam.app3;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class MasterDetail extends AppCompatActivity implements MovieChoice.MovieFragment {
    movie_data movieData;
    private boolean mdetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        if(savedInstanceState ==null) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.MasterFrag, MovieChoice.newInstance());
            //ft.addToBackStack(null);
            ft.commit();
        }
        if(findViewById(R.id.DetailFrag)!=null){
            mdetail = true;
        }
    }

    public void onButtonsclicked (View v, int i){
        movieData = new movie_data();
        if(mdetail ==true){

            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.DetailFrag, movieDataFragment.newInstance(movieData.getItem(i)));
            //Integer printelem = i;
            ft.commit();
        }
        else {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.MasterFrag, movieDataFragment.newInstance(movieData.getItem(i)));
            ft.addToBackStack(null);
            ft.commit();
        }
    }
}
