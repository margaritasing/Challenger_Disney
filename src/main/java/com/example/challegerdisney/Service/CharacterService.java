package com.example.challegerdisney.Service;

import com.example.challegerdisney.Repository.MovieRepository;
import com.example.challegerdisney.Entity.Character;
import com.example.challegerdisney.Repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CharacterService {
    private final CharacterRepository characterRepository;
    private final MovieRepository movieRepository;

    @Autowired
    public CharacterService(CharacterRepository characterRepository, MovieRepository movieRepository) {
        this.characterRepository = characterRepository;
        this.movieRepository = movieRepository;
    }

    public List<Character> listarPersonajes() {
        List<Character> personajes = characterRepository.findAll();

        return personajes;
    }

    public Character save(Character personaje) {
        return characterRepository.save(personaje);
    }

    public void borrar(Integer id) {
        characterRepository.deleteById(id);
    }

    public List<Map<String,String>> listarPersonaje() {
        List<Map<String,String>> lista = new ArrayList<>();
        for(Character personaje : characterRepository.findAll())
            lista.add(Map.of("name", personaje.getName(), "image_url", personaje.getImage_url()));
        return lista;
    }

    public List<Character> buscarPorNombre(String name){
       return characterRepository.findCharactersByName(name);
    }

    public List<Character> buscarPorEdad(Integer age){
        return characterRepository.findCharactersByAge(age);
    }

    public Character actualizar(Character character){
        return characterRepository.save(character);
    }

    public Character getCharacterById(Integer id) {
        Character personaje = characterRepository.findById(id).orElse(null);
    /*    if(personaje!=null)
            personaje.setMovies(movieRepository.findMoviesByCharactersEquals(personaje));
             // TODO agregar pelis*/
         return personaje;
    }


}
