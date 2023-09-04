package com.workintech.S7D1.util;

import com.workintech.S7D1.entity.Actor;
import com.workintech.S7D1.entity.Movie;
import com.workintech.S7D1.mapping.ActorResponse;
import com.workintech.S7D1.mapping.MovieActorResponse;
import com.workintech.S7D1.mapping.MovieResponse;

import java.util.ArrayList;
import java.util.List;

public class HollywoodUtility {


    public static MovieActorResponse convertMovieActorResponse(Movie movie, Actor actor) {
        return new MovieActorResponse(movie, actor.getId(), actor.getFirstName(),
                actor.getLastName(), actor.getBirthDate());
    }
    public static List<ActorResponse> convertActorResponses(Movie savedMovie) {
        List<ActorResponse> actorResponses = new ArrayList<>();
        for (Actor a : savedMovie.getActors()) {
            actorResponses.add(new ActorResponse(a.getId(), a.getFirstName(),
                    a.getLastName(), a.getGender(), a.getBirthDate()));
        }
        return actorResponses;
    }
}
