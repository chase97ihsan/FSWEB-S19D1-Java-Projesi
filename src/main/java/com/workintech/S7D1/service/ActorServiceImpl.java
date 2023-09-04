package com.workintech.S7D1.service;

import com.workintech.S7D1.dao.ActorRepository;
import com.workintech.S7D1.entity.Actor;
import com.workintech.S7D1.exceptions.MovieExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorServiceImpl implements ActorService{

    private ActorRepository actorRepository;

    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    @Override
    public Actor findById(int id) {
        Optional<Actor> optional=actorRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        throw new MovieExceptions("Actor is not exist: " + id, HttpStatus.BAD_REQUEST);
    }

    @Override
    public Actor save(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public Actor delete(int id) {
        Actor actor=findById(id);
        actorRepository.delete(actor);
        return actor;

    }
}
