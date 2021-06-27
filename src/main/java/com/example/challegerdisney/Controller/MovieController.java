package com.example.challegerdisney.Controller;


import com.example.challegerdisney.Entity.Movie;
import com.example.challegerdisney.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    public final MovieService movieService;


    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    private List<Movie> listarPeliculas() {
        return movieService.getMovie();
    }

    @PostMapping("/save")
    public Movie save(@RequestBody Movie pelicula) {
        movieService.guardar(pelicula);
        return pelicula;
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Integer id) {
        movieService.borrar(id);
    }

    @GetMapping("name={title}")
    public List<Movie> buscarXNombre(@PathVariable String title) {
        return movieService.buscarPorNombre(title);
    }


}

