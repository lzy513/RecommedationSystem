package com.lzy.filter;

import com.lzy.movie.MovieDatabase;

public class GenresFilter implements Filter{
    private String genres;

    public GenresFilter(String genres){
        this.genres = genres;
    }
    public boolean satisfies(String id){
        return MovieDatabase.getGenres(id).contains(genres);

    }
}

