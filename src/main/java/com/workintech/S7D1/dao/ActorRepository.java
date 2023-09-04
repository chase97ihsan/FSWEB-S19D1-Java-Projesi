package com.workintech.S7D1.dao;

import com.workintech.S7D1.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor,Integer> {
}
