package com.example.hdahagam.app9;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hdahagam on 11/10/2017.
 */

public class MovieData {

    List<Map<String,?>> moviesList;
    DatabaseReference myRef;
    MyRecyclerViewAdapter myRecyclerAdapter;
    Context context;

    public void setMyRecyclerAdapter(MyRecyclerViewAdapter myRecyclerAdapter) {
        this.myRecyclerAdapter = myRecyclerAdapter;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public int getSize(){
        return moviesList.size();
    }

    public List< Map < String , ?>> getMoviesList () {
        return moviesList ;
    }

    public HashMap getItem (int i){
        if (i >=0 && i < moviesList . size () ){
            return ( HashMap ) moviesList . get ( i);
        }
        else
            return null ;
    }

    public MovieData(){ moviesList = new ArrayList<Map<String ,?>>();
        myRef = FirebaseDatabase.getInstance().getReference();
    }

    public void initializeDataFromCloud(){
        moviesList.clear();
        myRef.child("moviedata").addChildEventListener(new ChildEventListener()
        {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot , String s)
            {
                Log.d("FBTest: OnChildAdded", dataSnapshot.toString());
                HashMap<String , String > movie = (HashMap <String , String >) dataSnapshot.getValue();
                onItemAddedToCloud(movie);
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot , String s)
            {
                Log.d("FBTest: OnChildUpdated", dataSnapshot.toString());
                HashMap <String , String > movie = (HashMap <String , String >) dataSnapshot.getValue();
                onItemUpdatedInCloud(movie);
            }
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot)
            {
                Log.d("FBTest: OnChildDeleted", dataSnapshot.toString());
                HashMap <String , String > movie = (HashMap <String , String >) dataSnapshot.getValue();
                onItemDeletedFromCloud(movie);
            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot , String s) {
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    private void onItemAddedToCloud(HashMap item)
    {
        String id = String.valueOf(item.get("original_title"));
        int insertPos = 0;
        for( int i = 0; i < moviesList.size(); i++ )
        {
            HashMap movie = (HashMap) moviesList.get(i);
            String movieId = String.valueOf(movie.get("title"));
            if(movieId.equals(id))
            {
                break;
            }
            else if(movieId.compareTo(id) < 0)
            {
                insertPos = i+1;
            }
            else
                break;
        }
        moviesList.add(insertPos , item);
        Log.d("FBTest: notifyInserted ", id);
        if(myRecyclerAdapter != null)
        {
            myRecyclerAdapter.notifyItemInserted(insertPos);
        }
    }

    private void onItemUpdatedInCloud(HashMap item)
    {
        String id = String.valueOf(item.get("title"));
        for (int i = 0; i < moviesList.size(); i++)
        {
            HashMap movie = (HashMap) moviesList.get(i);
            String movieId = (String) movie.get("title");
            if (movieId.equals(id))
            {
                moviesList.remove(i);
                moviesList.add(i, item);
                Toast.makeText(context, "Item Updated: " + id, Toast.LENGTH_SHORT).show();
                Log.d("FBTest: notifyUpdated ", id);
                if (myRecyclerAdapter != null)
                {
                    myRecyclerAdapter.notifyItemChanged(i);
                }
                break;
            }
        }
    }

    public void addItemToFirebase(Map<String ,?> movie)
    {
        if( movie != null )
        {
            String id = String.valueOf(movie.get("title"));
            myRef.child("moviedata").child(id).setValue(movie);
        }
    }

    private void onItemDeletedFromCloud(HashMap item) {
        int pos = -1;
        String id = (String) item.get("title");
        for (int i = 0; i < moviesList.size(); i++) {
            HashMap movie = (HashMap) moviesList.get(i);
            String movieId = String.valueOf(movie.get("title"));
            if (movieId.equals(id)) {
                pos = i;
                break;
            }
        }
        if (pos != -1) {
            moviesList.remove(pos);
            Log.d("FBTest: notifyDeleted ", id);
            Toast.makeText(context, "Item Deleted: " + id, Toast.LENGTH_SHORT).show();
            if (myRecyclerAdapter != null) {
                myRecyclerAdapter.notifyItemRemoved(pos);
                myRecyclerAdapter.notifyDataSetChanged();
            }
        }
    }

    public void deleteItemFromFirebase(Map<String , ?> movie)
    {
        if( movie != null )
        {
            String id = (String) movie.get("title");
            myRef.child("moviedata").child(id).removeValue();
        }
    }
}