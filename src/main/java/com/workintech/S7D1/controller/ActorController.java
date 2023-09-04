package com.workintech.S7D1.controller;

import com.workintech.S7D1.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ActorController {

    private ActorService actorService;
   @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }
}
