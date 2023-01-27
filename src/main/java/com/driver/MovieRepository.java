package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class MovieRepository {

   private HashMap<String,Movie> movieMap;
   private HashMap<String,Director> dirMap;
   private HashMap<String, List<String>> dirMovieMap;

    public MovieRepository() {
        this.movieMap = new HashMap<>();
        this.dirMap = new HashMap<>();
        this.dirMovieMap = new HashMap<>();
    }

    public void addMovie(Movie movie){
        movieMap.put(movie.getName(),movie);
    }
    public void addDirector(Director director){
       dirMap.put(director.getName(),director);
    }

    public void addMovieDirectorPair(String director,String movie){
        if(dirMap.containsKey(director) && movieMap.containsKey(movie)){
            List<String> currentMovies= new ArrayList<>();
            if(dirMovieMap.containsKey(director)) currentMovies=dirMovieMap.get(director);
            currentMovies.add(movie);
            dirMovieMap.put(director,currentMovies);
        }
    }
    public Movie getMovieByName(String name){
        if(movieMap.containsKey(name)){
            return movieMap.get(name);
        }
        return null;
    }
    public Director getDirectorByName(String name){
        if(dirMap.containsKey(name)){
            return dirMap.get(name);
        }
        return null;
    }
    public List<String> getMoviesByDirectorName(String director){
        List<String> list= new ArrayList<>();
        if(dirMovieMap.containsKey(director)) list=dirMovieMap.get(director);
        return list;
    }
    public List<String> findAllMovies(){
        List<String> list= new ArrayList<>();
        for(String movie: movieMap.keySet()){
            list.add(movie);
        }
        return list;
    }

    public void deleteDirectorByName(String director){
       List<String> movies= new ArrayList<>();
       if(dirMovieMap.containsKey(director)) {
           movies = dirMovieMap.get(director);
           for (String movie : movies) {
               if (movieMap.containsKey(movie)) {
                   movieMap.remove(movie);
               }
           }
           dirMovieMap.remove(director);
       }
       if(dirMap.containsKey(director)) dirMap.remove(director);
    }
    public void deleteAllDirectors(){
        HashSet<String> moviesSet= new HashSet<>();
        for(String director: dirMovieMap.keySet()){
            for(String movie: dirMovieMap.get(director)){
             moviesSet.add(movie);
            }
        }
        for(String movie:moviesSet){
            if(movieMap.containsKey(movie)){
                movieMap.remove(movie);
            }
        }
    }

}
