package com.example.hdahagam.app10;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by hdahagam on 11/16/2017.
 */

public class PreferenceSetUp {
    private Context mcontext;
    private SharedPreferences sharePref;

    public PreferenceSetUp(Context context){
        this.mcontext = context;
        getSharedPreference();
    }
    private void getSharedPreference(){
        sharePref = mcontext.getSharedPreferences(mcontext.getString(R.string.my_preferences), mcontext.MODE_PRIVATE);

    }

    public void writePref(){

        SharedPreferences.Editor editor = sharePref.edit();
        editor.putString(mcontext.getString(R.string.my_preferences_key),"INIT_OK");
        editor.commit();
    }

    public boolean checkPref(){
        boolean status = false;

        if (sharePref.getString(mcontext.getString(R.string.my_preferences_key),"null").equals("null")){
            status = false;
        }
        else {
            status = true;
        }

        return status;
    }

    public void clearPref(){
        sharePref.edit().clear().commit();
    }
}

