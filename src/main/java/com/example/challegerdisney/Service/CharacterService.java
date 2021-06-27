package com.example.challegerdisney.Service;

import com.example.challegerdisney.Entity.Character;
import com.example.challegerdisney.Repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {
    private final CharacterRepository characterRepository;

    @Autowired
    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
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

    public List<Character> buscarPorNombre(String name){
       return characterRepository.findCharactersByName(name);
    }

    public List<Character> buscarPorEdad(Integer age){
        return characterRepository.findCharactersByAge(age);
    }

    public List<Character> buscarPorIdMovie(Integer id){
        return characterRepository.findCharactersByMovies(id);
    }


}
