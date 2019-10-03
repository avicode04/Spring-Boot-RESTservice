package com.stackroute.Movie.service;

import com.stackroute.Movie.domain.Movie;
import com.stackroute.Movie.repository.movieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class movieServiceImpl implements movieService {

    movieRepository movieRepo;

    @Autowired
    public movieServiceImpl(movieRepository movieRepository){
        this.movieRepo=movieRepository;
    }

    @Override
    public Movie saveMovie(Movie movie) {
        Movie newMovie= movieRepo.save(movie);
        System.out.println(movie.getMovieTitle());
        return newMovie;
    }

    @Override
    public Movie showMovieDetails(int movieId) {
        Movie findMovie= movieRepo.findById(movieId).orElse(null);
        return findMovie;
    }

    @Override
    public List<Movie> showMovieList() {
        List<Movie> movieList=movieRepo.findAll();
        for(Movie m:movieList){
            System.out.println(m.getMovieTitle());
        }
        return movieList;
    }

    @Override
    public int showMovieCount() {
        int count=showMovieList().size();
        return count;
    }

    @Override
    public boolean updateMovie(Movie movie) {
        Movie foundMovie =movieRepo.getOne(movie.getMovieId());
        foundMovie.setMovieDesc(movie.getMovieDesc());
        foundMovie.setMovieTitle(movie.getMovieTitle());
        foundMovie.setVoteAverage(movie.getVoteAverage());
        foundMovie.setVoteCount(movie.getVoteCount());
        movieRepo.save(foundMovie);
        return true;
    }

    @Override
    public boolean deleteMovie(int movieId) {
        if(movieRepo.findById(movieId).orElse(null)==null){
            return false;
        }
        movieRepo.delete(movieRepo.findById(movieId).orElse(null));
        return true;
    }
}
