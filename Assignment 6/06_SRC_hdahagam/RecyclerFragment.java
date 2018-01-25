package com.example.hdahagam.app6;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.animators.ScaleInAnimator;


public class RecyclerFragment extends Fragment {
    static DatabaseHelper myDB;
    public RecyclerView myRecyclerView;
    public LinearLayoutManager myLayoutManager;
    public MyRecyclerViewAdapter myAdapter;
    TextView textViewToolbar;
    MyMovie mData = new MyMovie();
    public static List<MyMovie> movieList;
    public static Button selectall,clearall,delete,sort;

    public interface CustomOnClickRecycleViewListener {
        public void onRecycleViewItemClicked(View v, MyMovie movie);
    }
    private CustomOnClickRecycleViewListener customOnClickRvListener;


    private static final String ARG_SECTION_NUMBER = "sectionNumber";
public static RecyclerFragment newInstance(DatabaseHelper db) {
    RecyclerFragment fragment = new RecyclerFragment();
    myDB = db;
    movieList = db.getAllMovies(1);
    Bundle args = new Bundle();
    return fragment;
}


    public RecyclerFragment(){
    }



    @Override
    public void  onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        setRetainInstance(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater){

        if(menu.findItem(R.id.search_view) == null){
            menuInflater.inflate(R.menu.menu_actionbar_recycler,menu);

            SearchView searchView = (SearchView) menu.findItem(R.id.search_view).getActionView();

            if(searchView != null){
              searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
               @Override
                  public boolean onQueryTextSubmit(String query){
                  if(query.toLowerCase().equals("all"))
                   {
                       myAdapter.setDB(myDB, 1);
                       myAdapter.notifyDataSetChanged();
                       return true;
                   }
                   myDB.searchQuery(query);
                   myAdapter.setDB(myDB, 2);
                   myAdapter.notifyDataSetChanged();

                   return true;
               }

                  @Override
                  public boolean onQueryTextChange(String query){
                      return true;
                  }
              });

            }

        }

        super.onCreateOptionsMenu(menu,menuInflater);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        final View rootView = inflater.inflate(R.layout.recycler_fragment,container,false);
        customOnClickRvListener = (CustomOnClickRecycleViewListener) rootView.getContext();

        textViewToolbar= (TextView) getActivity().findViewById(R.id.textviewTB);


        myRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler);
        //Implement myRecyclerView

         myLayoutManager = new LinearLayoutManager(getActivity());
        //Implement myLayoutManager

        myRecyclerView.setLayoutManager(myLayoutManager);


        myAdapter = new MyRecyclerViewAdapter(3, myDB , getActivity().getApplicationContext());
        myRecyclerView.setAdapter(myAdapter);
        //Implement setOnClickListner to

       myAdapter.setOnClickListner(new MyRecyclerViewAdapter.OnItemClickListner(){
            @Override
            public void onItemClick(View v,int position){
                MyMovie movie =  myDB.getMovie(position+1);
                final String title = movie.getTitle();


                textViewToolbar.setText(title);
                customOnClickRvListener.onRecycleViewItemClicked(v,movie);
            }

            @Override
            public void onItemLongClick(View v,int position){


                getActivity().startActionMode(new ActionBarCallBack(position));
            }

           @Override
           public void onOverFlowMenuClick(View v,final int position){
               PopupMenu popup = new PopupMenu(getActivity(),v);
               popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                   @Override
                   public boolean onMenuItemClick(MenuItem item) {
                       switch(item.getItemId()){
                           case R.id.Item_delete:
                               mData = movieList.get(position);
                               myDB.deleteMovie(mData.getMovie_id());
                               myAdapter.setDB(myDB,1);
                               myAdapter.notifyItemRemoved(position);
                               myDB.printAllMovies();
                               return true;

                           case R.id.Item_duplicate:
                               mData = movieList.get(position);
                               myDB.duplicate(mData.getMovie_id());
                               myAdapter.setDB(myDB, 1);
                               movieList = myDB.getAllMovies(1);
                               myDB.printAllMovies();
                               myAdapter.notifyItemInserted(movieList.size());
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

        //defaultAnim();
        itemAnimation();
        adapterAnimator();
        return rootView;
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

    class ActionBarCallBack implements ActionMode.Callback{
        int position;

        public ActionBarCallBack (int position) {
            this.position = position;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode,MenuItem menuItem){
            int id = menuItem.getItemId();
            switch (id){
                case R.id.item_delete:
                   // mData.getMoviesList().remove(position);
                    myAdapter.notifyItemRemoved(position);
                    mode.finish();

                    break;
                case R.id.item_duplicate:
                   // mData.addItem(position,(HashMap)((HashMap)mData.getItem(position)).clone());
                    myAdapter.notifyItemInserted(position);
                    mode.finish();
                    break;
                default:
                    break;
            }
            return false;
        }

        @Override
        public boolean onCreateActionMode(ActionMode mode,Menu menu){
            mode.getMenuInflater().inflate(R.menu.contextual_menu,menu);
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode){

        }

        @Override
        public boolean onPrepareActionMode ( ActionMode mode , Menu menu ) {
//            HashMap movie = mData.getItem (position);
//            mode.setTitle (( String )movie.get (" title ") );
            return false ;
        }

    }
}


