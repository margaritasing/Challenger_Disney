package com.example.challegerdisney.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "characters")
public class Character {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer character_id;
    @Column(nullable = false)
    private String name;
    private String image_url;
    private Integer age;
    private Integer weight;
    private String story;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "characters_movies",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<Movie> movies;

    public Character() {
    }



    public boolean isGood(){
        return (name!=null && age!=null && image_url!=null && story!=null && weight!=null);
    }

    public Integer getCharacter_id() {
        return character_id;
    }

    public void setCharacter_id(Integer character_id) {
        this.character_id = character_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Character{" +
                "character_id=" + character_id +
                ", name='" + name + '\'' +
                ", image_url='" + image_url + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", story='" + story + '\'' +
                '}';
    }
}
