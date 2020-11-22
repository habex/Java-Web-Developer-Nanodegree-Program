package com.udacity.dogs.service;

import com.udacity.dogs.entity.Dog;
import com.udacity.dogs.repository.DogRepository;
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
        Optional<Dog> optionalDog = Optional.ofNullable(dogRepository.findById(id).get());
        Dog dog = optionalDog.orElseThrow(DogNotFoundException::new);
        return dog;
    }

    public List<String> retrieveDogBreed() {
        return dogRepository.findAllBreed();
    }

    public List<String> retrieveDogNames() {
        return dogRepository.findAllName();
    }

    public String retrieveDogBreedById(Long id) {
        Optional<Optional<Dog>> optionalDog = Optional.ofNullable(dogRepository.findById(id));

        Optional<Dog> dog = optionalDog.orElseThrow(DogNotFoundException::new);

        if(!dog.isPresent()){
            throw new DogNotFoundException();
        }
        return dog.get().getBreed();
    }



}
