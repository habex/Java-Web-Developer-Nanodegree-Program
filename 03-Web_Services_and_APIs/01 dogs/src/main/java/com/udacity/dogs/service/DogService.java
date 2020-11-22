package com.udacity.dogs.service;

import com.udacity.dogs.entity.Dog;

import java.util.List;
import java.util.Optional;

public interface DogService {

    List<Dog> retrieveDogs();

    List<String> retrieveDogBreed();

    List<String> retrieveDogNames();

    String retrieveDogBreedById(Long id);

    Dog retrieveDogById(Long id);
}