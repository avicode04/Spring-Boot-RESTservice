package com.stackroute.Movie.repository;

import com.stackroute.Movie.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface movieRepository extends JpaRepository<Movie, Integer> { }
