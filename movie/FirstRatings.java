package com.lzy.movie;
import com.lzy.rater.EfficientRater;
import com.lzy.rater.Rater;
import edu.duke.*;

import java.util.*;
import org.apache.commons.csv.*;

public class FirstRatings {
    private FileResource fr;



    public ArrayList<Movie> loadMovies(){

        fr = new FileResource();

        CSVParser parser = fr.getCSVParser();

        ArrayList<Movie> movieList = new ArrayList<>();

        for (CSVRecord record: parser) {
            String currentID = record.get(0);
            String currentTitle = record.get(1);
            String currentYear = record.get(2);
            String currentCountry = record.get(3);
            String currentGenre = record.get(4);
            String currentDirector = record.get(5);
            String currentMinutes = record.get(6);
            String currentPoster = record.get(7);

            Movie currentMovie = new Movie(currentID, currentTitle, Integer.parseInt(currentYear), currentGenre, currentDirector,
                    currentCountry, Integer.parseInt(currentMinutes), currentPoster);

            movieList.add(currentMovie);
        }

        return movieList;

    }

    public ArrayList<Movie> loadMovies(String filename){

        fr = new FileResource(filename);

        CSVParser parser = fr.getCSVParser();

        ArrayList<Movie> movieList = new ArrayList<>();

        for (CSVRecord record: parser) {
            String currentID = record.get(0);
            String currentTitle = record.get(1);
            String currentYear = record.get(2);
            String currentCountry = record.get(3);
            String currentGenre = record.get(4);
            String currentDirector = record.get(5);
            String currentMinutes = record.get(6);
            String currentPoster = record.get(7);

            Movie currentMovie = new Movie(currentID, currentTitle, Integer.parseInt(currentYear), currentGenre, currentDirector,
                    currentCountry, Integer.parseInt(currentMinutes), currentPoster);

            movieList.add(currentMovie);
        }

        return movieList;

    }



    public ArrayList<Rater> loadRaters(){
        fr = new FileResource();
        CSVParser parser = fr.getCSVParser();

        ArrayList<Rater> ratersData = new ArrayList<Rater> ();
        ArrayList<String> listOfIDs = new ArrayList<String> ();

        for (CSVRecord record : parser) {
            String raterID = record.get(0);
            String movieID = record.get(1);
            Double movieRating = Double.parseDouble(record.get(2));

            if(!listOfIDs.contains(raterID)){
                Rater rater = new EfficientRater(raterID);
                rater.addRating(movieID,movieRating);
                ratersData.add(rater);
            }else{
                for(int i=0;i<ratersData.size();i++){
                    if(ratersData.get(i).getMyID().equals(raterID)){
                        ratersData.get(i).addRating(movieID,movieRating);
                    }
                }

            }
            listOfIDs.add(raterID);

        }


        return ratersData;
    }
    public ArrayList<Rater> loadRaters(String ratingsfile){
        fr = new FileResource(ratingsfile);
        CSVParser parser = fr.getCSVParser();

        ArrayList<Rater> ratersData = new ArrayList<Rater> ();
        ArrayList<String> listOfIDs = new ArrayList<String> ();

        for (CSVRecord record : parser) {
            String raterID = record.get(0);
            String movieID = record.get(1);
            Double movieRating = Double.parseDouble(record.get(2));

            if(!listOfIDs.contains(raterID)){
                Rater rater = new EfficientRater(raterID);
                rater.addRating(movieID,movieRating);
                ratersData.add(rater);
            }else{
                for(int i=0;i<ratersData.size();i++){
                    if(ratersData.get(i).getMyID().equals(raterID)){
                        ratersData.get(i).addRating(movieID,movieRating);
                    }
                }

            }
            listOfIDs.add(raterID);

        }


        return ratersData;
    }









}
