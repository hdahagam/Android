package com.example.hdahagam.app3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

public class movieDataFragment extends Fragment {
    public static HashMap<String, ?> movie;


    public static movieDataFragment newInstance(HashMap<String, ?> mv) {
        movieDataFragment fragment = new movieDataFragment();
        //movie = mv;
        Bundle args = new Bundle();
        args.putSerializable("movie", mv);
        fragment.setArguments(args);
        return fragment;
    }
    public movieDataFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {

        View rootView = inflater.inflate(R.layout.fragment_movie_data,container,false);
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
        return rootView;
    }
}