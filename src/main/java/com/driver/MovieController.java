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
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie){
        String res=movieService.addmovie(movie);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/movies/add-director")
    public  ResponseEntity<String> addDirector(@RequestBody() Director director){
        String res=movieService.adddirector(director);
        return new ResponseEntity<>(res,HttpStatus.ACCEPTED);
    }

    @GetMapping("/movies/get-movie-by-name/{mvName}")
    public  ResponseEntity<Movie> getMovieByName(@PathVariable("mvName")String mvName){
        Movie movie=movieService.getmoviebyname(mvName);
        return new ResponseEntity<>(movie,HttpStatus.FOUND);
    }

    @GetMapping("/movies/get-director-by-name/{dirName}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("dirName") String dirName){
        Director obj=movieService.getdirectorbyname(dirName);
        return new ResponseEntity<>(obj,HttpStatus.ACCEPTED);
    }

    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("mvName") String mvName,@RequestParam("dirName") String dirName){
        String res=movieService.addmoviedirectorPair(mvName,dirName);
        return new ResponseEntity<>(res,HttpStatus.ACCEPTED);
    }

    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List st=movieService.getallmovies();
        return new ResponseEntity<>(st,HttpStatus.CREATED);
    }

    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam() String dirName){
        String res=movieService.deleteDirectorByName(dirName);
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        String res=movieService.deleteAllDirectors();
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public  ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("dirName") String dirName){
        List movieNames=movieService.getMoviesByDirectorName(dirName);
        return new ResponseEntity<>(movieNames,HttpStatus.OK);
    }

    @GetMapping("/movies/get-dirName-by-mvName/{mvName}")
    public  ResponseEntity<String> getDirectorName(@PathVariable("mvName")String mvName){
        String DirName=movieService.getDirectorByMovieName(mvName);
        return new ResponseEntity<>(DirName,HttpStatus.OK);
    }
}
