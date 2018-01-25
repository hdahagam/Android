package com.example.hdahagam.app6;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


interface OnListItemSelectedListener {
    public void OnListItemSelected(int postition);
}

public class CoverPage extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = " ";
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
        View rootview = null;
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
