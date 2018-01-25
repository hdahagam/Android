package com.example.hdahagam.app4;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;

public class MovieActivity extends AppCompatActivity implements MyAdapter.selectListner{
    //int saveLastUsedId;
    RecyclerView myRecyclerView;
    LinearLayoutManager myLayoutManager;
    MyAdapter myAdapter;
    Movie_Data mv = new Movie_Data();
    public static Button selectall,clearall,delete,sort;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        selectall = (Button) findViewById(R.id.selectall);
        clearall = (Button) findViewById(R.id.clearall);
        delete = (Button) findViewById(R.id.delete);
        sort = (Button) findViewById(R.id.sort);

        myRecyclerView = (RecyclerView) findViewById(R.id.cardlist);
        myLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(myLayoutManager);
        myAdapter = new MyAdapter(this , mv.getMoviesList());

//       Item Animation
        SlideInLeftAnimator animator = new SlideInLeftAnimator();
        animator.setAddDuration(300);
        animator.setRemoveDuration(300);
        myRecyclerView.setItemAnimator(animator);

        //Adapter Animation
        AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(myAdapter);
        ScaleInAnimationAdapter scale = new ScaleInAnimationAdapter(alphaAdapter);
         myRecyclerView.setAdapter(scale);


        selectall.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mv.selectall(mv.getMoviesList());
                myAdapter.notifyDataSetChanged();
            }
        });

        clearall.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mv.clearall(mv.getMoviesList());
                myAdapter.notifyDataSetChanged();
            }
        });

        delete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                ArrayList clean = new ArrayList();
                List<Map<String,?>> te = mv.getMoviesList();
                for(int i = 0; i< mv.getMoviesList().size(); i++){
                    HashMap<String,Boolean> temp= (HashMap<String, Boolean>) te.get(i);
                    Boolean selection = temp.get("selection");
                    if(selection ==true){
                        mv.getMoviesList().remove(i);
                        myAdapter.notifyItemRemoved(i);
                        i--;
                    }
                }
            }
        });

        sort.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mv.sort(mv.getMoviesList());
                myAdapter.notifyDataSetChanged();
            }
        });


    }

    @Override
    public void onClick(View v, int position) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fT = fm.beginTransaction();
        fT.replace(R.id.id_recyclerview, movieDataFragment.newInstance(mv.getItem(position)));
        fT.addToBackStack(null);
        fT.commit();
    }

    @Override
    public void onLongClick(View v, int position) {

        mv.addItem(position,(HashMap) mv.getItem(position));
        myAdapter.notifyItemInserted(position);


    }
}

