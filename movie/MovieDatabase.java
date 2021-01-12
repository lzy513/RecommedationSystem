package com.lzy.movie;

import com.lzy.filter.Filter;

import java.util.ArrayList;
import java.util.HashMap;

public class MovieDatabase {
    static HashMap<String,Movie> movieInfo;




    public static void initialize(){
        FirstRatings fr = new FirstRatings();

        if(movieInfo == null){
            movieInfo = new HashMap<>();
            loadMovies();

        }else{
            movieInfo = new HashMap<>();
            loadMovies("ratemoviesfull");
        }
    }

    private static void loadMovies(String filename){
        FirstRatings fr = new FirstRatings();
        ArrayList<Movie> list = fr.loadMovies(filename);
        for(Movie mv : list){
            movieInfo.put(mv.getId(),mv);
        }
    }
    private static void loadMovies(){
        FirstRatings fr = new FirstRatings();
        ArrayList<Movie> list = fr.loadMovies();
        for(Movie mv : list){
            movieInfo.put(mv.getId(),mv);
        }
    }

    public boolean containsID(String id){
        if(movieInfo.containsKey(id)){
            return  true;
        }
        return false;
    }

    public static int getYear(String id){
        return movieInfo.get(id).getYear();
    }
    public static String getTitle(String id){
        return movieInfo.get(id).getTitle();
    }
    public static String getMovie(String id){
        return movieInfo.get(id).getId();
    }
    public static String getPoster(String id){
        return movieInfo.get(id).getPoster();
    }
    public static int getMinutes(String id){
        return movieInfo.get(id).getMinutes();
    }
    public static String getCountry(String id){
        return movieInfo.get(id).getCountry();
    }
    public static String getGenres(String id){
        return movieInfo.get(id).getGenres();
    }
    public static String getDirector(String id){
        return movieInfo.get(id).getDirector();
    }
    public static int numOfMovies(){
        return movieInfo.size();
    }
    public static ArrayList<String> filterBy(Filter f){
        ArrayList<String> list = new ArrayList<>();
        for(String movieID : movieInfo.keySet()){
            if(f.satisfies(movieID)){
                list.add(movieID);
            }
        }
        return list;
    }
    public static int getNumOfMovies(){
        return movieInfo.keySet().size();
    }
    public static int size(){
        return movieInfo.size();
    }

}
