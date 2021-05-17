package com.springdemo.restapi.service;


import com.springdemo.restapi.NotFoundException;
import com.springdemo.restapi.model.MovieRequest;
import com.springdemo.restapi.entity.Movie;
import com.springdemo.restapi.model.MovieResponse;

public interface MovieService {
    void create(MovieRequest movieRequest);
    MovieResponse get(String name) throws NotFoundException;
    void update(String name,MovieRequest movieRequest) throws NotFoundException;
    void delete(String name) throws NotFoundException;
}
