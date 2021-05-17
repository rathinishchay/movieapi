package com.springdemo.restapi.repository;

import com.springdemo.restapi.entity.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends CrudRepository <Movie,Long>{
    Optional<Movie>findByMovieName(String name);
    Optional<Movie>findByGenre(String genre);
    //List<Movie> findAllByMovieName(List<Movie> movies);
}


