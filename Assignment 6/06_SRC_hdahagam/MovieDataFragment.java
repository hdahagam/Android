package com.example.hdahagam.app6;

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

import com.squareup.picasso.Picasso;

import java.util.HashMap;

public class MovieDataFragment extends Fragment {
    public static MyMovie movie;


    public static MovieDataFragment newInstance(MyMovie mv) {
        MovieDataFragment fragment = new MovieDataFragment();
        movie = mv;
        Bundle args = new Bundle();
        //args.put("movie", mv);
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
        menuInflater.inflate(R.menu.menu_moviedata,menu);

//        MenuItem menuItem = menu.findItem(R.id.action_share);
//        ShareActionProvider mySharedActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);

        Intent intentShare = new Intent(Intent.ACTION_SEND);
        intentShare.setType("text/plain");
        //intentShare.putExtra(Intent.EXTRA_TEXT,(String) movie.get("title"));

       // mySharedActionProvider.setShareIntent(intentShare);

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

           id.setText("MOVIE ID: "+Integer.toString((Integer) movie.getMovie_id()));

        title.setText(movie.getTitle());
        avg.setText("AVERAGE VOTES: "+Double.toString((Double)movie.getVote_avg()));
        count.setText("TOTAL VOTES: "+Integer.toString((Integer)movie.getVote_cnt()));
        overview.setText((String)movie.getOverview());
        String url = "http://image.tmdb.org/t/p/w185/";
        Picasso.with(getActivity()).load(url+movie.getPoster()).into(img);
        return rootView;
    }
}