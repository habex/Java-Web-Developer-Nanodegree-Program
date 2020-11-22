package com.udacity.dogsGraphql.service;

import com.udacity.dogsGraphql.entity.Dog;
import com.udacity.dogsGraphql.repository.DogRepository;
import com.udacity.dogsGraphql.resolver.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogServiceImpl implements DogService {

    @Autowired
    DogRepository dogRepository;

    public List<Dog> retrieveDogs() {
        return (List<Dog>) dogRepository.findAll();
    }

    @Override
    public Dog retrieveDogById(Long id) {
       Optional<Dog> dog=dogRepository.findById(id);
       return dog.get();
    }
}
