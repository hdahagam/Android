package com.example.hdahagam.app6;

/**
 * Created by hdahagam on 10/18/2017.
 */

public class Genre {
    int id;
    String gname;

    public Genre() {

    }

    public Genre(int id, String gname) {
        this.id = id;
        this.gname = gname;
    }

    // setters

    public void setId(int id) {
        this.id = id;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    // getters

    public int getId() {
        return this.id;
    }

    public String getGname() {
        return this.gname;
    }
}
