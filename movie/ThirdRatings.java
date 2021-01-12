package com.lzy.movie;

import com.lzy.filter.Filter;
import com.lzy.filter.TrueFilter;
import com.lzy.rater.Rater;

import java.util.ArrayList;


public class ThirdRatings {
    private ArrayList<Rater> myRaters;


    public ThirdRatings() {
        FirstRatings fr =new FirstRatings();
        myRaters = fr.loadRaters();
    }


    public int getNumOfRaters(){
        int numOfRaters = myRaters.size();
        return numOfRaters;
    }



    private double getAverageById(String id, int minimalRaters){
        int numOfRaters = 0;
        double ratings = 0.0;
        for (Rater rater : myRaters){
            if(rater.hasRating(id)){
                numOfRaters++;
                ratings += rater.getRatings(id);
            }
        }
        if(numOfRaters>=minimalRaters) {
            return ratings/numOfRaters;
        }
        return 0.0;

    }



    public ArrayList<Rating> getAverageRatings(int minimalRaters){
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        ArrayList<Rating> movieAverageRatings = new ArrayList<>();

        for(String movieID : movies){

            double average = getAverageById(movieID,minimalRaters);
            if(average!=0.0){
                Rating rating =new Rating(movieID,average);
                movieAverageRatings.add(rating);
            }
        }
        return movieAverageRatings;
    }
    public ArrayList<Rating> getAverageRatingsByFilter(int minimalRater
            , Filter filterCritera){
        ArrayList<Rating> averageRatings = new ArrayList<>();
        ArrayList<String> filteredMovies = MovieDatabase.filterBy(filterCritera);
        for(String movieID : filteredMovies){
            double average = getAverageById(movieID, minimalRater);

            if(average!=0) {
                Rating rating = new Rating(movieID, average);
                averageRatings.add(rating);
            }

        }
        return  averageRatings;
    }




}
