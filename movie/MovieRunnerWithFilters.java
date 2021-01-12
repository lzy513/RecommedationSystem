package com.lzy.movie;

import java.util.ArrayList;
import java.util.Collections;

import com.lzy.filter.*;

public class MovieRunnerWithFilters {

    public void printAverageRatings(){
        MovieDatabase.initialize();
        ThirdRatings tr = new ThirdRatings();


        System.out.println("Read data for " +tr.getNumOfRaters()+" raters");
        System.out.println("Read data for " +MovieDatabase.getNumOfMovies()+" movies");


        //double min = 100;
        ArrayList<Rating> movieRatings = tr.getAverageRatings(35);
        Collections.sort(movieRatings);
        System.out.println(movieRatings.size()+" movie matched");
//        for(Rating rating : movieRatings){
//            //if(rating.getValue()<min) {
//            //    min = rating.getValue();
//                System.out.println(rating.getValue() + ": " + MovieDatabase.getTitle(rating.getItem()));
//        }
    }

    public void printAveragerRatingsByYear(){
        MovieDatabase.initialize();
        ThirdRatings tr = new ThirdRatings();

        System.out.println("Read data for " +tr.getNumOfRaters()+" raters");
        System.out.println("Read data for " +MovieDatabase.getNumOfMovies()+" movies");

        ArrayList<Rating> movieRatings = tr.getAverageRatingsByFilter(20, new YearsAfterFilter(2000));
        Collections.sort(movieRatings);
        System.out.println(movieRatings.size()+" movie matched");
//        for(Rating rating : movieRatings){
//            System.out.println(rating.getValue()+" "+MovieDatabase.getYear(rating.getItem())+" "+MovieDatabase.getTitle(rating.getItem()));
//        }
    }

    public void printAveragerRatingsByGenres(){
        MovieDatabase.initialize();
        ThirdRatings tr = new ThirdRatings();

        System.out.println("Read data for " +tr.getNumOfRaters()+" raters");
        System.out.println("Read data for " +MovieDatabase.getNumOfMovies()+" movies");

        ArrayList<Rating> movieRatings = tr.getAverageRatingsByFilter(20, new GenresFilter("Comedy"));
        Collections.sort(movieRatings);
        System.out.println(movieRatings.size()+" movie matched");
//        for(Rating rating : movieRatings){
//            System.out.println(rating.getValue()+" "+MovieDatabase.getGenres(rating.getItem())+" "+MovieDatabase.getTitle(rating.getItem()));
//        }
    }

    public void printAveragerRatingsByMinutes(){
        MovieDatabase.initialize();
        ThirdRatings tr = new ThirdRatings();

        System.out.println("Read data for " +tr.getNumOfRaters()+" raters");
        System.out.println("Read data for " +MovieDatabase.getNumOfMovies()+" movies");

        ArrayList<Rating> movieRatings = tr.getAverageRatingsByFilter(5, new MinutesFilter(105,135));
        Collections.sort(movieRatings);
        System.out.println(movieRatings.size()+" movie matched");
//        for(Rating rating : movieRatings){
//            System.out.println(rating.getValue()+" Time: "+MovieDatabase.getMinutes(rating.getItem())+" "+MovieDatabase.getTitle(rating.getItem()));
//        }
    }

    public void printAveragerRatingsByDirector(){
        MovieDatabase.initialize();
        ThirdRatings tr = new ThirdRatings();

        System.out.println("Read data for " +tr.getNumOfRaters()+" raters");
        System.out.println("Read data for " +MovieDatabase.getNumOfMovies()+" movies");

        ArrayList<Rating> movieRatings = tr.getAverageRatingsByFilter(4, new DirectorFilter("Clint Eastwood,Joel Coen,Martin Scorsese,Roman Polanski,Nora Ephron,Ridley Scott,Sydney Pollack"));
        Collections.sort(movieRatings);
        System.out.println(movieRatings.size()+" movie matched");
//        for(Rating rating : movieRatings){
//            System.out.println(rating.getValue()+" "+MovieDatabase.getTitle(rating.getItem()));
//            System.out.println("  "+MovieDatabase.getDirector(rating.getItem()));
//        }
    }
    public void printAverageRatingsByYearAfterAndGenres(){
        MovieDatabase.initialize();
        ThirdRatings tr = new ThirdRatings();

        System.out.println("Read data for " +tr.getNumOfRaters()+" raters");
        System.out.println("Read data for " +MovieDatabase.getNumOfMovies()+" movies");

        AllFilters filters = new AllFilters();

        filters.add(new YearsAfterFilter(1990));
        filters.add(new GenresFilter("Drama"));

        ArrayList<Rating> movieRatings = tr.getAverageRatingsByFilter(8,filters);
        Collections.sort(movieRatings);
        System.out.println(movieRatings.size()+" movie matched");
//        for(Rating rating : movieRatings){
//            System.out.println(rating.getValue()+" "+MovieDatabase.getYear(rating.getItem())
//                    +" "+MovieDatabase.getTitle(rating.getItem()));
//            System.out.println("     "+MovieDatabase.getGenres(rating.getItem()));
//        }


    }
    public void printAverageRatingsByMinutesAndDirectors(){
        MovieDatabase.initialize();
        ThirdRatings tr = new ThirdRatings();

        System.out.println("Read data for " +tr.getNumOfRaters()+" raters");
        System.out.println("Read data for " +MovieDatabase.getNumOfMovies()+" movies");

        AllFilters filters = new AllFilters();

        filters.add(new MinutesFilter(90,180));
        filters.add(new DirectorFilter("Clint Eastwood,Joel Coen,Tim Burton,Ron Howard,Nora Ephron,Sydney Pollack"));

        ArrayList<Rating> movieRatings = tr.getAverageRatingsByFilter(3,filters);
        Collections.sort(movieRatings);
        System.out.println(movieRatings.size()+" movie matched");
//        for(Rating rating : movieRatings){
//            System.out.println(rating.getValue()+" Time: "+MovieDatabase.getMinutes(rating.getItem())
//                    +" "+MovieDatabase.getTitle(rating.getItem()));
//            System.out.println("     "+MovieDatabase.getDirector(rating.getItem()));
//        }


    }



}

