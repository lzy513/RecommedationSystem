package com.lzy.movie;

import com.lzy.rater.Rater;

import java.util.ArrayList;

public class SecondRatings {
    private ArrayList<Movie> myMovies;
    private ArrayList<Rater> myRaters;

    public SecondRatings(ArrayList<Movie> myMovies, ArrayList<Rater> myRaters) {
        this.myMovies = myMovies;
        this.myRaters = myRaters;
    }

    public SecondRatings(){
        FirstRatings fr = new FirstRatings();
        myMovies = fr.loadMovies();
        myRaters = fr.loadRaters();
    }

    public int getMovieSize(){
        return myMovies.size();
    }

    public int getRaterSize(){
        return myRaters.size();
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
        ArrayList<Rating> movieAverageRatings = new ArrayList<>();

        for(Movie movie : myMovies){
            String movieID = movie.getId();
            double average = getAverageById(movieID,minimalRaters);
            if(average!=0.0){
                Rating rating =new Rating(movieID,average);
                movieAverageRatings.add(rating);
            }
        }
        return movieAverageRatings;
    }

    public String getTitle(String id){
        for(Movie movie : myMovies){
            if(movie.getId().equals(id)){
                return movie.getTitle();
            }
        }

        return "ID was not found!";
    }

    public String getId(String title){
        for(Movie movie : myMovies){
            if(movie.getTitle().equals(title)){
                return movie.getId();
            }
        }
        return "NO SUCH TITLE";
    }

}
