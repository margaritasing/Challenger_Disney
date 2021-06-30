package com.example.challegerdisney.Repository;
import com.example.challegerdisney.Entity.Character;
import com.example.challegerdisney.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    List<Movie> findMoviesByTitle(String title);

    List<Movie> findMoviesByCharactersEquals(Character personaje);



}
