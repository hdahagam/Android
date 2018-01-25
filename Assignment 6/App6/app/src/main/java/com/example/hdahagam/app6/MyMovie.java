package com.example.hdahagam.app6;

import android.util.Log;

/**
 * Created by hdahagam on 10/18/2017.
 */

public class MyMovie {
    int id;
    int vote_cnt;
    int movie_id;
    boolean checked;
    String title;
    double vote_avg;
    double popularity;
    String poster;
    String backdrop;
    String overview;
    String release_date;

    public MyMovie() {
    }

    public MyMovie(int movie_id, int vote_cnt, double vote_avg, String title, String poster, String overview, String release_date) {
        this.vote_cnt = vote_cnt;
        this.movie_id = movie_id;
        this.title = title;
        this.vote_avg = vote_avg;
        this.poster = poster;
        this.overview = overview;
        this.release_date = release_date;
        this.checked = false;
    }

    public MyMovie(MyMovie src) {
        this.vote_cnt = src.getVote_cnt();
        this.movie_id = src.getMovie_id();
        this.title = src.getTitle();
        this.vote_avg = src.getVote_avg();
        this.popularity = src.getPopularity();
        this.poster = src.getPoster();
        this.backdrop = src.getBackdrop();
        this.overview = src.getOverview();
        this.release_date = src.getRelease_date();
        this.checked = false;
    }

    public MyMovie(int id, int vote_cnt, int movie_id, String title, double
            vote_avg, double popularity, String poster, String backdrop, String
                           overview, String release) {
        this.id = id;
        this.vote_cnt = vote_cnt;
        this.movie_id = movie_id;
        this.title = title;
        this.vote_avg = vote_avg;
        this.popularity = popularity;
        this.poster = poster;
        this.backdrop = backdrop;
        this.overview = overview;
        this.release_date = release;
        this.checked = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVote_cnt() {
        return vote_cnt;
    }

    public void setVote_cnt(int vote_cnt) {
        this.vote_cnt = vote_cnt;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getVote_avg() {
        return vote_avg;
    }

    public void setVote_avg(double vote_avg) {
        this.vote_avg = vote_avg;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getBackdrop() {
        return backdrop;
    }

    public void setBackdrop(String backdrop) {
        this.backdrop = backdrop;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }
    public void printdetails(){
        Log.d("Movie Name:",title);
    }

}

