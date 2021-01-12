package com.lzy.rater;

import java.util.ArrayList;

public interface Rater {
    public void addRating(String item,double rating);

    public String getMyID();

    public boolean hasRating(String item);

    public double getRatings(String item);

    public int numRatings();

    public ArrayList<String> getItemsRated();
}
