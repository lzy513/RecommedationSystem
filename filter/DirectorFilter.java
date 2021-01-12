package com.lzy.filter;

import com.lzy.movie.MovieDatabase;

public class DirectorFilter implements Filter{
    private String Director;

    public DirectorFilter(String Director){
        this.Director = Director;
    }
    public boolean satisfies(String id){
        String[] DirectorList = Director.split(",");
        for(String director : DirectorList){
            if(MovieDatabase.getDirector(id).contains(director)){
                return true;
            }
        }
        return false;
    }
}
