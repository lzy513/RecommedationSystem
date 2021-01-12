package com.lzy.movie;

public class Rating implements Comparable<Rating>{
    private String item;
    private double value;

    public Rating(String item, double value) {
        this.item = item;
        this.value = value;
    }

    public String getItem() {
        return item;
    }

    public double getValue() {
        return value;
    }

    public String toString(){
        String result = "Movie rating is : " +getItem()+" "+getValue();
        return result;
    }

    public int compareTo(Rating others){
        if(value<others.getValue()){
            return -1;
        }
        if(value>others.getValue()){
            return 1;
        }
        return 0;
    }
}

