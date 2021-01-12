package com.lzy.filter;

import com.lzy.movie.MovieDatabase;

public class MinutesFilter implements Filter{
    private int minMinutes;
    private int maxMinutes;

    public MinutesFilter(int min,int max){
        minMinutes = min;
        maxMinutes = max;
    }
    public boolean satisfies(String id){
        return MovieDatabase.getMinutes(id) >= minMinutes
                && MovieDatabase.getMinutes(id) <= maxMinutes;
    }
}
