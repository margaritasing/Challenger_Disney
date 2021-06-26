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

    public void save(Character personaje) {
        characterRepository.save(personaje);
    }
}
