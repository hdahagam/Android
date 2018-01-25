package com.example.hdahagam.app5;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.transition.Fade;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;

public class  Task1 extends AppCompatActivity implements RecyclerFragment.CustomOnClickRecycleViewListener{

    Toolbar toolbar_bottom;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1);
        setupWindowAnimations();

        //ActionBar actionBar = getSupportActionBar();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FragmentManager fmanager = getSupportFragmentManager();
        FragmentTransaction ft = fmanager.beginTransaction();
        Log.d("hello", "onOptionsItemSelected: brgin log");
        ft.add(R.id.task1_framelayout,RecyclerFragment.newInstance(R.id.recycler));
        Log.d("hello", "onOptionsItemSelected: end log");
        ft.addToBackStack(null);
        ft.commit();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void setupWindowAnimations() {
        Transition fade = TransitionInflater.from(this).inflateTransition(R.transition.activity_fade);
        getWindow().setEnterTransition(fade);

        Slide slide = new Slide();
        slide.setDuration(2000);
        getWindow().setReturnTransition(slide);
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