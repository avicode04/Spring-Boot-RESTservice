package com.stackroute.Movie.service;

import com.stackroute.Movie.domain.Movie;

import java.util.List;

public interface movieService {

    public Movie saveMovie(Movie movie);

    public Movie showMovieDetails(int movieId);

    public List<Movie> showMovieList();

    public int showMovieCount();

    public boolean updateMovie(Movie movie);

    public boolean deleteMovie(int movieId);

}
