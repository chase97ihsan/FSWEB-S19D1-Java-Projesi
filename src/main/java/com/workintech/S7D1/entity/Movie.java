package com.workintech.S7D1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movie", schema = "spring")
@Entity
public class Movie {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "director_name")
    private String directorName;
    @Column(name = "rating")
    private int rating;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "movie_actor", schema = "spring", joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private List<Actor> actors;

    public void addActor(Actor actor) {
        if (actors == null) {
            actors = new ArrayList<>();
            actors.add(actor);
        }

    }

    public void addAllActor(List<Actor> actors1) {
        if (actors == null) {
            actors = new ArrayList<>();
        }
        actors.addAll(actors1);

    }
}
