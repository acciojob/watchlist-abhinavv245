package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



    @Service
    public class MovieService {
        @Autowired
        MovieRepository movieRepository;
        String addmovie(Movie movie){
            return movieRepository.addMovie(movie);

        }

        String adddirector(Director director){
            return movieRepository.addDirector(director);
        }

        Movie getmoviebyname(String name){
            return movieRepository.getmovie(name);
        }

        Director getdirectorbyname(String name){
            return movieRepository.getdirecor(name);
        }

        String addmoviedirectorPair(String mvName, String dirName){
            return movieRepository.addpair(mvName,dirName);
        }

        List getallmovies(){
            return movieRepository.getAllMovies();
        }

        String deleteDirectorByName(String dirName){
            return movieRepository.deleteDirectorByName(dirName);
        }

        String deleteAllDirectors(){
            return movieRepository.deleteAllDirectors();
        }

        List getMoviesByDirectorName(String dirName){
            return movieRepository.getMoviesByDirectorName(dirName);
        }

        String getDirectorByMovieName(String mvName){
            return movieRepository.getDirectorByMovieName(mvName);
        }
}
