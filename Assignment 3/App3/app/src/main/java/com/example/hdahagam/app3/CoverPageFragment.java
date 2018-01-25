package com.example.hdahagam.app3;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CoverPageFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CoverPageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
interface OnListItemSelectedListener {
    public void OnListItemSelected(int postition);
}
public class CoverPageFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private OnListItemSelectedListener loadFrame;

    // TODO: Rename and change types of parameters


    public CoverPageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CoverPageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CoverPageFragment newInstance(int param1) {
        CoverPageFragment fragment = new CoverPageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View rootview=inflater.inflate(R.layout.coverpage, container, false);
        Button abtme = (Button) rootview.findViewById(R.id.button1);
        Button b2 = (Button) rootview.findViewById(R.id.button2);
        Button b3 = (Button) rootview.findViewById(R.id.button3);

        abtme.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
        loadFrame = (OnListItemSelectedListener) getContext();
        loadFrame.OnListItemSelected(R.id.abtme_id);
            }
        });
        final View finalRootview = rootview;
        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent2=new Intent(finalRootview.getContext(), ViewPageActivity.class);
                startActivity(intent2);
            }
        });
        b3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent3=new Intent(finalRootview.getContext(), MasterDetail.class);
                startActivity(intent3);
            }
        });
        int option = getArguments().getInt(ARG_PARAM1);
        switch(option)
        {
            case R.id.abtme_id:
                rootview = inflater.inflate(R.layout.fragment_about_me,container,false);
                break;

        }
        return rootview;
    }
}
