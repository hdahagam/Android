package com.example.hdahagam.app4;

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
class CoverPage extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private OnListItemSelectedListener loadFrame;

    // TODO: Rename and change types of parameters


    public CoverPage() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment CoverPageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CoverPage newInstance(int param1) {
        CoverPage fragment = new CoverPage();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview=inflater.inflate(R.layout.activity_cover_page, container, false);
        Button abtme = (Button) rootview.findViewById(R.id.button1);
        Button b2 = (Button) rootview.findViewById(R.id.button2);

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
                Intent intent2=new Intent(finalRootview.getContext(), MovieActivity.class);
                startActivity(intent2);
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
