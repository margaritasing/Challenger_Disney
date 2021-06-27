package com.example.challegerdisney.Controller;


import com.example.challegerdisney.Entity.Character;
import com.example.challegerdisney.Service.CharacterService;
import com.example.challegerdisney.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/character")
public class CharacterController {

    private final CharacterService characterService;
    private final MovieService movieService;

    @Autowired
    public CharacterController(CharacterService characterService, MovieService movieService) {
        this.characterService = characterService;
        this.movieService = movieService;
    }

    @GetMapping
    private List<Character> listarPersonajes(){
        return characterService.listarPersonajes();
    }

    @PostMapping("/save")
    public Character save(@RequestBody Character personaje){
           characterService.save(personaje);
           return personaje;
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Integer id){
        characterService.borrar(id);
    }

    @GetMapping("name={nombre}")
    public List<Character> buscarPorNombre(@PathVariable String nombre){
        return characterService.buscarPorNombre(nombre);
    }

    @GetMapping("age={edad}")
    public  List<Character> buscarPorEdad(@PathVariable Integer edad){
        return characterService.buscarPorEdad(edad);
    }

    @GetMapping("movies={idMovie}")
    public List<Character> buscarPorIdMovie(@PathVariable Integer idMovie){
        return characterService.buscarPorIdMovie(idMovie);
    }









}
