package com.workintech.S7D1.controller;

import com.workintech.S7D1.entity.Actor;
import com.workintech.S7D1.entity.Movie;
import com.workintech.S7D1.mapping.ActorResponse;
import com.workintech.S7D1.mapping.MovieActorRequest;
import com.workintech.S7D1.mapping.MovieActorResponse;
import com.workintech.S7D1.mapping.MovieResponse;
import com.workintech.S7D1.service.MovieService;
import com.workintech.S7D1.util.HollywoodUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.workintech.S7D1.util.HollywoodUtility.convertActorResponses;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public List<MovieResponse> findAll() {
        List<MovieResponse> movieResponses = new ArrayList<>();
        List<Movie> movies = movieService.findAll();
        for (Movie m : movies) {
            movieResponses.add(new MovieResponse(m.getId(), m.getName(), m.getDirectorName(),
                    m.getRating(), m.getReleaseDate()));
        }
        return movieResponses;
    }

    @GetMapping("/{id}")
    public MovieResponse findById(@PathVariable int id) {
        Movie m = movieService.findById(id);
        return new MovieResponse(m.getId(), m.getName(), m.getDirectorName(),
                m.getRating(), m.getReleaseDate());
    }

    @PostMapping("/")
    public MovieActorResponse post(@RequestBody MovieActorRequest movieActorRequest) {
        Movie movie = movieActorRequest.getMovie();
        Actor actor = movieActorRequest.getActor();
        movie.addActor(actor);
        Movie movie2 = movieService.save(movie);
        return HollywoodUtility.convertMovieActorResponse(movie2, actor);
    }

    @PostMapping("/{movieId}")
    public List<ActorResponse> addActor(@RequestBody List<Actor> actors, @PathVariable int movieId) {

        Movie movie = movieService.findById(movieId);
        movie.addAllActor(actors);
        Movie savedMovie = movieService.save(movie);
        return HollywoodUtility.convertActorResponses(savedMovie);
    }

    @PutMapping("/{id}")
    public MovieResponse put(@RequestBody Movie movie, @PathVariable int id) {
        Movie movie1 = movieService.findById(id);
        movie.setId(id);
        movie.setActors(movie1.getActors());
        movieService.save(movie);
        return new MovieResponse(movie.getId(), movie.getName(), movie.getDirectorName(),
                movie.getRating(), movie.getReleaseDate());
    }

    @DeleteMapping("{id}")
    public MovieResponse delete(@PathVariable int id) {
        Movie movie = movieService.delete(id);
        return new MovieResponse(movie.getId(), movie.getName(), movie.getDirectorName(),
                movie.getRating(), movie.getReleaseDate());
    }


}
