package com.workintech.S7D1.dao;

import com.workintech.S7D1.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Integer> {
}
