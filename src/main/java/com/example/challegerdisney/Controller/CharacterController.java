package com.example.challegerdisney.Controller;


import com.example.challegerdisney.Entity.Character;
import com.example.challegerdisney.Service.CharacterService;
import com.example.challegerdisney.Service.MovieService;
import com.example.challegerdisney.Service.UserService;
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
    private final UserService userService;



    @Autowired
    public CharacterController(CharacterService characterService, MovieService movieService, UserService userService) {
        this.characterService = characterService;
        this.movieService = movieService;
        this.userService = userService;
    }

    private boolean validarYregistrarApiCall(Optional<String> email, Optional<String> tokenTemporal){
        if (tokenTemporal.isPresent() && email.isPresent())
            return userService.validateTemporalTokenAndCountApiCall(email.get(), tokenTemporal.get());
        return true;
    }

    @GetMapping("/all")
    private List<Character> listarPersonajes(@RequestParam Optional<String> email, @RequestParam Optional<String> tokenTemporal){
        return (validarYregistrarApiCall(email, tokenTemporal))?characterService.listarPersonajes():null;
    }


    @GetMapping("/find")
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    private List<Character> buscar(@RequestParam Optional<String> name,
                                   @RequestParam Optional<Integer> age, @RequestParam Optional<Integer> movies,
                                   @RequestParam Optional<String> email, @RequestParam Optional<String> tokenTemporal){
        return (validarYregistrarApiCall(email, tokenTemporal))? characterService.findCharacters(name, age, movies):null;
    }

    @GetMapping("/{id}")
    private Character getPersonajeById(@PathVariable Integer id,@RequestParam Optional<String> email, @RequestParam Optional<String> tokenTemporal ){
        return (validarYregistrarApiCall(email, tokenTemporal))?  characterService.getCharacterById(id):null;
    }


    @GetMapping("/name={nombre}")
    public List<Character> buscarPorNombre(@PathVariable String nombre, @RequestParam Optional<String> email, @RequestParam Optional<String> tokenTemporal){
        return (validarYregistrarApiCall(email, tokenTemporal))?  characterService.buscarPorNombre(nombre):null;
    }

    @GetMapping
    private List<Map<String,String>> listarPersonaje(@RequestParam Optional<String> email, @RequestParam Optional<String> tokenTemporal){
        return (validarYregistrarApiCall(email, tokenTemporal))? characterService.listarPersonaje():null;
    }

    @GetMapping("/age={edad}")
    public  List<Character> buscarPorEdad(@PathVariable Integer edad, @RequestParam Optional<String> email, @RequestParam Optional<String> tokenTemporal){
        return (validarYregistrarApiCall(email, tokenTemporal))?characterService.buscarPorEdad(edad):null;
    }

    @PutMapping("/update")
    public Character update(@RequestBody Character personaje){
        characterService.actualizar(personaje);
        return personaje;
    }

    @PostMapping(path="/save",consumes = "application/json")
    public Character save(@RequestBody Character character){
        characterService.save(character);
        return character;
    }


    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Integer id){
        characterService.borrar(id);
    }












}
