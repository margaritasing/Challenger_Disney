package com.example.challegerdisney.Service;

import com.example.challegerdisney.Entity.Genre;
import com.example.challegerdisney.Entity.Movie;
import com.example.challegerdisney.Repository.GenreRepository;
import com.example.challegerdisney.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MovieService {
    public final MovieRepository movieRepository;
    public final GenreRepository genreRepository;
    @Autowired
    public MovieService(MovieRepository movieRepository, GenreRepository genreRepository) {
        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
    }

    public List<Movie> getMovie(){
        return movieRepository.findAll();
    }


   public Movie save(Movie movie) {
        if (movie.getMovie_id()!=null){
                Movie movieExisten = movieRepository.findById(movie.getMovie_id()).orElse(null);
                if (movieExisten!=null){
                    if (movie.getTitle()!=null) movieExisten.setTitle(movie.getTitle());
                    if (movie.getImage_url()!=null) movieExisten.setImage_url(movie.getImage_url());
                    if (movie.getYear()!=null) movieExisten.setYear(movie.getYear());
                    if (movie.getScore()!=null) movieExisten.setScore(movie.getScore());
                    return movieRepository.save(movieExisten);
                }else movie.setMovie_id(null);
        }
        return (movie.isGood())? movieRepository.save(movie):null;
    }


    public List<Map<String,String>> listarMovies (){
        List<Map<String,String>> lista = new ArrayList<>();
        for(Movie peliculas : movieRepository.findAll())
            lista.add(Map.of("imagen",peliculas.getImage_url(), "titulo", peliculas.getTitle(),"fecha", peliculas.getYear().toString()));
        return lista;
    }

    public void borrar(Integer id){
        if (!movieRepository.existsById(id))
            throw new IllegalStateException("No se encontro la pelicula");
        movieRepository.deleteById(id);
    }

    public List<Movie> buscarPorNombre(String title){
        return movieRepository.findMoviesByTitle(title);
    }

    public List<Movie> movieOrder(String title){
        return movieRepository.findMoviesByTitleOrderByTitle(title);
    }


    public List<Movie> findMovie(Optional<Integer> genres, Optional<String> title){
        try {
            if (genres.isPresent()){
                Genre genre = genreRepository.findById(genres.get()).orElseThrow(Exception::new);
                if (title.isPresent())
                    return movieRepository.findMoviesByGenresContainsAndTitle(title.get(), genre);
                else
                    return movieRepository.findMoviesByGenresContains(genre);
            }else {
                if (title.isPresent())
                    return movieRepository.findMoviesByTitle(title.get());
            }
        } catch (Exception e) {
           return null;
        }
        return null;
    }











}
