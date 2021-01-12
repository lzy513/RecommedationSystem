package com.lzy.recommender;

import com.lzy.filter.TrueFilter;
import com.lzy.movie.FourthRatings;
import com.lzy.movie.MovieDatabase;
import com.lzy.movie.Rating;
import com.lzy.rater.RaterDatabase;

import java.util.ArrayList;
import java.util.Random;


public class RecommendationRunner implements Recommender{

    public ArrayList<String> getItemsToRate(){
        MovieDatabase.initialize();
        ArrayList<String> items = new ArrayList<>();
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());

        for(int i=0;i<=20;i++){
            Random random = new Random();
            int rand = random.nextInt(movies.size());
            if(!items.contains(movies.get(rand))){
                items.add(movies.get(rand));
            }
        }
        return items;
    }

    public void printRecommendationsFor(String webRaterID){
        MovieDatabase.initialize();
        FourthRatings fr = new FourthRatings();

        System.out.println("<p>Read data for : " + Integer.toString(RaterDatabase.size())+" Raters</p>");
        System.out.println("<p>Read data for : " + Integer.toString(MovieDatabase.size())+" Movies</p>");

        int numSimilarRaters = 10;
        int minimalRatings =3;

        ArrayList<Rating> similarRatings = fr.getSimilarRatings(webRaterID,numSimilarRaters,minimalRatings);

        if(similarRatings.size() == 0){
            System.out.println("no such Movies");

        }else{
            String header = ("<table><tr><th>Movie Title</th><th>Rating</th> <th>Genres</th></tr>");
            String body = "";
            for(Rating rating : similarRatings){
                body +="<tr><td>"+MovieDatabase.getTitle(rating.getItem())+"</td><td>"+
                        Double.toString(rating.getValue())+"</td><td>"+MovieDatabase.getGenres(rating.getItem())
                        +"</td></tr>";
            }
            System.out.println(header + body + "</table>");
        }



    }

}
