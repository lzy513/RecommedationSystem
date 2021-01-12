package com.lzy.movie;

import java.util.ArrayList;
import java.util.*;

public class MovieRunnerAverage {

    public void printAverageRatings(){
        SecondRatings sr = new SecondRatings();


        double min =100;
        ArrayList<Rating> movieRatings = sr.getAverageRatings(12);
        Collections.unmodifiableList(movieRatings);
        for(Rating rating : movieRatings){
            if(rating.getValue()<min) {
                min = rating.getValue();
                System.out.println(sr.getTitle(rating.getItem()) + ": " + rating.getValue());
            }
        }
    }
    public void getAverageRatingOneMovie(){
        SecondRatings sr = new SecondRatings();

        String s = "Vacation";
        String movieID = sr.getId(s);
        double rating = 0.0;
        ArrayList<Rating> movieRatings = sr.getAverageRatings(1);
        for(Rating rt : movieRatings){
            if(rt.getItem().equals(movieID)){
                rating = rt.getValue();
            }
        }
        System.out.println("The rating of " +s+" is "+rating);

    }
}
