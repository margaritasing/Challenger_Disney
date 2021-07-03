package com.example.challegerdisney.Controller;


import com.example.challegerdisney.Entity.Character;
import com.example.challegerdisney.Repository.MovieRepository;
import com.example.challegerdisney.Service.CharacterService;
import com.example.challegerdisney.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/character")
public class CharacterController {

    private final CharacterService characterService;
    private final MovieService movieService;



    @Autowired
    public CharacterController(CharacterService characterService, MovieService movieService) {
        this.characterService = characterService;
        this.movieService = movieService;

    }

    @GetMapping("/all")
    private List<Character> listarPersonajes(){
        return characterService.listarPersonajes();
    }

    @PostMapping(path="/save",consumes = "application/json")
    public Character save(@RequestBody Character character){
           characterService.save(character);
           return character;
    }

    @PutMapping("/update")
    public Character update(@RequestBody Character personaje){
        characterService.actualizar(personaje);
        return personaje;
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Integer id){
        characterService.borrar(id);
    }

    @GetMapping("/find")
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    private List<Character> buscar(@RequestParam Optional<String> name,
                                   @RequestParam Optional<Integer> age, @RequestParam Optional<Integer> movies){
        return characterService.findCharacters(name, age, movies);
    }

    @GetMapping("/{id}")
    private Character getPersonajeById(@PathVariable Integer id){
        return characterService.getCharacterById(id);
    }


    @GetMapping("/name={nombre}")
    public List<Character> buscarPorNombre(@PathVariable String nombre){
        return characterService.buscarPorNombre(nombre);
    }

    @GetMapping
    private List<Map<String,String>> listarPersonaje(){
        return characterService.listarPersonaje();
    }

    @GetMapping("/age={edad}")
    public  List<Character> buscarPorEdad(@PathVariable Integer edad){
        return characterService.buscarPorEdad(edad);
    }












}
