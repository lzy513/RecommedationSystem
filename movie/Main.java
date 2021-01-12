package com.lzy.movie;

import com.lzy.recommender.RecommendationRunner;

public class Main {
    public static void main(String[] args) {
        //MovieRunnerWithFilters mr = new MovieRunnerWithFilters();
        //mr.printAveragerRatingsByYear();
        //mr.printAveragerRatingsByGenres();
        //mr.printAveragerRatingsByMinutes();
        //mr.printAveragerRatingsByDirector();
        //mr.printAverageRatingsByYearAfterAndGenres();
        //mr.printAveragerRatingsByDirector();
        //mr.printAverageRatings();
        //mr.printAveragerRatingsByYear();
        //mr.printAveragerRatingsByGenres();
//        mr.printAverageRatingsByMinutesAndDirectors();
        //MovieRunnerSimilarRatings mr = new MovieRunnerSimilarRatings();
        //mr.printSimilarRatingsByGenres();
        //mr.printSimilarRatings();
        //mr.printSimilarRatingsByDirector();
        //mr.printSimilarRatingsByGenresAndMinutes();
        //mr.printSimilarRatingsByYearAfterAndMinutes();
        RecommendationRunner rr = new RecommendationRunner();
        rr.getItemsToRate();


    }
}
