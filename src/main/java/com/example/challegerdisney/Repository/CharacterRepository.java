package com.example.challegerdisney.Repository;

import com.example.challegerdisney.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.challegerdisney.Entity.Character;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {

    List<Character> findCharactersByNameContaining(String name);

    List<Character> findCharactersByNameContainingAndAgeEqualsAndMoviesContaining(String name, Integer age, Movie movie);


    List<Character> findCharactersByNameContainingAndAgeEquals(String name, Integer age);

    List<Character> findCharactersByAgeEquals(Integer age);

    List<Character> findCharactersByNameContainingAndMoviesContaining(String name, Movie movie);

    List<Character> findCharactersByAgeEqualsAndMoviesContaining(Integer age, Movie movie);

    List<Character> findCharactersByMoviesContaining(Movie movie);

    List<Character> findCharactersByName(String name);

    List<Character> findCharactersByAge(Integer age);
}
