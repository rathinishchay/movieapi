/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springdemo.restapi.controller;


import com.springdemo.restapi.NotFoundException;
import com.springdemo.restapi.model.MovieRequest;
import com.springdemo.restapi.model.MovieResponse;
import com.springdemo.restapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author nishc
 */
@RestController
public class Resources {
    @Autowired
    MovieService movieService;
    @PostMapping("/v1/movie")
    void createMovie(@RequestBody MovieRequest movieRequest) {//use jackson(objectmapper)convert json to pojo(MovieRequest object)

        movieService.create(movieRequest);

    }
    @GetMapping("/v1/movie")
    MovieResponse getMovie(@RequestParam("name") String name) {

        try {
            return movieService.get(name);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping("/v1/movie/{name}")
    void updateMovie(@PathVariable("name") String name ,
                     @RequestBody MovieRequest movieRequest) {
        try {
            movieService.update(name,movieRequest);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }
    @DeleteMapping("/v1/movie/{name}")
    void deleteMovie(@PathVariable("name") String name) {
        try {
            movieService.delete(name);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }
}
