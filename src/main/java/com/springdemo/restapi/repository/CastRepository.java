package com.springdemo.restapi.repository;

import com.springdemo.restapi.entity.Cast;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.OptionalLong;

public interface CastRepository extends CrudRepository<Cast,Long> {
    Optional<Cast> findByName(String name);
}
