package com.stackroute.Movie.controller;


import com.stackroute.Movie.domain.Movie;
import com.stackroute.Movie.service.movieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class movieController {
    movieService movieService;

    @Autowired
    public movieController(movieService movieService){
        this.movieService= movieService;
    }

    public movieController() {

    }

    @PostMapping("saveMovie")
    public ResponseEntity saveMovie(@RequestBody Movie movie){
        ResponseEntity responseEntity;
        try{
            movieService.saveMovie(movie);
            responseEntity = new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
        }catch(Exception ex){
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        movieService.saveMovie(movie);
        return responseEntity;
    }

    @PostMapping("showMovie")
    public ResponseEntity showMovie(){
        ResponseEntity responseEntity;
        try{
            movieService.showMovieList();
            responseEntity = new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
        }catch(Exception ex){
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        movieService.showMovieList();
        return responseEntity;
    }

    @PostMapping("updateMovie")
    public ResponseEntity updateMovie(@RequestBody Movie movie){
        ResponseEntity responseEntity;
        try{
            movieService.updateMovie(movie);
            responseEntity = new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
        }catch(Exception ex){
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
//        movieService.updateMovie(movie);
        return responseEntity;
    }

    @PostMapping("deleteMovie")
    public ResponseEntity deleteMovie(@RequestBody Movie movie){
        ResponseEntity responseEntity;
        try{
            movieService.deleteMovie(movie.getMovieId());
            responseEntity = new ResponseEntity<String>("Succesful deletion",HttpStatus.CREATED);
        }catch (Exception ex){
            responseEntity= new ResponseEntity(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("getMovie")
    public ResponseEntity getMovie(){
        ResponseEntity responseEntity;
        try{
            movieService.showMovieList();
            responseEntity=new ResponseEntity<String>("Succesful extract",HttpStatus.CREATED);
        }catch (Exception ex){
            responseEntity=new ResponseEntity<String>("Failed Extract",HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

}
