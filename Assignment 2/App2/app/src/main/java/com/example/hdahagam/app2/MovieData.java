package com.example.hdahagam.app2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hdahagam on 9/13/2017.
 */
public class MovieData {
        List<Map< String ,? >>moviesList ;
        public List<Map<String ,?>> getMoviesList() {
            return moviesList;
        }
        public int getSize (){
            return moviesList.size();
        }
        public HashMap getItem (int i){
            if (i>=0&&i<moviesList.size()){
                return(HashMap)moviesList.get(i);
            }
            else
                return null;
}
    public MovieData(){
// Movie detail information is your choice .
        Integer vote_count;
        Integer id;
        Double vote_avg;
        String title;
        String poster_path;
        List<Integer> genres;
        moviesList = new ArrayList<Map<String,?>>();
        //1
        id=396422;
        vote_count=767;
        vote_avg=6.5;
        title="Annabelle:Creation";
        poster_path="/tb86j8jVCVsdZnzf8I6cIi65IeM.jpg";
        genres=new ArrayList< Integer >(Arrays.asList(878 ,12 ,16 ,35 ,10751));
       moviesList.add(createMovie(id, R.drawable.annabelle,vote_count,vote_avg, title, poster_path, genres)) ;
        //2
        id=346364;
        vote_count=371;
        vote_avg=7.4;
        title="It";
        poster_path="/9E2y5Q7WlCVNEhP5GiVTjhEhx1o.jpg";
        genres=new ArrayList< Integer>(Arrays.asList(27));
        moviesList.add(createMovie(id,R.drawable.it,vote_count,vote_avg, title, poster_path, genres)) ;
        //3
        id=339304;
        vote_count=41;
        vote_avg=4.7;
        title="The Layover";
        poster_path="/kb9osnqanXRpkpm1bnSqAhKoq5T.jpg";
        genres=new ArrayList< Integer>(Arrays.asList(35));
        moviesList.add(createMovie(id,R.drawable.layover,vote_count,vote_avg, title, poster_path, genres)) ;
       //4
        id=390043;
        vote_count=508;
        vote_avg=6.4;
        title="The Hitman's Bodygaurd";
        poster_path="/5CGjlz2vyBhW5xHW4eNOZIdgzYq.jpg";
        genres=new ArrayList< Integer>(Arrays.asList(28,35));
        moviesList.add(createMovie(id,R.drawable.hitmansbodygaurd,vote_count,vote_avg, title, poster_path, genres)) ;
        //5
        id=315635;
        vote_count=3014;
        vote_avg=7.3;
        title="Spider-Man:Homecoming";
        poster_path="/c24sv2weTHPsmDa7jEMN0m2P3RT.jpg";
        genres=new ArrayList< Integer>(Arrays.asList(28,12,878));
        moviesList.add(createMovie(id,R.drawable.spiderman,vote_count,vote_avg, title, poster_path, genres)) ;
        //6
        id=324852;
        vote_count=1687;
        vote_avg=6.2;
        title="Despicable Me 3";
        poster_path="/5qcUGqWoWhEsoQwNUrtf3y3fcWn.jpg";
        genres=new ArrayList< Integer>(Arrays.asList(878,12,16,35,1075));
        moviesList.add(createMovie(id,R.drawable.despicable3,vote_count,vote_avg, title, poster_path, genres)) ;
     //7
     id=353491;
     vote_count=549;
     vote_avg=5.6;
     title="The dark Tower";
     poster_path="/i9GUSgddIqrroubiLsvvMRYyRy0.jpg";
     genres=new ArrayList< Integer>(Arrays.asList(28,37,878,14,27));
     moviesList.add(createMovie(id,R.drawable.darktower,vote_count,vote_avg, title, poster_path, genres)) ;
     //8
     id=374720;
     vote_count=2214;
     vote_avg=7.5;
     title="Dunkirk";
     poster_path="/bOXBV303Fgkzn2K4FeKDc0O31q4.jpg";
     genres=new ArrayList< Integer>(Arrays.asList(28,18,36,53,10752));

     moviesList.add(createMovie(id,R.drawable.dunkirk,vote_count,vote_avg, title, poster_path, genres)) ;
     //9
     id=293768;
     vote_count=202;
     vote_avg=5.8;
     title="Kidnap";
     poster_path="/9CabD3j9PrjRY054fL0WJuEcXHZ.jpg";
     genres=new ArrayList< Integer>(Arrays.asList(18,53));

     moviesList.add(createMovie(id,R.drawable.kidnap,vote_count,vote_avg, title, poster_path, genres)) ;
     //10
     id=381283;
     vote_count=13;
     vote_avg=5.9;
     title="Mother!";
     poster_path="/qmi2dsuoyzZdJ0WFZYQazbX8ILj.jpg";
     genres=new ArrayList< Integer>(Arrays.asList(18,27,9648,53));

     moviesList.add(createMovie(id,R.drawable.mother,vote_count,vote_avg, title, poster_path, genres)) ;
     //11
     id=339692;
     vote_count=188;
     vote_avg=6.9;
     title="Shot Caller";
     poster_path="/qLmLz2wtyYvmW8Ult3l2ngOnW8v.jpg";
     genres=new ArrayList< Integer>(Arrays.asList(18,80,53));

     moviesList.add(createMovie(id,R.drawable.shotcaller,vote_count,vote_avg, title, poster_path, genres)) ;
     //12
     id=430682;
     vote_count=11;
     vote_avg=5.5;
     title="Gun Shy";
     poster_path="/ugzaRtgrf2MBCUawgiE6xayXXIE.jpg";
     genres=new ArrayList< Integer>(Arrays.asList(35,18,12));

     moviesList.add(createMovie(id,R.drawable.gunshy,vote_count,vote_avg, title, poster_path, genres)) ;
     //13
     id=281338;
     vote_count=1425;
     vote_avg=6.7;
     title="War for the Planet of the Apes";
     poster_path="/y52mjaCLoJJzxfcDDlksKDngiDx.jpg";
     genres=new ArrayList< Integer>(Arrays.asList(18,878,10752));

     moviesList.add(createMovie(id,R.drawable.warofapes,vote_count,vote_avg, title, poster_path, genres)) ;
     //14
     id=433637;
     vote_count=0;
     vote_avg=0.0;
     title="What Still Remains";
     poster_path="/8FnKMD3zS5dZIufLKGaJApYuQSk.jpg";
     genres=new ArrayList< Integer>(Arrays.asList(53,18));

     moviesList.add(createMovie(id,R.drawable.whatstillremains,vote_count,vote_avg, title, poster_path, genres)) ;
     //15
     id=395814;
     vote_count=32;
     vote_avg=6.6;
     title="Remomory";
     poster_path="/sGQ4kix7bIT35ePpJzA2rNNaxPY.jpg";
     genres=new ArrayList< Integer>(Arrays.asList(878,18,9648));

     moviesList.add(createMovie(id,R.drawable.rememory,vote_count,vote_avg, title, poster_path, genres)) ;
     //16
     id=342473;
     vote_count=352;
     vote_avg=7.1;
     title="Ballerina";
     poster_path="/60ZhK1FstSkC9Ms8lRWaTPm55kD.jpg";
     genres=new ArrayList< Integer>(Arrays.asList(12,16,35,10751));

     moviesList.add(createMovie(id,R.drawable.ballerina,vote_count,vote_avg, title, poster_path, genres)) ;
     //17
     id=427900;
     vote_count=7;
     vote_avg=3.4;
     title="Home Again";
     poster_path="/z5CtCxpblBke2G8c7CMkstedMgY.jpg";
     genres=new ArrayList< Integer>(Arrays.asList(35,18));

     moviesList.add(createMovie(id,R.drawable.homeagain,vote_count,vote_avg, title, poster_path, genres)) ;
     //18
     id=399170;
     vote_count=83;
     vote_avg=6.6;
     title="Logan Lucky";
     poster_path="/mQrhrBaaHvRfBQq0Px3HtVbH9iE.jpg";
     genres=new ArrayList< Integer>(Arrays.asList(28,80,35));

     moviesList.add(createMovie(id,R.drawable.loganlucky,vote_count,vote_avg, title, poster_path, genres)) ;
     //19
     id=408648;
     vote_count=57;
     vote_avg=5.5;
     title="Batman and Harley Quinn";
     poster_path="/uVdxoD9kn28qC8VQiVA6Uif1QHl.jpg";
     genres=new ArrayList< Integer>(Arrays.asList(12,28,16));

     moviesList.add(createMovie(id,R.drawable.batman,vote_count,vote_avg, title, poster_path, genres)) ;
     //20
     id=467432;
     vote_count=3;
     vote_avg=6.0;
     title="True to the Game";
     poster_path="/yCNlqcRdP9haLmCgBiD5zX59F9P.jpg";
     genres=new ArrayList< Integer>(Arrays.asList(18));

     moviesList.add(createMovie(id,R.drawable.thegame,vote_count,vote_avg, title, poster_path, genres)) ;
     //21
     id=211672;
     vote_count=4381;
     vote_avg=6.4;
     title="Minions";
     poster_path="/q0R4crx2SehcEEQEkYObktdeFy.jpg";
     genres=new ArrayList< Integer>(Arrays.asList(10751,16,12,35));

     moviesList.add(createMovie(id,R.drawable.minions,vote_count,vote_avg, title, poster_path, genres)) ;
     //22
     id=118340;
     vote_count=9398;
     vote_avg=7.9;
     title="Gaurdians of Galaxy";
     poster_path="/y31QB9kn3XSudA15tV7UWQ9XLuW.jpg";
     genres=new ArrayList< Integer>(Arrays.asList(28,878,12));

     moviesList.add(createMovie(id,R.drawable.guardiansofgalaxy,vote_count,vote_avg, title, poster_path, genres)) ;
     //23
     id=321612;
     vote_count=5158;
     vote_avg=6.8;
     title="Beauty and the Beast";
     poster_path="/tWqifoYuwLETmmasnGHO7xBjEtt.jpg";
     genres=new ArrayList< Integer>(Arrays.asList(10751,14,10749));

     moviesList.add(createMovie(id, R.drawable.beautyandthebeast,vote_count,vote_avg, title, poster_path, genres)) ;
     //24
     id=157336;
     vote_count=10592;
     vote_avg=8.1;
     title="Interstellar";
     poster_path="/nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg";
     genres=new ArrayList< Integer>(Arrays.asList(18,12,878));

     moviesList.add(createMovie(id,R.drawable.interstellar,vote_count,vote_avg, title, poster_path, genres)) ;
     //25
     id=415842;
     vote_count=5;
     vote_avg=4.2;
     title="American Assassin";
     poster_path="/o40BAqdTQHiN3cUfpgieDUYI71z.jpg";
     genres=new ArrayList< Integer>(Arrays.asList(53,28));

     moviesList.add(createMovie(id, R.drawable.americanassassin,vote_count,vote_avg, title, poster_path, genres)) ;

    }

    private HashMap createMovie(Integer id, int image,Integer vCount, Double vAvg, String title, String poster, List < Integer > genres ) {
        HashMap movie =new HashMap();
        movie.put("image",image);
        movie.put("id",id);
        movie.put("voteCount",vCount);
        movie.put("voteAverage",vAvg);
        movie.put("title",title);
        movie.put("genres",genres);
        movie.put("poster",poster);
        return movie;
    }
}
