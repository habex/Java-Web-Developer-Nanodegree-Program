package com.udacity.dogs.controller;

import com.udacity.dogs.entity.Dog;
import com.udacity.dogs.service.DogNotFoundException;
import com.udacity.dogs.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dogs")
public class DogController {

    private DogService dogService;

    @Autowired
    public void setDogService(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping
    public ResponseEntity<List<Dog>> getAllDogs(){
        List<Dog> breeds = dogService.retrieveDogs();
        return new ResponseEntity<>(breeds, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dog> getDog(@PathVariable Long id){
        Dog dog = dogService.retrieveDogById(id);
        return new ResponseEntity<>(dog, HttpStatus.OK);
    }

    @GetMapping("/breed")
    public ResponseEntity<List<String>>  getBreeds(){
        List<String> breeds = dogService.retrieveDogBreed();
        return new ResponseEntity<>(breeds, HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<List<String>>  getNames(){
        List<String> names = dogService.retrieveDogNames();
        return new ResponseEntity<>(names, HttpStatus.OK);
    }

    @GetMapping("/{id}/breed")
    public ResponseEntity<String> getBreedsById(@PathVariable Long id){
        String breed = dogService.retrieveDogBreedById(id);
        return new ResponseEntity<>(breed, HttpStatus.OK);
    }


}
