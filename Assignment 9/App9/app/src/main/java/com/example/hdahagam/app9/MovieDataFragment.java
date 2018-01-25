package com.example.hdahagam.app9;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.lang.ref.WeakReference;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View rootView = inflater.inflate(R.layout.movie_fragment,container,false);
        final ImageView img = (ImageView) rootView.findViewById(R.id.imageView);
        final TextView title = (TextView) rootView.findViewById(R.id.text_title);
        final TextView avg = (TextView) rootView.findViewById(R.id.text_avg);
        final TextView id= (TextView) rootView.findViewById(R.id.text_id);
        final TextView count = (TextView) rootView.findViewById(R.id.text_count);
        final TextView overview = (TextView) rootView.findViewById(R.id.text_overview);

        title.setText(movie.get("title").toString());
        avg.setText("Voting Average: "+Double.toString((Double)movie.get("vote_average")));
        count.setText("Votes: "+movie.get("vote_count"));
        overview.setText((String)movie.get("overview"));
        id.setText("ID: "+movie.get("id"));
        String url = "http://image.tmdb.org/t/p/w185/";
        Picasso.with(getActivity().getApplicationContext()).load(url+movie.get("poster_path")).into(img);
        return rootView;
    }
}