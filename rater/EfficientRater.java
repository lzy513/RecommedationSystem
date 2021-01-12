package com.lzy.rater;

import com.lzy.movie.Rating;

import java.util.ArrayList;
import java.util.HashMap;

public class EfficientRater implements Rater {
    private String myID;
    private HashMap<String, Rating> myRatings;

    public EfficientRater(String myID) {
        this.myID = myID;
        myRatings = new HashMap<>();

    }


    public void addRating(String item,double rating){
        myRatings.put(item,new Rating(item,rating));

    }

    public String getMyID(){
        return myID;
    }
    public boolean hasRating(String item){
        if(myRatings.containsKey(item)){
            return true;
        }

        return false;
    }

    public double getRatings(String item) {
        for(String movieID : myRatings.keySet()){
            if(movieID.equals(item)){
                return myRatings.get(movieID).getValue();
            }
        }
        return -1;
    }

    public int numRatings(){
        return myRatings.size();
    }

    public ArrayList<String> getItemsRated(){
        ArrayList<String> list = new ArrayList<String>();
        for(String movieID : myRatings.keySet()){
            list.add(myRatings.get(movieID).getItem());
        }
        return list;
    }
}
