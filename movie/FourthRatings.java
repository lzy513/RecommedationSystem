package com.lzy.movie;

import com.lzy.filter.Filter;
import com.lzy.filter.TrueFilter;
import com.lzy.rater.Rater;
import com.lzy.rater.RaterDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class FourthRatings {



    public FourthRatings() {
        RaterDatabase.initialize();
    }






    private double getAverageById(String id, int minimalRaters){
        int numOfRaters = 0;
        double ratings = 0.0;
        for (Rater rater : RaterDatabase.getRaters()){
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



    public ArrayList<Rating> getSimilarRatings(String id,int numSimilarRaters,int minimalRaters){
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        ArrayList<Rating> weightedRatings = new ArrayList<>();
        ArrayList<Rating> similarRatings = getSimilarities(id);

        HashMap<String,Double> totalRating = new HashMap<>();
        HashMap<String,Integer> totalCount = new HashMap<>();




        for(String movieID : movies){
            double currentRating = 0.0;
            int currentCount = 0;

            for(int i=0;i<numSimilarRaters;i++){
                Rating simRatings = similarRatings.get(i);
                String raterID = simRatings.getItem();
                double weight = simRatings.getValue();

                Rater rater = RaterDatabase.getRater(raterID);

                if(rater.hasRating(movieID)){
                    double rating = rater.getRatings(movieID) * weight;
                    currentRating += rating;
                    currentCount++;
                }
            }
            if(currentCount >=minimalRaters){
                totalRating.put(movieID,currentRating);
                totalCount.put(movieID,currentCount);
            }
        }
        for(String movieID : totalRating.keySet()){
            double weightedRating = Math.round(totalRating.get(movieID)/totalCount.get(movieID) *100.0)/100.0;
            Rating rating = new Rating(movieID,weightedRating);
            weightedRatings.add(rating);
        }
        Collections.sort(weightedRatings, Collections.reverseOrder());
        return weightedRatings;

    }
    public ArrayList<Rating> getSimilarRatingsByFilter
            (String id,int numSimilarRaters,int minimalRaters,Filter filterCritera){
        ArrayList<String> filteredMovies = MovieDatabase.filterBy(filterCritera);
        ArrayList<Rating> weightedRatings = new ArrayList<>();
        ArrayList<Rating> similarRatings = getSimilarities(id);

        HashMap<String,Double> totalRating = new HashMap<>();
        HashMap<String,Integer> totalCount = new HashMap<>();




        for(String movieID : filteredMovies){
            double currentTotalRating = 0.0;
            int currentCount = 0;
            for(int i=0;i<numSimilarRaters;i++){
                Rating ratings = similarRatings.get(i);
                String raterID = ratings.getItem();
                double weight = ratings.getValue();

                Rater rater = RaterDatabase.getRater(raterID);

                if(rater.hasRating(movieID)){
                    double rating = rater.getRatings(movieID)*weight;
                    currentTotalRating += rating;
                    currentCount++;
                }
            }
            if(currentCount >=minimalRaters){
                totalRating.put(movieID,currentTotalRating);
                totalCount.put(movieID,currentCount);
            }
        }
        for(String movieID : totalRating.keySet()){
            double weightedRating = Math.round(totalRating.get(movieID)/totalCount.get(movieID));
            Rating rating = new Rating(movieID,weightedRating);
            weightedRatings.add(rating);
        }
        Collections.sort(weightedRatings, Collections.reverseOrder());
        return weightedRatings;

    }
    private double dotProduct(Rater me,Rater r){
        double rating = 0.0;
        ArrayList<String> list = me.getItemsRated();

        for(String item : list){
            if(r.getItemsRated().contains(item)){
                double currentRatingMe = me.getRatings(item);
                double currentRatingR = r.getRatings(item);

                rating += (currentRatingMe-5.0)*(currentRatingR-5.0);
            }
        }
        return rating;
    }
    private ArrayList<Rating> getSimilarities(String id){
        ArrayList<Rating> similaritiesList = new ArrayList<>();
        Rater me = RaterDatabase.getRater(id);

        for(Rater rater : RaterDatabase.getRaters()){
            if(!rater.getMyID().equals(id)){
                double rating = dotProduct(me,rater);
                if(rating >= 0){
                    similaritiesList.add(new Rating(rater.getMyID(),rating));
                }
            }
        }
        Collections.sort(similaritiesList,Collections.reverseOrder());
        return similaritiesList;
    }


}
