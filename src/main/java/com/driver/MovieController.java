package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/movies/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
       return new ResponseEntity<>("Movie added successfully", HttpStatus.CREATED);

    }

    @PostMapping("/movies/add-director")
    public ResponseEntity addDirector(@RequestBody Director director){
        movieService.addDirector(director);
            return new ResponseEntity<>("Director added successfully", HttpStatus.CREATED);

    }
    @PostMapping("/movies/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("director") String director,@RequestParam ("movie") String movie){
     movieService.addMovieDirectorPair(director,movie);
     return new ResponseEntity<>("Director Movie Pair added",HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable("name") String name){
     Movie movie= movieService.getMovieByName(name);
     return new ResponseEntity(movie,HttpStatus.CREATED);

    }

    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable("name") String name){
        Director director= movieService.getDirectorByName(name);
        return new ResponseEntity(director,HttpStatus.CREATED);

    }
    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable("director") String director){
        List<String> response= movieService.getMoviesByDirectorName(director);
        return new ResponseEntity(response,HttpStatus.CREATED);
    }
    @GetMapping("/movies/get-all-movies")
    public ResponseEntity findAllMovies(){
     List<String> response= movieService.findAllMovies();
     return new ResponseEntity(response, HttpStatus.CREATED);
    }
    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("director") String director){
        movieService.deleteDirectorByName(director);
     return new ResponseEntity(director +" deleted successfully",HttpStatus.CREATED);
    }
    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
        movieService.deleteAllDirectors();
    return new ResponseEntity("Deleted all directors",HttpStatus.CREATED);
    }
}
