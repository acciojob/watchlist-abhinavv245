package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;

@Repository
public class MovieRepository {

  HashMap<String,Movie> movieMap= new HashMap<>();
  HashMap<String,Director> dirMap=new HashMap<>();
  HashMap<String, List<String>> dirMovieMap= new HashMap<>();



    public void addMovie(Movie movie){
        movieMap.put(movie.getName(),movie);
    }
    public void addDirector(Director director){
       dirMap.put(director.getName(),director);
    }

    public void addMovieDirectorPair(String director,String movie) {
        if (dirMap.containsKey(director) && movieMap.containsKey(movie)) {
            if (dirMovieMap.containsKey(director)) dirMovieMap.get(director).add(movie);
            else {
                List<String> currentMovies = new ArrayList<>();

                currentMovies.add(movie);
                dirMovieMap.put(director, currentMovies);
            }
        }
    }
    public Movie getMovieByName(String name){
            return movieMap.get(name);
    }
    public Director getDirectorByName(String name){
            return dirMap.get(name);
    }
    public List<String> getMoviesByDirectorName(String director){
        List<String> list= new ArrayList<>();
        if(dirMovieMap.containsKey(director)) list=dirMovieMap.get(director);
        return list;
    }
    public List<String> findAllMovies(){
        return new ArrayList<>(movieMap.keySet());
    }

    public void deleteDirectorByName(String director){
        if(dirMap.containsKey(director)) {

            if (dirMovieMap.containsKey(director)) {
                List<String> movies = dirMovieMap.get(director);
                for (String movie : movies) {
                        movieMap.remove(movie);
                }
                dirMovieMap.remove(director);
            }
            dirMap.remove(director);
        }
    }
    public void deleteAllDirectors(){
        ArrayList<String> list=new ArrayList<>();
        for(String director: dirMovieMap.keySet()){
            list.addAll(dirMovieMap.get(director));
        }
        for(String movie:list){
                movieMap.remove(movie);
        }
    }

}
