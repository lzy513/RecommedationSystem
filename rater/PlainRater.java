package com.lzy.rater;

import com.lzy.movie.Rating;

import java.util.ArrayList;

public class PlainRater implements Rater{
    private String myID;
    private ArrayList<Rating> myRatings;

    public PlainRater(String myID) {
        this.myID = myID;
        myRatings = new ArrayList<>();

    }


    public void addRating(String item,double rating){
        myRatings.add(new Rating(item,rating));

    }

    public String getMyID(){
        return myID;
    }
    public boolean hasRating(String item){
        for(int i=0;i<myRatings.size();i++){
            if(myRatings.get(i).getItem().equals(item)){
                return true;
            }
        }
        return false;
    }

    public double getRatings(String item) {
        for(int i=0;i<myRatings.size();i++){
            if(myRatings.get(i).getItem().contains(item)){
                return myRatings.get(i).getValue();
            }
        }
        return -1;
    }

    public int numRatings(){
        return myRatings.size();
    }

    public ArrayList<String> getItemsRated(){
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0; i<myRatings.size(); i++){
            list.add(myRatings.get(i).getItem());
        }
        return list;
    }
}
