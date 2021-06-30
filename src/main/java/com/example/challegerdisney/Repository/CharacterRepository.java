package com.example.challegerdisney.Repository;

import com.example.challegerdisney.Entity.Movie;
import com.example.challegerdisney.Entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {



    List<Character> findCharactersByName(String name);

    List<Character>findCharactersByAge(Integer age);






}
