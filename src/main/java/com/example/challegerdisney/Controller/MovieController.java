package com.example.challegerdisney.Controller;


import com.example.challegerdisney.Entity.Character;
import com.example.challegerdisney.Entity.Movie;
import com.example.challegerdisney.Service.MovieService;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {
    public final MovieService movieService;


    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/all")
    public List<Movie> listarPeliculas() {
        return movieService.getMovie();
    }

    @GetMapping
    private List<Map<String,String>> listarPelicula(){
        return movieService.listarMovies();
    }

    @PostMapping("/save")
    public Movie save(@RequestBody Movie movie) {
        movieService.save(movie);
        return movie;
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Integer id) {
        movieService.borrar(id);
    }

    @GetMapping("name={title}")
    public List<Movie> buscarXNombre(@PathVariable String title) {
        return movieService.buscarPorNombre(title);
    }

   @GetMapping("/buscar")
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    private List<Movie> buscar(@RequestParam Optional<Integer> genre, @RequestParam Optional<String> title){
        return movieService.findMovie(genre, title);
    }

    @GetMapping("/orden")
    public List<Movie> buscarPoOrden(@PathVariable String title){
        return movieService.movieOrder(title);
    }
    // TODO: 03/07/2021 Revisar este get...  


}

