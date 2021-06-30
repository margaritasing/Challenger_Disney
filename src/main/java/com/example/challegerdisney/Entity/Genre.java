package com.example.challegerdisney.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="genres")
public class Genre {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer genre_id;
    private String name;
    private String image;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "genres_movies",
            joinColumns = @JoinColumn(name = "genre_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<Movie> movies;


    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public Genre() {
    }

    public Integer getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(Integer genre_id) {
        this.genre_id = genre_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genre_id=" + genre_id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
               '}';
    }
}
