package com.lzy.movie;

import com.lzy.filter.*;
import com.lzy.rater.Rater;
import com.lzy.rater.RaterDatabase;

import java.util.ArrayList;
import java.util.Collections;

public class MovieRunnerSimilarRatings {
    public void printSimilarRatings(){
        MovieDatabase.initialize();

        FourthRatings fr = new FourthRatings();


        //System.out.println("Read data for " +fr.getNumOfRaters()+" raters");
        System.out.println("Read data for " +MovieDatabase.getNumOfMovies()+" movies");


        //double min = 100;
        ArrayList<Rating> movieRatings = fr.getSimilarRatings("71",20,5);

        System.out.println(movieRatings.size()+" movie matched");
        for(Rating rating : movieRatings){
            //if(rating.getValue()<min) {
            //    min = rating.getValue();
                System.out.println(rating.getValue() + ": " + MovieDatabase.getTitle(rating.getItem()));
        }
    }
    public void printSimilarRatingsByDirector(){
        MovieDatabase.initialize();
        FourthRatings fr = new FourthRatings();

        //System.out.println("Read data for " +fr.getNumOfRaters()+" raters");
        System.out.println("Read data for " +MovieDatabase.getNumOfMovies()+" movies");


        ArrayList<Rating> movieRatings = fr.getSimilarRatingsByFilter("120",10,2,
                new DirectorFilter("Clint Eastwood,J.J. Abrams,Alfred Hitchcock,Sydney Pollack,David Cronenberg,Oliver Stone,Mike Leigh"));
        Collections.sort(movieRatings);
        System.out.println(movieRatings.size()+" movie matched");
        for(Rating rating : movieRatings){
            System.out.println(rating.getValue()+
                     " : "+MovieDatabase.getTitle(rating.getItem()));
            System.out.println("     "+MovieDatabase.getDirector(rating.getItem()));
        }


    }
    public void printSimilarRatingsByGenres(){
        MovieDatabase.initialize();
        FourthRatings fr = new FourthRatings();

        //System.out.println("Read data for " +fr.getNumOfRaters()+" raters");
        System.out.println("Read data for " +MovieDatabase.getNumOfMovies()+" movies");


        ArrayList<Rating> movieRatings = fr.getSimilarRatingsByFilter("964",20,5,
                new GenresFilter("Mystery"));
        Collections.sort(movieRatings);
        System.out.println(movieRatings.size()+" movie matched");
        for(Rating rating : movieRatings){
            System.out.println(rating.getValue()+
                    " : "+MovieDatabase.getTitle(rating.getItem()));
            System.out.println("     "+MovieDatabase.getGenres(rating.getItem()));
        }


    }
    public void printSimilarRatingsByGenresAndMinutes(){
        MovieDatabase.initialize();
        FourthRatings fr = new FourthRatings();

        //System.out.println("Read data for " +fr.getNumOfRaters()+" raters");
        System.out.println("Read data for " +MovieDatabase.getNumOfMovies()+" movies");
        AllFilters af = new AllFilters();
        af.add(new GenresFilter("Drama"));
        af.add(new MinutesFilter(80,160));


        ArrayList<Rating> movieRatings = fr.getSimilarRatingsByFilter("168",10,3,
                af);
        Collections.sort(movieRatings);
        System.out.println(movieRatings.size()+" movie matched");
        for(Rating rating : movieRatings){
            System.out.println(rating.getValue()+" Time : "+MovieDatabase.getMinutes(rating.getItem())+
                    " : "+MovieDatabase.getTitle(rating.getItem()));
            System.out.println("     "+MovieDatabase.getGenres(rating.getItem()));
        }
    }
    public void printSimilarRatingsByYearAfterAndMinutes(){
        MovieDatabase.initialize();
        FourthRatings fr = new FourthRatings();

        //System.out.println("Read data for " +fr.getNumOfRaters()+" raters");
        System.out.println("Read data for " +MovieDatabase.getNumOfMovies()+" movies");
        AllFilters af = new AllFilters();
        af.add(new YearsAfterFilter(1975));
        af.add(new MinutesFilter(70,200));


        ArrayList<Rating> movieRatings = fr.getSimilarRatingsByFilter("314",10,5,
                af);
        Collections.sort(movieRatings);
        System.out.println(movieRatings.size()+" movie matched");
        for(Rating rating : movieRatings){
            System.out.println(rating.getValue()+" Time : "+MovieDatabase.getMinutes(rating.getItem())+
                    " : "+MovieDatabase.getTitle(rating.getItem()));
            System.out.println("     "+MovieDatabase.getYear(rating.getItem()));
        }
    }
}
