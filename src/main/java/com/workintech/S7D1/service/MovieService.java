package com.workintech.S7D1.service;

import com.workintech.S7D1.entity.Actor;
import com.workintech.S7D1.entity.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> findAll();
    Movie findById(int id);
    Movie save(Movie movie);
    Movie delete(int id);
}
