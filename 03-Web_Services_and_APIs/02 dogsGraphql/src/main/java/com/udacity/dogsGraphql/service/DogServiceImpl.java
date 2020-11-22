package com.udacity.dogsGraphql.service;


import com.udacity.dogsGraphql.entity.Dog;
import com.udacity.dogsGraphql.resolver.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogServiceImpl implements DogService {

    @Autowired
    Query dogQuery;


    public List<Dog> retrieveDogs() {
        return (List<Dog>) dogQuery.findAllDogs();
    }

    @Override
    public Dog retrieveDogById(Long id) {
        Dog dog= dogQuery.findDogById(id);
        return dog;
    }

    @Override
    public Boolean deleteDogById(Long id) {
        return dogQuery.deleteDogById(id);
    }


}
