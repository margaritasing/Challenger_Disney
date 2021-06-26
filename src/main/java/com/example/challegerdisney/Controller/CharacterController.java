package com.example.challegerdisney.Controller;


import com.example.challegerdisney.Entity.Character;
import com.example.challegerdisney.Service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/character")
public class CharacterController {

    private final CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    private List<Character> listarPersonajes(){
        return characterService.listarPersonajes();
    }

    @PostMapping(path="/save",consumes = "application/json")
    private void save(@RequestBody Character personaje){
        characterService.save(personaje);
    }





}
