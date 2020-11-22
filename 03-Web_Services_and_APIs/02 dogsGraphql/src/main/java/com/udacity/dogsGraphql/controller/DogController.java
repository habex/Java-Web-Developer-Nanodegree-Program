package com.udacity.dogsGraphql.controller;

import com.udacity.dogsGraphql.entity.Dog;
import com.udacity.dogsGraphql.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dogs")
public class DogController {
    private DogService dogService;

    @Autowired
    public void setDogService(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping
    public ResponseEntity<List<Dog>> getAllDogs() {
        List<Dog> list = dogService.retrieveDogs();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dog> getDogById(@PathVariable Long id) {
        Dog dog = dogService.retrieveDogById(id);
        return new ResponseEntity<>(dog, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public void deleteDogById(@PathVariable Long id) {
        dogService.deleteDogById(id);
    }

}
