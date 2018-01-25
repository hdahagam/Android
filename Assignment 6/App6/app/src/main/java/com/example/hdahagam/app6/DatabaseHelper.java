package com.example.hdahagam.app6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hdahagam on 10/18/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    // DB version
    private static final int DB_VERSION = 1;
    // DB Name
    private static final String DB_NAME = " myMovies ";
    // TABLE Names
    private static final String TABLE_MOVIES = " movies ";
    private static final String TABLE_GENRES = " genres ";
    private static final String TABLE_MOVIE_GENRE = " movie_genre ";
    // drop command
    private static final String DROP_CMD = " DROP TABLE IF EXISTS ";
    // common Column name
    private static final String KEY_ID = " id ";
    private static final String TABLE_MOVIES_FILTER = "filtermovies";
    // Movies Table Column names
    private static final String KEY_VOTE_CNT = " vote_cnt ";
    private static final String KEY_MOVIEID = " movieid ";
    private static final String KEY_VOTE_AVG = " vote_avg ";
    private static final String KEY_TITLE = " title ";
    private static final String KEY_POPULARITY = " popularity ";
    private static final String KEY_POSTER = " poster ";
    private static final String KEY_BACKDROP = " backdrop ";
    private static final String KEY_OVERVIEW = " overview ";
    private static final String KEY_RELEASE = " release ";
    // Genres Table name
    private static final String KEY_GENRE = " gname ";
    // MOVIE_GENRE Table names
    private static final String KEY_MOVIE_ID = " movie_id ";
    private static final String KEY_GENRE_ID = " genre_id ";
    // Table Create Statements
// Table Movies
    private static final String CREATE_TABLE_MOVIES = " CREATE TABLE " +
            TABLE_MOVIES
            + " ( " + KEY_ID + " INTEGER PRIMARY KEY , "
            + KEY_MOVIEID + " INTEGER , "
            + KEY_TITLE + " TEXT , "
            + KEY_VOTE_CNT + " INTEGER , "
            + KEY_VOTE_AVG + " REAL , "
            + KEY_POPULARITY + " REAL , "
            + KEY_POSTER + " TEXT , "
            + KEY_BACKDROP + " TEXT , "
            + KEY_OVERVIEW + " TEXT , "
            + KEY_RELEASE + " TEXT "
            + " ) ";
    private static final String CREATE_TABLE_MOVIES_FILTER = " CREATE TABLE " +
            TABLE_MOVIES_FILTER
            + " ( " + KEY_ID + " INTEGER , "
            + KEY_MOVIEID + " INTEGER , "
            + KEY_TITLE + " TEXT , "
            + KEY_VOTE_CNT + " INTEGER , "
            + KEY_VOTE_AVG + " REAL , "
            + KEY_POPULARITY + " REAL , "
            + KEY_POSTER + " TEXT , "
            + KEY_BACKDROP + " TEXT , "
            + KEY_OVERVIEW + " TEXT , "
            + KEY_RELEASE + " TEXT "
            + " ) ";
    // Table Genres
    private static final String CREATE_TABLE_GENRES = " CREATE TABLE " +
            TABLE_GENRES
            + " ( " + KEY_ID + " INTEGER PRIMARY KEY , "
            + KEY_GENRE + " TEXT "
            + " ) ";
    // Table Movie Genre
    private static final String CREATE_TABLE_MOVIE_GENRE = " CREATE TABLE " +
            TABLE_MOVIE_GENRE
            + " ( " + KEY_ID + " INTEGER PRIMARY KEY , "
            + KEY_MOVIE_ID + " INTEGER , "
            + KEY_GENRE_ID + " INTEGER "
            + " ) ";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public Cursor getAllDataMovie(int i) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_MOVIES, null);
        if (i == 2)
        {
            res = db.rawQuery("select * from " + TABLE_MOVIES_FILTER, null);

        }
        return res;
    }

    // Close DB
    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_MOVIES);
        sqLiteDatabase.execSQL(CREATE_TABLE_GENRES);
        sqLiteDatabase.execSQL(CREATE_TABLE_MOVIE_GENRE);
        sqLiteDatabase.execSQL(CREATE_TABLE_MOVIES_FILTER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // drop older tables
        sqLiteDatabase.execSQL(DROP_CMD + TABLE_MOVIES);
        sqLiteDatabase.execSQL(DROP_CMD + TABLE_GENRES);
        sqLiteDatabase.execSQL(DROP_CMD + TABLE_MOVIE_GENRE);

        // create new tables
        onCreate(sqLiteDatabase);

        initializeTables();
    }

    public void initializeTables() {
        // insert 25 movie data into the db
        SQLiteDatabase db = this.getReadableDatabase();

        String query = " SELECT * FROM " + TABLE_GENRES;

        Cursor c = db.rawQuery(query, null);

        if (c.getCount() <= 0) {
            insertAllGenres();
        }

        query = " SELECT * FROM " + TABLE_MOVIES;

        c = db.rawQuery(query, null);

        if (c.getCount() <= 0) {
            insertAllMovies();
        }
    }

    private void insertAllGenres() {
        int id;
        String genre_name;
        Genre gObj;

        id = 12;
        genre_name = "Adventure";
        gObj = new Genre(id, genre_name);
        insertIntoGenreTable(gObj);


        id = 16;
        genre_name = "Animation";
        gObj = new Genre(id, genre_name);
        insertIntoGenreTable(gObj);

        id = 35;
        genre_name = "Comedy";
        gObj = new Genre(id, genre_name);
        insertIntoGenreTable(gObj);

        id = 18;
        genre_name = "Drama";
        gObj = new Genre(id, genre_name);
        insertIntoGenreTable(gObj);

        id = 10751;
        genre_name = "Family";
        gObj = new Genre(id, genre_name);
        insertIntoGenreTable(gObj);

        id = 14;
        genre_name = "Fantasy";
        gObj = new Genre(id, genre_name);
        insertIntoGenreTable(gObj);

        id = 27;
        genre_name = "Horror";
        gObj = new Genre(id, genre_name);
        insertIntoGenreTable(gObj);

        id = 9648;
        genre_name = "Mystery";
        gObj = new Genre(id, genre_name);
        insertIntoGenreTable(gObj);

        id = 10749;
        genre_name = "Romance";
        gObj = new Genre(id, genre_name);
        insertIntoGenreTable(gObj);

        id = 878;
        genre_name = "Science Fiction";
        gObj = new Genre(id, genre_name);
        insertIntoGenreTable(gObj);

        id = 53;
        genre_name = "Thriller";
        gObj = new Genre(id, genre_name);
        insertIntoGenreTable(gObj);

        id = 10770;
        genre_name = "TV Movie";
        gObj = new Genre(id, genre_name);
        insertIntoGenreTable(gObj);

        id = 28;
        genre_name = "Action";
        gObj = new Genre(id, genre_name);
        insertIntoGenreTable(gObj);

        id = 36;
        genre_name = "History";
        gObj = new Genre(id, genre_name);
        insertIntoGenreTable(gObj);

        id = 10752;
        genre_name = "War";
        gObj = new Genre(id, genre_name);
        insertIntoGenreTable(gObj);

        id = 80;
        genre_name = "Crime";
        gObj = new Genre(id, genre_name);
        insertIntoGenreTable(gObj);
    }

    void insertIntoGenreTable(Genre gObj) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID, gObj.getId());
        values.put(KEY_GENRE, gObj.getGname());
        int index = (int) db.insert(TABLE_GENRES, null, values);
    }

    // Create ( Insert ) a new movie
    public int createNewMovie(MyMovie movie, List<Integer> genres) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_MOVIEID, movie.getMovie_id());
        values.put(KEY_VOTE_CNT, movie.getVote_cnt());
        values.put(KEY_TITLE, movie.getTitle());
        values.put(KEY_VOTE_AVG, movie.getVote_avg());
        values.put(KEY_POPULARITY, movie.getPopularity());
        values.put(KEY_POSTER, movie.getPoster());
        values.put(KEY_BACKDROP, movie.getBackdrop());
        values.put(KEY_OVERVIEW, movie.getOverview());
        values.put(KEY_RELEASE, movie.getRelease_date());

        int index = (int) db.insert(TABLE_MOVIES, null, values);

        for (int gid : genres)
            createMovieGenre(index, gid);

        return (int) index;
    }

    void createMovieGenre(int movie_id, int genre_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_MOVIE_ID, movie_id);
        values.put(KEY_GENRE_ID, genre_id);
        int index = (int) db.insert(TABLE_MOVIE_GENRE, null, values);
    }

    // insert all my movie data into Movies table !!!
    public void insertAllMovies() {
        int vote_count;
        int id;
        double vote_avg;
        //double popularity;
        String title;
        String poster_path;
        //String backdrop_path;
        String overview;
        String release_date;
        List<Integer> genres;

        //1
        id = 415842;
        vote_count = 5;
        vote_avg = 4.2;
        title = "American Assassin";
        release_date = "2017";
        poster_path = "/o40BAqdTQHiN3cUfpgieDUYI71z.jpg";
        genres = new ArrayList<Integer>(Arrays.asList(53, 28));
        overview = "Mitch Rapp is a CIA black ops recruit under the instruction of Cold War veteran Stan Hurley. The pair then is enlisted by CIA Deputy Director Irene Kennedy to investigate a wave of apparently random attacks on military and civilian targets. Together they discover a pattern in the violence that leads them to a joint mission with a lethal Turkish agent to stop a mysterious operative intent on starting a world war in the Middle East.";
        MyMovie movie25 = new MyMovie(id, vote_count, vote_avg, title, poster_path, overview, release_date);
        createNewMovie(movie25, genres);

        //2
        id = 346364;
        vote_count = 371;
        vote_avg = 7.4;
        title = "It";
        genres = new ArrayList<Integer>(Arrays.asList(27));
        release_date = "2017";
        poster_path = "/9E2y5Q7WlCVNEhP5GiVTjhEhx1o.jpg";
        overview = "In a small town in Maine, seven children known as The Losers Club come face to face with life problems, bullies and a monster that takes the shape of a clown called Pennywise.";
        MyMovie movie2 = new MyMovie(id, vote_count, vote_avg, title, poster_path, overview, release_date);
        createNewMovie(movie2, genres);
        //3
        id = 339304;
        vote_count = 41;
        vote_avg = 4.7;
        title = "The Layover";
        release_date = "2008";
        genres = new ArrayList<Integer>(Arrays.asList(35));
        poster_path = "/kb9osnqanXRpkpm1bnSqAhKoq5T.jpg";
        overview = "When their plane is rerouted due to a hurricane warning, two single female best friends find themselves competing for the same guy during an extended layover in St. Louis.";
        MyMovie movie3 = new MyMovie(id, vote_count, vote_avg, title, poster_path, overview, release_date);
        createNewMovie(movie3, genres);
        //4
        id = 390043;
        vote_count = 508;
        vote_avg = 6.4;
        title = "The Hitman's Bodygaurd";
        poster_path = "/5CGjlz2vyBhW5xHW4eNOZIdgzYq.jpg";
        genres = new ArrayList<Integer>(Arrays.asList(28, 35));
        release_date = "2012";
        overview = "The world's top bodyguard gets a new client, a hit man who must testify at the International Court of Justice. They must put their differences aside and work together to make it to the trial on time.";
        MyMovie movie4 = new MyMovie(id, vote_count, vote_avg, title, poster_path, overview, release_date);
        createNewMovie(movie4, genres);
        //5
        id = 315635;
        vote_count = 3014;
        vote_avg = 7.3;
        title = "Spider-Man:Homecoming";
        poster_path = "/kY2c7wKgOfQjvbqe7yVzLTYkxJO.jpg";
        release_date = "2017";
        overview = "Following the events of Captain America: Civil War, Peter Parker, with the help of his mentor Tony Stark, tries to balance his life as an ordinary high school student in Queens, New York City, with fighting crime as his superhero alter ego Spider-Man as a new threat, the Vulture, emerges.";
        genres = new ArrayList<Integer>(Arrays.asList(28, 12, 878));
        MyMovie movie5 = new MyMovie(id, vote_count, vote_avg, title, poster_path, overview, release_date);
        createNewMovie(movie5, genres);
        //6
        id = 324852;
        vote_count = 1687;
        vote_avg = 6.2;
        title = "Despicable Me 3";
        release_date = "2017";
        poster_path = "/5qcUGqWoWhEsoQwNUrtf3y3fcWn.jpg";
        overview = "Gru and his wife Lucy must stop former '80s child star Balthazar Bratt from achieving world domination.";
        genres = new ArrayList<Integer>(Arrays.asList(878, 12, 16, 35, 1075));
        MyMovie movie6 = new MyMovie(id, vote_count, vote_avg, title, poster_path, overview, release_date);
        createNewMovie(movie6, genres);
        //7
        id = 353491;
        vote_count = 549;
        vote_avg = 5.6;
        title = "The dark Tower";
        poster_path = "/i9GUSgddIqrroubiLsvvMRYyRy0.jpg";
        release_date = "2017";
        overview = "The last Gunslinger, Roland Deschain, has been locked in an eternal battle with Walter O’Dim, also known as the Man in Black, determined to prevent him from toppling the Dark Tower, which holds the universe together. With the fate of the worlds at stake, good and evil will collide in the ultimate battle as only Roland can defend the Tower from the Man in Black.";
        genres = new ArrayList<Integer>(Arrays.asList(28, 37, 878, 14, 27));
        MyMovie movie7 = new MyMovie(id, vote_count, vote_avg, title, poster_path, overview, release_date);
        createNewMovie(movie7, genres);
        //8
        id = 374720;
        vote_count = 2214;
        vote_avg = 7.5;
        title = "Dunkirk";
        release_date = "2017";
        poster_path = "/bOXBV303Fgkzn2K4FeKDc0O31q4.jpg";
        genres = new ArrayList<Integer>(Arrays.asList(28, 18, 36, 53, 10752));
        overview = "The miraculous evacuation of Allied soldiers from Belgium, Britain, Canada and France, who were cut off and surrounded by the German army from the beaches and harbor of Dunkirk, France, between May 26th and June 4th 1940, during the Battle of France in World War II.";
        MyMovie movie8 = new MyMovie(id, vote_count, vote_avg, title, poster_path, overview, release_date);
        createNewMovie(movie8, genres);
        //9
        id = 293768;
        vote_count = 202;
        vote_avg = 5.8;
        title = "Kidnap";
        poster_path = "/9CabD3j9PrjRY054fL0WJuEcXHZ.jpg";
        release_date = "2014";
        genres = new ArrayList<Integer>(Arrays.asList(18, 53));
        overview = "Single mother Karla McCoy lives a perfect life with her young son Frankie. One day, upon entering a local park, Karla sees her son suddenly being abducted out of the blue by a kidnapper. To save Frankie from being taken, Karla goes out on a mission to demand people in the city to help rescue her son.";
        MyMovie movie9 = new MyMovie(id, vote_count, vote_avg, title, poster_path, overview, release_date);
        createNewMovie(movie9, genres);
        //10
        id = 381283;
        vote_count = 13;
        vote_avg = 5.9;
        title = "Mother!";
        poster_path = "/qmi2dsuoyzZdJ0WFZYQazbX8ILj.jpg";
        release_date = "2017";
        genres = new ArrayList<Integer>(Arrays.asList(18, 27, 9648, 53));
        overview = "A couple's relationship is tested when uninvited guests arrive at their home, disrupting their tranquil existence.";
        MyMovie movie10 = new MyMovie(id, vote_count, vote_avg, title, poster_path, overview, release_date);
        createNewMovie(movie10, genres);
        //11
        id = 339692;
        vote_count = 188;
        vote_avg = 6.9;
        title = "Shot Caller";
        release_date = "2017";
        poster_path = "/qLmLz2wtyYvmW8Ult3l2ngOnW8v.jpg";
        genres = new ArrayList<Integer>(Arrays.asList(18, 80, 53));
        overview = "A newly-released prison gangster is forced by the leaders of his gang to orchestrate a major crime with a brutal rival gang on the streets of Southern California.";
        MyMovie movie11 = new MyMovie(id, vote_count, vote_avg, title, poster_path, overview, release_date);
        createNewMovie(movie11, genres);
        //12
        id = 430682;
        vote_count = 11;
        vote_avg = 5.5;
        title = "Gun Shy";
        poster_path = "/ugzaRtgrf2MBCUawgiE6xayXXIE.jpg";
        release_date = "2014";
        genres = new ArrayList<Integer>(Arrays.asList(35, 18, 12));
        overview = "A mega-platinum, aging rock star's supermodel wife is abducted by pirates while vacationing in Chile.";
        MyMovie movie12 = new MyMovie(id, vote_count, vote_avg, title, poster_path, overview, release_date);
        createNewMovie(movie12, genres);
        //13
        id = 281338;
        vote_count = 1425;
        vote_avg = 6.7;
        title = "War for the Planet of the Apes";
        poster_path = "/3vYhLLxrTtZLysXtIWktmd57Snv.jpg";
        release_date = "2010";
        overview = "Caesar and his apes are forced into a deadly conflict with an army of humans led by a ruthless Colonel. After the apes suffer unimaginable losses, Caesar wrestles with his darker instincts and begins his own mythic quest to avenge his kind. As the journey finally brings them face to face, Caesar and the Colonel are pitted against each other in an epic battle that will determine the fate of both their species and the future of the planet.";
        MyMovie movie13 = new MyMovie(id, vote_count, vote_avg, title, poster_path, overview, release_date);
        createNewMovie(movie13, genres);
        //14
        id = 433637;
        vote_count = 0;
        vote_avg = 0.0;
        title = "What Still Remains";
        poster_path = "/8FnKMD3zS5dZIufLKGaJApYuQSk.jpg";
        release_date = "2016";
        genres = new ArrayList<Integer>(Arrays.asList(53, 18));
        overview = "After the loss of her family, a young woman struggles to survive in a world long-since destroyed by disease; but when a lonely traveler offers her a place in his community, she must decide if the promise of a better life is worth the risk of trusting him.";
        MyMovie movie14 = new MyMovie(id, vote_count, vote_avg, title, poster_path, overview, release_date);
        createNewMovie(movie14, genres);
        //15
        id = 395814;
        vote_count = 32;
        vote_avg = 6.6;
        title = "Rememory";
        release_date = "2010";
        poster_path = "/sGQ4kix7bIT35ePpJzA2rNNaxPY.jpg";
        genres = new ArrayList<Integer>(Arrays.asList(878, 18, 9648));
        overview = "The widow of a wise professor stumbles upon one of his inventions that's able to record and play a person's memory.";
        MyMovie movie15 = new MyMovie(id, vote_count, vote_avg, title, poster_path, overview, release_date);
        createNewMovie(movie15, genres);
        //16
        id = 342473;
        vote_count = 352;
        vote_avg = 7.1;
        title = "Ballerina";
        release_date = "2016";
        poster_path = "/60ZhK1FstSkC9Ms8lRWaTPm55kD.jpg";
        genres = new ArrayList<Integer>(Arrays.asList(12, 16, 35, 10751));
        overview = "Set in 1879 Paris. An orphan girl dreams of becoming a ballerina and flees her rural Brittany for Paris, where she passes for someone else and accedes to the position of pupil at the Grand Opera house.";
        MyMovie movie16 = new MyMovie(id, vote_count, vote_avg, title, poster_path, overview, release_date);
        createNewMovie(movie16, genres);
        //17
        id = 427900;
        vote_count = 7;
        vote_avg = 3.4;
        title = "Home Again";
        release_date = "2017";
        poster_path = "/z5CtCxpblBke2G8c7CMkstedMgY.jpg";
        genres = new ArrayList<Integer>(Arrays.asList(35, 18));
        overview = "Life for a single mom in Los Angeles takes an unexpected turn when she allows three young guys to move in with her.";
        MyMovie movie17 = new MyMovie(id, vote_count, vote_avg, title, poster_path, overview, release_date);
        createNewMovie(movie17, genres);
        //18
        id = 399170;
        vote_count = 83;
        vote_avg = 6.6;
        title = "Logan Lucky";
        release_date = "2017";
        poster_path = "/mQrhrBaaHvRfBQq0Px3HtVbH9iE.jpg";
        genres = new ArrayList<Integer>(Arrays.asList(28, 80, 35));
        overview = "Trying to reverse a family curse, brothers Jimmy and Clyde Logan set out to execute an elaborate robbery during the legendary Coca-Cola 600 race at the Charlotte Motor Speedway.";
        MyMovie movie18 = new MyMovie(id, vote_count, vote_avg, title, poster_path, overview, release_date);
        createNewMovie(movie18, genres);
        //19
        id = 408648;
        vote_count = 57;
        vote_avg = 5.5;
        title = "Batman and Harley Quinn";
        release_date = "2017";
        poster_path = "/uVdxoD9kn28qC8VQiVA6Uif1QHl.jpg";
        overview = "Batman and Nightwing are forced to team with the Joker's sometimes-girlfriend Harley Quinn to stop a global threat brought about by Poison Ivy and Jason Woodrue, the Floronic Man.";
        genres = new ArrayList<Integer>(Arrays.asList(12, 28, 16));
        MyMovie movie19 = new MyMovie(id, vote_count, vote_avg, title, poster_path, overview, release_date);
        createNewMovie(movie19, genres);
        //20
        id = 467432;
        vote_count = 3;
        vote_avg = 6.0;
        title = "True to the Game";
        release_date = "2011";
        poster_path = "/yCNlqcRdP9haLmCgBiD5zX59F9P.jpg";
        genres = new ArrayList<Integer>(Arrays.asList(18));
        overview = "Based on the Terri Woods best selling novel, True to the Game is the love story of Quadir Richards, a charismatic drug lord, and Gena Rollins, a young girl from the projects of Philly. Quadir was able to gain the trust and love of Gena and was on his way out of the game to start a new life with his future bride when tragedy strikes.";
        MyMovie movie20 = new MyMovie(id, vote_count, vote_avg, title, poster_path, overview, release_date);
        createNewMovie(movie20, genres);
        //21
        id = 211672;
        vote_count = 4381;
        vote_avg = 6.4;
        title = "Minions";
        release_date = "2015";
        poster_path = "/q0R4crx2SehcEEQEkYObktdeFy.jpg";
        genres = new ArrayList<Integer>(Arrays.asList(10751, 16, 12, 35));
        overview = "Minions Stuart, Kevin and Bob are recruited by Scarlet Overkill, a super-villain who, alongside her inventor husband Herb, hatches a plot to take over the world.";
        MyMovie movie21 = new MyMovie(id, vote_count, vote_avg, title, poster_path, overview, release_date);
        createNewMovie(movie21, genres);
        //22
        id = 118340;
        vote_count = 9398;
        vote_avg = 7.9;
        title = "Gaurdians of Galaxy";
        release_date = "2009";
        poster_path = "/y31QB9kn3XSudA15tV7UWQ9XLuW.jpg";
        genres = new ArrayList<Integer>(Arrays.asList(28, 878, 12));
        overview = "Light years from Earth, 26 years after being abducted, Peter Quill finds himself the prime target of a manhunt after discovering an orb wanted by Ronan the Accuser.";
        MyMovie movie22 = new MyMovie(id, vote_count, vote_avg, title, poster_path, overview, release_date);
        createNewMovie(movie22, genres);
        //23
        id = 321612;
        vote_count = 5158;
        vote_avg = 6.8;
        title = "Beauty and the Beast";
        release_date = "2017";
        poster_path = "/tWqifoYuwLETmmasnGHO7xBjEtt.jpg";
        genres = new ArrayList<Integer>(Arrays.asList(10751, 14, 10749));
        overview = "A live-action adaptation of Disney's version of the classic 'Beauty and the Beast' tale of a cursed prince and a beautiful young woman who helps him break the spell.";
        MyMovie movie23 = new MyMovie(id, vote_count, vote_avg, title, poster_path, overview, release_date);
        createNewMovie(movie23, genres);
        //24
        id = 157336;
        vote_count = 10592;
        vote_avg = 8.1;
        title = "Interstellar";
        release_date = "2014";
        poster_path = "/nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg";
        genres = new ArrayList<Integer>(Arrays.asList(18, 12, 878));
        overview = "Interstellar chronicles the adventures of a group of explorers who make use of a newly discovered wormhole to surpass the limitations on human space travel and conquer the vast distances involved in an interstellar voyage.";
        MyMovie movie24 = new MyMovie(id, vote_count, vote_avg, title, poster_path, overview, release_date);
        createNewMovie(movie24, genres);
        //25
        id = 396422;
        vote_count = 767;
        vote_avg = 6.5;
        title = "Annabelle:Creation";
        overview = "Several years after the tragic death of their little girl, a dollmaker and his wife welcome a nun and several girls from a shuttered orphanage into their home, soon becoming the target of the dollmaker's possessed creation, Annabelle.";
        genres = new ArrayList<Integer>(Arrays.asList(878, 12, 16, 35, 10751));
        poster_path = "/yAgxM61Sn0dYML4C9v3MJFp5zPI.jpg";
        release_date = "2013";
        MyMovie movie1 = new MyMovie(id, vote_count, vote_avg, title, poster_path, overview, release_date);
        createNewMovie(movie1, genres);
    }

    // Get ( fetch ) a matched movie with an unique id
    public MyMovie getMovie(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String query = " SELECT * FROM " + TABLE_MOVIES + " WHERE " + KEY_ID + " = " + id;
        Cursor c = db.rawQuery(query, null);

        if (c == null)
            return null;
        c.moveToFirst();
        MyMovie movie = new MyMovie();
//        movie.setId(c.getInt(c.getColumnIndex(KEY_ID)));
//        movie.setMovie_id(c.getInt(c.getColumnIndex(KEY_MOVIEID)));
//        movie.setTitle(c.getString(c.getColumnIndex(KEY_TITLE)));
//        movie.setVote_cnt(c.getInt(c.getColumnIndex(KEY_VOTE_CNT)));
//        movie.setVote_avg(c.getDouble(c.getColumnIndex(KEY_VOTE_AVG)));
//        movie.setPopularity(c.getDouble(c.getColumnIndex(KEY_POPULARITY)));
//        movie.setPoster(c.getString(c.getColumnIndex(KEY_POSTER)));
//        movie.setBackdrop(c.getString(c.getColumnIndex(KEY_BACKDROP)));
//        movie.setOverview(c.getString(c.getColumnIndex(KEY_OVERVIEW)));
//        movie.setRelease_date(c.getString(c.getColumnIndex(KEY_RELEASE)));
        movie.setId(Integer.parseInt(c.getString(0)));
        movie.setMovie_id(Integer.parseInt(c.getString(1)));
        movie.setTitle((c.getString(2)));
        movie.setVote_cnt(Integer.parseInt(c.getString(3)));
        movie.setVote_avg(Double.parseDouble(c.getString(4)));
        movie.setPopularity(Double.parseDouble(c.getString(5)));
        movie.setPoster((c.getString(6)));
        movie.setOverview((c.getString(8)));
        movie.setRelease_date((c.getString(9)));
        return movie;
    }

    // Get ( fetch ) all movies
    public List<MyMovie> getAllMovies(int i) {
        List<MyMovie> movies = new ArrayList<MyMovie>();

        String query = " SELECT * FROM " + TABLE_MOVIES;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor c;// = db.rawQuery(query, null);

        c = this.getAllDataMovie(i);
        if (c.getCount() == 0) {
            // show message
            //showMessage("Error","Nothing found");
            return null;
        }

        //StringBuffer buffer = new StringBuffer();

        while (c.moveToNext()) {

            MyMovie movie = new MyMovie();

            movie.setId(Integer.parseInt(c.getString(0)));
            movie.setMovie_id(Integer.parseInt(c.getString(1)));
            movie.setTitle((c.getString(2)));
            movie.setVote_cnt(Integer.parseInt(c.getString(3)));
            movie.setVote_avg(Double.parseDouble(c.getString(4)));
            movie.setPopularity(Double.parseDouble(c.getString(5)));
            movie.setPoster((c.getString(6)));
            movie.setOverview((c.getString(8)));
            movie.setRelease_date((c.getString(9)));
            movies.add(movie);

        }


        return movies;
    }
    public void duplicate(int movie_id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String query = " SELECT * FROM " + TABLE_MOVIES + " WHERE " + KEY_MOVIEID + " = " + movie_id;


        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();
        MyMovie movie = new MyMovie();
        movie.setId(Integer.parseInt(c.getString(0)));
        movie.setMovie_id(Integer.parseInt(c.getString(1)));
        movie.setTitle((c.getString(2)));
        movie.setVote_cnt(Integer.parseInt(c.getString(3)));
        movie.setVote_avg(Double.parseDouble(c.getString(4)));
        movie.setPopularity(Double.parseDouble(c.getString(5)));
        movie.setPoster((c.getString(6)));
        movie.setOverview((c.getString(8)));
        movie.setRelease_date((c.getString(9)));

        values.put(KEY_MOVIEID, movie.getId());// c.getInt(c.getColumnIndex(KEY_MOVIEID)));
        values.put(KEY_VOTE_CNT,movie.getVote_cnt());//c.getInt(c.getColumnIndex(KEY_VOTE_COUNT)));
        values.put(KEY_TITLE, movie.getTitle());//c.getString(c.getColumnIndex(KEY_TITLE)));
        values.put(KEY_VOTE_AVG, movie.getVote_avg());//c.getDouble(c.getColumnIndex(KEY_VOTE_AVG)));
        values.put(KEY_POPULARITY, movie.getPopularity());//c.getDouble(c.getColumnIndex(KEY_POPULARITY)));
        values.put(KEY_POSTER, movie.getPoster());//c.getString(c.getColumnIndex(KEY_POSTER)));
        //values.put(KEY_BACKDROP, c.getString(c.getColumnIndex(KEY_BACKDROP)));
        values.put(KEY_OVERVIEW, movie.getOverview());//c.getString(c.getColumnIndex(KEY_OVERVIEW)));
        values.put(KEY_RELEASE, movie.getRelease_date());//c.getString(c.getColumnIndex(KEY_RELEASE)));
        db.insert(TABLE_MOVIES, null, values);

    }
    public void searchQuery(String query)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL(DROP_CMD + " " + TABLE_MOVIES_FILTER);
        db.execSQL(CREATE_TABLE_MOVIES_FILTER);
        List<MyMovie> movies = new ArrayList<MyMovie>();
        String newQuery = " SELECT distinct m.id as id, m.movieid as movieid, m.title as title, m.vote_cnt as vote_cnt,m.vote_avg as vote_avg,"
                +"m.popularity as popularity, m.poster as poster,  m.backdrop as backdrop, m.overview as overview, " +
                "m.release as release," +
                "mg.genre_id as genre_id," +
                "g.gname as gname" +
                " FROM movies as m" +
                " JOIN movie_genre as mg ON m.id = mg.movie_id" +
                " JOIN genres as g ON mg.genre_id = g.id " +
                " WHERE g.gname = '" + query +"'";

        Cursor c = db.rawQuery(newQuery, null);

        if (c == null)
            return;

        if (c.moveToFirst()) {
            do {
                MyMovie movie = getMovie(Integer.parseInt(c.getString(0)));
                createSearchMovie(movie);
            } while (c.moveToNext());
        }
    }

    // Create ( Insert ) a new movie
    public void createSearchMovie(MyMovie movie) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID, movie.getId());
        values.put(KEY_MOVIEID, movie.getMovie_id());
        values.put(KEY_VOTE_CNT, movie.getVote_cnt());
        values.put(KEY_TITLE, movie.getTitle());
        values.put(KEY_VOTE_AVG, movie.getVote_avg());
        values.put(KEY_POPULARITY, movie.getPopularity());
        values.put(KEY_POSTER, movie.getPoster());
        values.put(KEY_BACKDROP, movie.getBackdrop());
        values.put(KEY_OVERVIEW, movie.getOverview());
        values.put(KEY_RELEASE, movie.getRelease_date());

        int index = (int) db.insert(TABLE_MOVIES_FILTER, null, values);
    }
    // Delete a movie
    public void deleteMovie(int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_MOVIES, KEY_MOVIEID + " =? ", new String[]
                {String.valueOf(id)});

        db.delete(TABLE_MOVIE_GENRE, KEY_MOVIE_ID + " =? ", new String[]
                {String.valueOf(id)});
    }

    // Update a movie
    public int updateMovie(MyMovie movie) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_MOVIEID, movie.getMovie_id());
        // assign all movie info to values ...
        return db.update(TABLE_MOVIES, values, KEY_ID + " = ?", new String[]
                {String.valueOf(movie.getId())});
    }

    public List<Genre> getMatchedGenres(int mid) {
        SQLiteDatabase db = this.getReadableDatabase();


        String query = " SELECT movie_genre . genre_id as id , genres . gname as genre "
                + " FROM movie_genre "
                + " JOIN genres on movie_genre . genre_id = genres . id "
                + " WHERE movie_genre . movie_id = " + mid;

        Cursor c = db.rawQuery(query, null);


        if (c.moveToFirst()) {
            List<Genre> gs = new ArrayList<Genre>();
            do {
                Genre g = new Genre();
                g.setId(c.getInt(c.getColumnIndex(" id ")));
                g.setGname(c.getString(c.getColumnIndex(" genre ")));

                gs.add(g);
            } while (c.moveToNext());
            return gs;
        }
        return null;

    }

    public void printAllMovies() {
        List<MyMovie> myMovieList = getAllMovies(1);
        for (MyMovie m : myMovieList) {
            m.printdetails();
        }
    }
}