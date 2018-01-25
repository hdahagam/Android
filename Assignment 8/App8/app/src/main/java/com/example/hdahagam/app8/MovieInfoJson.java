package com.example.hdahagam.app8;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hdahagam on 10/31/2017.
 */

public class MovieInfoJson {

    public static String WEB_SERVER = "http://hdahagam.com/app7/";
    List<Map<String, ?>> moviesList;
    public List<Map<String ,?>> getMoviesList() {
        return moviesList;
    }

    public int getSize(){
        return moviesList.size();
    }

    public MovieInfoJson(){
        this.moviesList = new ArrayList<Map<String,?>>();
    }

    public HashMap getItem (int i){
        if (i>=0&&i<moviesList.size()){
            return(HashMap)moviesList.get(i);
        }
        else
            return null;
    }

    public void downloadMovieDataJson(String urlString) {

        String response = MyUtility . downloadJSONusingHTTPGetRequest ( urlString ) ;
        JSONObject jsonObject = null ;
        try {
            jsonObject = new JSONObject(response);
            JSONArray movieArray = jsonObject . getJSONArray ("movies");
            for ( int i = 0; i < movieArray . length () ; i ++) {
                HashMap info = new HashMap () ;
                JSONObject movie = ( JSONObject ) movieArray . get (i);
                info . put ("id" , movie . getString ("ID"));
                info . put ("movieid" , movie . getString ("MovieId"));
                info . put ("title" , movie . getString ("Title"));
                info . put ("votecount" ,  Double.parseDouble(movie . getString ("VoteCnt")));
                info . put ("rating" , movie . getString ("VoteAvg"));
                info . put ("overview" , movie . getString ("Overview"));
                info . put ("poster" , movie . getString ("Poster"));
                info . put ("release" , movie . getString ("ReleaseDay"));
                moviesList . add ( info );
            }
        } catch ( Exception e) {
            e. printStackTrace () ;
        }
    }
    public List<Map<String, ?>> addItem(int position,Map<String,?> map){
        moviesList.add(position,map);
        return  moviesList;

    }
    public HashMap downloadSingleMovieDataJson(String url) {
        String response = MyUtility . downloadJSONusingHTTPGetRequest ( url ) ;
        JSONObject movie = null;
        HashMap info = null;
        try {
            movie = new JSONObject(response);
            info = new HashMap () ;
            info . put ("id" , movie . getString ("ID"));
            info . put ("movieid" , movie . getString ("MovieId"));
            info . put ("title" , movie . getString ("Title"));
            info . put ("rating" ,  Double.parseDouble(movie . getString ("VoteAvg")));
            info . put ("votecount" , movie . getString ("VoteCnt"));
            info . put ("overview" , movie . getString ("Overview"));
            info . put ("poster" , movie . getString ("Poster"));
            info . put ("release" , movie . getString ("ReleaseDay"));

        }catch (Exception e)
        {
            e.printStackTrace();

        }
        return info;
    }

    public void add(int position, HashMap newmovie) {
        final JSONObject json;
        if (newmovie != null)
        {
            json = new JSONObject(newmovie);
        }
        else
            json = null;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String url = WEB_SERVER + "addnewmovie";
                MyUtility.sendHttPostRequest(url, json);
            }
        };
        new Thread(runnable).start();
    }

    public void deleteItem(int position, HashMap deletemovie) {
        final JSONObject json;
        if (deletemovie != null)
        {
            json = new JSONObject(deletemovie);
        }
        else
            json = null;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String url = WEB_SERVER + "delete" ;
                //+ item.get("id");
                MyUtility.sendHttPostRequest(url, json);
            }
        };
        new Thread(runnable).start();
    }
}
