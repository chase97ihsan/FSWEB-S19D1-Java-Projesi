package com.workintech.S7D1.service;

import com.workintech.S7D1.dao.MovieRepository;
import com.workintech.S7D1.entity.Actor;
import com.workintech.S7D1.entity.Movie;
import com.workintech.S7D1.exceptions.MovieExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MovieServiceImpl implements MovieService {
    private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie findById(int id) {
        Optional<Movie> optional = movieRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new MovieExceptions("Movie is not exist: " + id, HttpStatus.BAD_REQUEST);
    }

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie delete(int id) {
        Movie movie = findById(id);
        movieRepository.delete(movie);
        return movie;
    }
}
