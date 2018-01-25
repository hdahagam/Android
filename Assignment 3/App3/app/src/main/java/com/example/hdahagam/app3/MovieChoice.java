package com.example.hdahagam.app3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class MovieChoice extends Fragment {
    // public static HashMap<String, ?> hmp;
    public int indexposition =0;
    public interface MovieFragment {
        public void onButtonsclicked(View v,int position);
    }
    private MovieFragment MvFrag;
    public static MovieChoice newInstance() {
        MovieChoice  fragment= new MovieChoice();
        return fragment;
    }
    public MovieChoice(){
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance)
    {
        View rootView = inflater.inflate(R.layout.fragment_movie_choice,container,false);
        final TextView textView = (TextView) rootView.findViewById(R.id.textView3);
        Integer position = indexposition;
        textView.setText(position.toString());
        Button prev = (Button) rootView.findViewById(R.id.imageButton2);
        Button next = (Button) rootView.findViewById(R.id.imageButton);
        MvFrag = (MovieFragment) rootView.getContext();
        prev.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Integer no_of_mvs = (Integer.parseInt(textView.getText().toString()));
                if(no_of_mvs>0){
                    no_of_mvs--;
                    indexposition = no_of_mvs;
                    textView.setText(no_of_mvs.toString());
                }
                MvFrag.onButtonsclicked(v,no_of_mvs);
            }
        });
        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Integer no_of_mvs = (Integer.parseInt(textView.getText().toString()));
                if(no_of_mvs < 24){
                    no_of_mvs++;
                    indexposition = no_of_mvs;
                    textView.setText((no_of_mvs.toString()));
                }
                MvFrag.onButtonsclicked(v,no_of_mvs);
            }
        });
        return rootView;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            indexposition = savedInstanceState.getInt("indexposition");
        }
    }
    @Override
    public void onSaveInstanceState(Bundle outstate) {
        super.onSaveInstanceState(outstate);
        outstate.putInt("indexposition", indexposition);
    }
}
