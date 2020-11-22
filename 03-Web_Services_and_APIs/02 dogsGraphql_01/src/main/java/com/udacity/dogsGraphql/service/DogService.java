package com.udacity.dogsGraphql.service;

import com.udacity.dogsGraphql.entity.Dog;

import java.util.List;

public interface DogService {
    List<Dog> retrieveDogs();

    Dog retrieveDogById(Long id);
}
