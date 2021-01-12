package com.lzy.rater;

import com.lzy.movie.FirstRatings;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.util.ArrayList;
import java.util.HashMap;

public class RaterDatabase {
    private static HashMap<String,Rater> raterInfo;


    public static void initialize(){

            raterInfo = new HashMap<>();
            loadRaters();
    }

    private static void loadRaters(){
        FirstRatings fr = new FirstRatings();
        ArrayList<Rater> list= fr.loadRaters();
        for(Rater rt : list){
            raterInfo.put(rt.getMyID(),rt);
        }
    }
    public static void addRatings(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();

        for (CSVRecord record : parser) {
            String ID = record.get(0);
            String item = record.get(1);
            Double rating = Double.parseDouble(record.get(2));
            addRaterRatings(ID,item,rating);
        }
    }

    public static void addRaterRatings(String raterID,String movieID,
                                       double rating){
        Rater rater = null;
        if(raterInfo.containsKey(raterID)){
            rater = raterInfo.get(raterID);
        }else{
            rater = new EfficientRater(raterID);
            raterInfo.put(raterID,rater);
        }
        rater.addRating(movieID,rating);
    }

    public static Rater getRater(String id){
        return raterInfo.get(id);
    }
    public static ArrayList<Rater> getRaters(){
        ArrayList<Rater> list = new ArrayList<Rater>(raterInfo.values());

        return list;
    }
    public static int size(){
        return raterInfo.size();
    }
}
