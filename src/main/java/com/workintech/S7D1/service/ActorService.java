package com.workintech.S7D1.service;

import com.workintech.S7D1.entity.Actor;

import java.util.List;

public interface ActorService {

    List<Actor> findAll();
    Actor findById(int id);
    Actor save(Actor actor);
    Actor delete(int id);


}
