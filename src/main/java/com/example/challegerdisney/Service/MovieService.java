package com.example.challegerdisney.Service;

import com.example.challegerdisney.Entity.Movie;
import com.example.challegerdisney.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MovieService {
    public final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovie(){
        return movieRepository.findAll();
    }

    public Movie guardar(Movie movie){
        return movieRepository.save(movie);
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








}
