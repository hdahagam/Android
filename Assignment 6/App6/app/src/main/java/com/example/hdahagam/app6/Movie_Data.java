package com.example.hdahagam.app6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hdahagam on 9/30/2017.
 */

public class Movie_Data {
    List<Map< String ,? >> moviesList ;
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
    public Movie_Data(){
// Movie detail information is your choice. .
        Integer vote_count;
        Integer id;
        Double vote_avg;
        String title;
        String poster_path;
        String release_date;
        String overview;
        List<Integer> genres;
        moviesList = new ArrayList<Map<String,?>>();
        //1
        id=396422;
        vote_count=767;
        vote_avg=6.5;
        title="Annabelle:Creation";
        overview="Several years after the tragic death of their little girl, a dollmaker and his wife welcome a nun and several girls from a shuttered orphanage into their home, soon becoming the target of the dollmaker's possessed creation, Annabelle.";
        genres=new ArrayList< Integer >(Arrays.asList(878 ,12 ,16 ,35 ,10751));
        poster_path="/yAgxM61Sn0dYML4C9v3MJFp5zPI.jpg";
        release_date= "2013";

        //moviesList.add(createMovie(id, R.drawable.annabelle,vote_count,vote_avg, title, poster_path, overview,release_date, genres)) ;
        //2
        id=346364;
        vote_count=371;
        vote_avg=7.4;
        title="It";
        genres=new ArrayList< Integer>(Arrays.asList(27));
        release_date= "2017";
        poster_path="/9E2y5Q7WlCVNEhP5GiVTjhEhx1o.jpg";
        overview="In a small town in Maine, seven children known as The Losers Club come face to face with life problems, bullies and a monster that takes the shape of a clown called Pennywise.";
        //moviesList.add(createMovie(id,R.drawable.it,vote_count,vote_avg, title, poster_path, overview,release_date, genres)) ;
        //3
        id=339304;
        vote_count=41;
        vote_avg=4.7;
        title="The Layover";
        release_date= "2017";
        genres=new ArrayList< Integer>(Arrays.asList(35));
        poster_path= "/kb9osnqanXRpkpm1bnSqAhKoq5T.jpg";
        overview="When their plane is rerouted due to a hurricane warning, two single female best friends find themselves competing for the same guy during an extended layover in St. Louis.";
       //moviesList.add(createMovie(id,R.drawable.layover,vote_count,vote_avg, title, poster_path, overview,release_date, genres)) ;
        //4
        id=390043;
        vote_count=508;
        vote_avg=6.4;
        title="The Hitman's Bodygaurd";
        poster_path= "/5CGjlz2vyBhW5xHW4eNOZIdgzYq.jpg";
        genres=new ArrayList< Integer>(Arrays.asList(28,35));
        release_date= "2012";
        overview= "The world's top bodyguard gets a new client, a hit man who must testify at the International Court of Justice. They must put their differences aside and work together to make it to the trial on time.";
        //moviesList.add(createMovie(id,R.drawable.hitmansbodygaurd,vote_count,vote_avg, title, poster_path, overview,release_date, genres)) ;
        //5
        id=315635;
        vote_count=3014;
        vote_avg=7.3;
        title="Spider-Man:Homecoming";
        poster_path= "/kY2c7wKgOfQjvbqe7yVzLTYkxJO.jpg";
        release_date= "2017";
        overview= "Following the events of Captain America: Civil War, Peter Parker, with the help of his mentor Tony Stark, tries to balance his life as an ordinary high school student in Queens, New York City, with fighting crime as his superhero alter ego Spider-Man as a new threat, the Vulture, emerges.";
        genres=new ArrayList< Integer>(Arrays.asList(28,12,878));
        //moviesList.add(createMovie(id,R.drawable.spiderman,vote_count,vote_avg, title, poster_path, overview,release_date, genres)) ;
        //6
        id=324852;
        vote_count=1687;
        vote_avg=6.2;
        title="Despicable Me 3";
        release_date= "2017-06-15";
        poster_path= "/5qcUGqWoWhEsoQwNUrtf3y3fcWn.jpg";
        overview= "Gru and his wife Lucy must stop former '80s child star Balthazar Bratt from achieving world domination.";
        genres=new ArrayList< Integer>(Arrays.asList(878,12,16,35,1075));
        //moviesList.add(createMovie(id,R.drawable.despicable3,vote_count,vote_avg, title,poster_path, overview,release_date, genres)) ;
        //7
        id=353491;
        vote_count=549;
        vote_avg=5.6;
        title="The dark Tower";
        poster_path= "/i9GUSgddIqrroubiLsvvMRYyRy0.jpg";
        release_date= "2017";
        overview= "The last Gunslinger, Roland Deschain, has been locked in an eternal battle with Walter O’Dim, also known as the Man in Black, determined to prevent him from toppling the Dark Tower, which holds the universe together. With the fate of the worlds at stake, good and evil will collide in the ultimate battle as only Roland can defend the Tower from the Man in Black.";
        genres=new ArrayList< Integer>(Arrays.asList(28,37,878,14,27));
        //moviesList.add(createMovie(id,R.drawable.darktower,vote_count,vote_avg, title, poster_path,overview,release_date, genres)) ;
        //8
        id=374720;
        vote_count=2214;
        vote_avg=7.5;
        title="Dunkirk";
        release_date= "2017";
        poster_path= "/bOXBV303Fgkzn2K4FeKDc0O31q4.jpg";
        genres=new ArrayList< Integer>(Arrays.asList(28,18,36,53,10752));
        overview= "The miraculous evacuation of Allied soldiers from Belgium, Britain, Canada and France, who were cut off and surrounded by the German army from the beaches and harbor of Dunkirk, France, between May 26th and June 4th 1940, during the Battle of France in World War II.";
        //moviesList.add(createMovie(id,R.drawable.dunkirk,vote_count,vote_avg, title,poster_path, overview,release_date, genres)) ;
        //9
        id=293768;
        vote_count=202;
        vote_avg=5.8;
        title="Kidnap";
        poster_path= "/9CabD3j9PrjRY054fL0WJuEcXHZ.jpg";
        release_date= "2017-08-04";
        genres=new ArrayList< Integer>(Arrays.asList(18,53));
        overview= "Single mother Karla McCoy lives a perfect life with her young son Frankie. One day, upon entering a local park, Karla sees her son suddenly being abducted out of the blue by a kidnapper. To save Frankie from being taken, Karla goes out on a mission to demand people in the city to help rescue her son.";
        //moviesList.add(createMovie(id,R.drawable.kidnap,vote_count,vote_avg, title, poster_path,overview,release_date, genres)) ;
        //10
        id=381283;
        vote_count=13;
        vote_avg=5.9;
        title="Mother!";
        poster_path= "/qmi2dsuoyzZdJ0WFZYQazbX8ILj.jpg";
        release_date= "2017";
        genres=new ArrayList< Integer>(Arrays.asList(18,27,9648,53));
        overview= "A couple's relationship is tested when uninvited guests arrive at their home, disrupting their tranquil existence.";
        //moviesList.add(createMovie(id,R.drawable.mother,vote_count,vote_avg, title,poster_path, overview,release_date, genres)) ;
        //11
        id=339692;
        vote_count=188;
        vote_avg=6.9;
        title="Shot Caller";
        release_date= "2017";
        poster_path="/qLmLz2wtyYvmW8Ult3l2ngOnW8v.jpg";
        genres=new ArrayList< Integer>(Arrays.asList(18,80,53));
        overview= "A newly-released prison gangster is forced by the leaders of his gang to orchestrate a major crime with a brutal rival gang on the streets of Southern California.";
        //moviesList.add(createMovie(id,R.drawable.shotcaller,vote_count,vote_avg, title, poster_path,overview,release_date, genres)) ;
        //12
        id=430682;
        vote_count=11;
        vote_avg=5.5;
        title="Gun Shy";
        poster_path= "/ugzaRtgrf2MBCUawgiE6xayXXIE.jpg";
        release_date= "2014";
        genres=new ArrayList< Integer>(Arrays.asList(35,18,12));
        overview= "A mega-platinum, aging rock star's supermodel wife is abducted by pirates while vacationing in Chile.";
        //moviesList.add(createMovie(id,R.drawable.gunshy,vote_count,vote_avg, title,poster_path, overview,release_date, genres)) ;
        //13
        id=281338;
        vote_count=1425;
        vote_avg=6.7;
        title="War for the Planet of the Apes";
        poster_path= "/3vYhLLxrTtZLysXtIWktmd57Snv.jpg";
        release_date= "2010";
        overview= "Caesar and his apes are forced into a deadly conflict with an army of humans led by a ruthless Colonel. After the apes suffer unimaginable losses, Caesar wrestles with his darker instincts and begins his own mythic quest to avenge his kind. As the journey finally brings them face to face, Caesar and the Colonel are pitted against each other in an epic battle that will determine the fate of both their species and the future of the planet.";
       // moviesList.add(createMovie(id,R.drawable.warofapes,vote_count,vote_avg, title,poster_path, overview,release_date, genres)) ;
        //14
        id=433637;
        vote_count=0;
        vote_avg=0.0;
        title="What Still Remains";
        poster_path="/8FnKMD3zS5dZIufLKGaJApYuQSk.jpg";
        release_date= "2016";
        genres=new ArrayList< Integer>(Arrays.asList(53,18));
        overview= "After the loss of her family, a young woman struggles to survive in a world long-since destroyed by disease; but when a lonely traveler offers her a place in his community, she must decide if the promise of a better life is worth the risk of trusting him.";
        //moviesList.add(createMovie(id,R.drawable.whatstillremains,vote_count,vote_avg, title, poster_path, overview,release_date, genres)) ;
        //15
        id=395814;
        vote_count=32;
        vote_avg=6.6;
        title="Rememory";
        release_date= "2010";
        poster_path="/sGQ4kix7bIT35ePpJzA2rNNaxPY.jpg";
        genres=new ArrayList< Integer>(Arrays.asList(878,18,9648));
        overview= "The widow of a wise professor stumbles upon one of his inventions that's able to record and play a person's memory.";
        //moviesList.add(createMovie(id,R.drawable.rememory,vote_count,vote_avg, title, poster_path, overview,release_date, genres)) ;
        //16
        id=342473;
        vote_count=352;
        vote_avg=7.1;
        title="Ballerina";
        release_date= "2016";
        poster_path="/60ZhK1FstSkC9Ms8lRWaTPm55kD.jpg";
        genres=new ArrayList< Integer>(Arrays.asList(12,16,35,10751));
        overview= "Set in 1879 Paris. An orphan girl dreams of becoming a ballerina and flees her rural Brittany for Paris, where she passes for someone else and accedes to the position of pupil at the Grand Opera house.";
        //moviesList.add(createMovie(id,R.drawable.ballerina,vote_count,vote_avg, title, poster_path, overview,release_date, genres)) ;
        //17
        id=427900;
        vote_count=7;
        vote_avg=3.4;
        title="Home Again";
        release_date= "2017";
        poster_path="/z5CtCxpblBke2G8c7CMkstedMgY.jpg";
        genres=new ArrayList< Integer>(Arrays.asList(35,18));
        overview= "Life for a single mom in Los Angeles takes an unexpected turn when she allows three young guys to move in with her.";
        //moviesList.add(createMovie(id,R.drawable.homeagain,vote_count,vote_avg, title, poster_path, overview,release_date, genres)) ;
        //18
        id=399170;
        vote_count=83;
        vote_avg=6.6;
        title="Logan Lucky";
        release_date= "2017";
        poster_path="/mQrhrBaaHvRfBQq0Px3HtVbH9iE.jpg";
        genres=new ArrayList< Integer>(Arrays.asList(28,80,35));
        overview= "Trying to reverse a family curse, brothers Jimmy and Clyde Logan set out to execute an elaborate robbery during the legendary Coca-Cola 600 race at the Charlotte Motor Speedway.";
        //moviesList.add(createMovie(id,R.drawable.loganlucky,vote_count,vote_avg, title, poster_path, overview,release_date, genres)) ;
        //19
        id=408648;
        vote_count=57;
        vote_avg=5.5;
        title="Batman and Harley Quinn";
        release_date= "2017";
        poster_path="/uVdxoD9kn28qC8VQiVA6Uif1QHl.jpg";
        overview= "Batman and Nightwing are forced to team with the Joker's sometimes-girlfriend Harley Quinn to stop a global threat brought about by Poison Ivy and Jason Woodrue, the Floronic Man.";
        genres=new ArrayList< Integer>(Arrays.asList(12,28,16));
        //moviesList.add(createMovie(id,R.drawable.batman,vote_count,vote_avg, title, poster_path, overview,release_date, genres)) ;
        //20
        id=467432;
        vote_count=3;
        vote_avg=6.0;
        title="True to the Game";
        release_date= "2011";
        poster_path="/yCNlqcRdP9haLmCgBiD5zX59F9P.jpg";
        genres=new ArrayList< Integer>(Arrays.asList(18));
        overview= "Based on the Terri Woods best selling novel, True to the Game is the love story of Quadir Richards, a charismatic drug lord, and Gena Rollins, a young girl from the projects of Philly. Quadir was able to gain the trust and love of Gena and was on his way out of the game to start a new life with his future bride when tragedy strikes.";
       // moviesList.add(createMovie(id,R.drawable.thegame,vote_count,vote_avg, title, poster_path, overview,release_date, genres)) ;
        //21
        id=211672;
        vote_count=4381;
        vote_avg=6.4;
        title="Minions";
        release_date= "2015";
        poster_path="/q0R4crx2SehcEEQEkYObktdeFy.jpg";
        genres=new ArrayList< Integer>(Arrays.asList(10751,16,12,35));
        overview= "Minions Stuart, Kevin and Bob are recruited by Scarlet Overkill, a super-villain who, alongside her inventor husband Herb, hatches a plot to take over the world.";
       // moviesList.add(createMovie(id,R.drawable.minions,vote_count,vote_avg, title, poster_path, overview,release_date, genres)) ;
        //22
        id=118340;
        vote_count=9398;
        vote_avg=7.9;
        title="Gaurdians of Galaxy";
        poster_path="/y31QB9kn3XSudA15tV7UWQ9XLuW.jpg";
        genres=new ArrayList< Integer>(Arrays.asList(28,878,12));
        overview= "Light years from Earth, 26 years after being abducted, Peter Quill finds himself the prime target of a manhunt after discovering an orb wanted by Ronan the Accuser.";
       // moviesList.add(createMovie(id,R.drawable.guardiansofgalaxy,vote_count,vote_avg, title, poster_path, overview,release_date, genres)) ;
        //23
        id=321612;
        vote_count=5158;
        vote_avg=6.8;
        title="Beauty and the Beast";
        release_date= "2017";
        poster_path="/tWqifoYuwLETmmasnGHO7xBjEtt.jpg";
        genres=new ArrayList< Integer>(Arrays.asList(10751,14,10749));
        overview= "A live-action adaptation of Disney's version of the classic 'Beauty and the Beast' tale of a cursed prince and a beautiful young woman who helps him break the spell.";
       // moviesList.add(createMovie(id, R.drawable.beautyandthebeast,vote_count,vote_avg, title, poster_path, overview,release_date, genres)) ;
        //24
        id=157336;
        vote_count=10592;
        vote_avg=8.1;
        title="Interstellar";
        release_date= "2014";
        poster_path="/nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg";
        genres=new ArrayList< Integer>(Arrays.asList(18,12,878));
        overview= "Interstellar chronicles the adventures of a group of explorers who make use of a newly discovered wormhole to surpass the limitations on human space travel and conquer the vast distances involved in an interstellar voyage.";
        //moviesList.add(createMovie(id,R.drawable.interstellar,vote_count,vote_avg, title, poster_path, overview,release_date, genres)) ;
        //25
        id=415842;
        vote_count=5;
        vote_avg=4.2;
        title="American Assassin";
        release_date= "2017";
        poster_path="/o40BAqdTQHiN3cUfpgieDUYI71z.jpg";
        genres=new ArrayList< Integer>(Arrays.asList(53,28));
        overview= "Mitch Rapp is a CIA black ops recruit under the instruction of Cold War veteran Stan Hurley. The pair then is enlisted by CIA Deputy Director Irene Kennedy to investigate a wave of apparently random attacks on military and civilian targets. Together they discover a pattern in the violence that leads them to a joint mission with a lethal Turkish agent to stop a mysterious operative intent on starting a world war in the Middle East.";
        //moviesList.add(createMovie(id, R.drawable.americanassassin,vote_count,vote_avg, title, poster_path, overview,release_date, genres)) ;

    }

    private HashMap createMovie(Integer id, int image,Integer vCount, Double vAvg, String title,String poster, String overview, String release, List < Integer > genres ) {
        HashMap movie =new HashMap();
        movie.put("image",image);
        movie.put("id",id);
        movie.put("voteCount",vCount);
        movie.put ("release" , release );
        movie.put("voteAverage",vAvg);
        movie.put("title",title);
        movie.put("genres",genres);
        movie.put("overview",overview);
        movie.put("poster",poster);
        movie.put("selection",false);
        return movie;
    }
    public List<Map<String, ?>> addItem(int position,Map<String,?> map){
        moviesList.add(position,map);
        return  moviesList;

    }

    public List<Map<String, ?>> selectall(List<Map<String, ?>> moviesList){
        for(Map<String, ?> map : moviesList){

            HashMap<String,Boolean> temp= (HashMap<String,Boolean>)map;
            temp.put("selection", true);
        }
        return moviesList;
    }

    public List<Map<String, ?>> clearall(List<Map<String, ?>> moviesList){
        for(Map<String, ?> map : moviesList){

            HashMap<String,Boolean> temp= (HashMap<String,Boolean>)map;
            temp.put("selection",false);
        }
        return moviesList;
    }

    public void delete(List<Map<String, ?>> moviesList){
        ArrayList ary = new ArrayList();
        for(Map<String, ?> map : moviesList){

            HashMap<String,Boolean> temp= (HashMap<String,Boolean>)map;
            Boolean selection = temp.get("selection");
            if(selection ==true){
                ary.add(map);
            }
        }
        moviesList.removeAll(ary);
    }
    public int  findFirst(String Query){
        int position = 0;
        for(Map<String,?> map: moviesList){
            HashMap<String,String> temp = (HashMap<String,String>)map;
            String selection = temp.get("title");
            if(selection.toLowerCase().contains(Query.toLowerCase()))
                position = moviesList.indexOf(temp);
        }
        return position;
    }

    public void sort(List<Map<String, ?>> moviesList){
        Collections.sort(moviesList, Comparators.Sort_Year);
    }

    public static class Comparators {

        public static Comparator<Map<String, ?>> Sort_Year = new Comparator<Map<String, ?>>() {
            @Override
            public int compare(Map<String, ?> j1, Map<String, ?> j2) {
                int i1 = (Integer.parseInt(j1.get("release").toString().substring(0, 4)));
                int i2 = (Integer.parseInt(j2.get("release").toString().substring(0, 4)));
                return (i1 < i2) ? 1 : ((i1 > i2) ? -1 : 0);
            }
        };
        public static Comparator<Map<String, ?>> NameSort = new Comparator<Map<String, ?>>() {
            @Override
            public int compare(Map<String, ?> o1, Map<String, ?> o2) {
                return o1.get("title").toString().compareTo(o2.get("title").toString());
            }
        };
    }
    public void sortByName(List<Map<String, ?>> moviesList) {
        Collections.sort(moviesList, Comparators.NameSort);
    }

}

