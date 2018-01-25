package com.example.hdahagam.app10;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.ShareActionProvider;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

public class MovieDataFragment extends Fragment {
    public static HashMap<String, ?> movie;


    public static MovieDataFragment newInstance(HashMap<String, ?> mv) {
        MovieDataFragment fragment = new MovieDataFragment();
        movie = mv;
        Bundle args = new Bundle();
        args.putSerializable("movie", mv);
        fragment.setArguments(args);
        return fragment;
    }
    public MovieDataFragment(){

    }
    @Override
    public void  onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        setRetainInstance(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater){
       // menuInflater.inflate(R.menu.menu_moviedata,menu);

        //MenuItem menuItem = menu.findItem(R.id.action_share);
        //ShareActionProvider mySharedActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);

        Intent intentShare = new Intent(Intent.ACTION_SEND);
        intentShare.setType("text/plain");
        intentShare.putExtra(Intent.EXTRA_TEXT,(String) movie.get("title"));

        //mySharedActionProvider.setShareIntent(intentShare);

        super.onCreateOptionsMenu(menu,menuInflater);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View rootView = inflater.inflate(R.layout.movie_fragment,container,false);
        final ImageView img = (ImageView) rootView.findViewById(R.id.imageView);
        final TextView title = (TextView) rootView.findViewById(R.id.text_title);
        final TextView avg = (TextView) rootView.findViewById(R.id.text_avg);
        final TextView id= (TextView) rootView.findViewById(R.id.text_id);
        final TextView count = (TextView) rootView.findViewById(R.id.text_count);
        final TextView overview = (TextView) rootView.findViewById(R.id.text_overview);
        movie = (HashMap<String, ?>) getArguments().getSerializable("movie");
        title.setText(movie.get("title").toString());
        avg.setText("Voting Average: "+Double.toString((Double)movie.get("voteAverage")));
        count.setText("Votes: "+Integer.toString((Integer)movie.get("voteCount")));
        overview.setText((String)movie.get("overview"));
        id.setText("ID: "+Integer.toString((Integer) movie.get("id")));
        int k = (Integer) movie.get("image");
        img.setImageResource(k);
        img.setTransitionName(movie.get("title").toString());
        return rootView;
    }
}