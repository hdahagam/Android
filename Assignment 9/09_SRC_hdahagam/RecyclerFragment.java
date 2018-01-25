package com.example.hdahagam.app9;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.animators.ScaleInAnimator;


public class RecyclerFragment extends Fragment {

    public RecyclerView myRecyclerView;
    public LinearLayoutManager myLayoutManager;
    public MyRecyclerViewAdapter myAdapter;

    MovieData mData;


    public interface CustomOnClickRecycleViewListener {
        public void onRecycleViewItemClicked(View v, HashMap<String, ?> movie);
    }
    private CustomOnClickRecycleViewListener customOnClickRvListener;


    private static final String ARG_SECTION_NUMBER = "sectionNumber";


    public static  RecyclerFragment newInstance(int sectionNumber)
    {
        RecyclerFragment fragment = new RecyclerFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return  fragment;
    }


    public RecyclerFragment(){
    }


    @Override
    public void  onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        setRetainInstance(true);
        mData = new MovieData();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        final View rootView = inflater.inflate(R.layout.recycler_fragment,container,false);
        customOnClickRvListener = (CustomOnClickRecycleViewListener) rootView.getContext();



        myRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler);
        myRecyclerView.setHasFixedSize(true);


         myLayoutManager = new LinearLayoutManager(getActivity());

        myRecyclerView.setLayoutManager(myLayoutManager);

        //Implement Adapter
        myAdapter = new MyRecyclerViewAdapter(getActivity(),mData.getMoviesList());


        myRecyclerView.setAdapter(myAdapter);

        if(mData.getSize() == 0)
        {
            mData.setMyRecyclerAdapter(myAdapter);
            mData.setContext(getActivity());
            mData.initializeDataFromCloud();
        }

       myAdapter.setOnClickListner(new MyRecyclerViewAdapter.OnItemClickListner(){
            @Override
            public void onItemClick(View v,int position){
                Toast.makeText(getContext(),"Movie "+(position+1)+" selected",Toast.LENGTH_SHORT).show();
                itemClicked(v, position);
            }

            @Override
            public void onItemLongClick(View v,int position){
                // no action
            }

           @Override
           public void onOverFlowMenuClick(View v,final int position){
               PopupMenu popup = new PopupMenu(getActivity(),v);
               popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                   @Override
                   public boolean onMenuItemClick(MenuItem item) {
                       switch(item.getItemId()){
                           case R.id.Item_delete:
                               HashMap deletemovie = mData.getItem(position);
                               mData.deleteItemFromFirebase(deletemovie);
                               return true;

                           case R.id.Item_duplicate:
                               HashMap oldmovie = (HashMap) ((HashMap)mData.getItem(position)).clone();
                               oldmovie.put("title", oldmovie.get("title")+"_new");
                               mData.addItemToFirebase(oldmovie);
                               return true;
                           default:
                               return false;
                       }
                   }
               });

               MenuInflater inflater1 = popup.getMenuInflater();
               inflater1.inflate(R.menu.popup_menu,popup.getMenu());
               popup.show();

           }
        });

        itemAnimation();
        adapterAnimator();
        return rootView;
    }

    public void itemClicked(View view,int position) {
        final View vw = view;
        if (position < 0) {
            //Error check
            Log.d("MY DEBUG", "Activity -onItemClicked -No Data");
            return;
        }
        HashMap<String, ?> movie = (HashMap<String, ?>) mData.getItem(position);
        String title = String.valueOf(movie.get("title"));
        FirebaseDatabase.getInstance().getReference().child("moviedata").child(title).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                HashMap<String, String> movie = (HashMap<String, String>) dataSnapshot.getValue();
                customOnClickRvListener.onRecycleViewItemClicked(vw, movie);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("FBTest: ", "Cannot read movie detail " + databaseError.getMessage());
            }
        });

    }


    private  void defaultAnim(){
        DefaultItemAnimator anim = new DefaultItemAnimator();
        anim.setAddDuration(5000);
        anim.setRemoveDuration(5000);
        myRecyclerView.setItemAnimator(anim);
    }


    private void itemAnimation(){
        ScaleInAnimator anim = new ScaleInAnimator();
        anim.setAddDuration(500);
        anim.setRemoveDuration(500);
        myRecyclerView.setItemAnimator(anim);
    }

    private void adapterAnimator(){
        AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(myAdapter);
        ScaleInAnimationAdapter scale = new ScaleInAnimationAdapter(alphaAdapter);
        myRecyclerView.setAdapter(scale);
    }
}



