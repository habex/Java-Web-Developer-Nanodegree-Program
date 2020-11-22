package com.udacity.dogsGraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udacity.dogsGraphql.entity.Dog;
import com.udacity.dogsGraphql.exception.DogNotFoundException;
import com.udacity.dogsGraphql.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {

    private DogRepository dogRepository;

    public Query(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Iterable<Dog> findAllDogs(){
        return dogRepository.findAll();
    }

    public Dog findDogById(Long id){
        Optional<Dog> optionalDog = dogRepository.findById(id);

        if(optionalDog.isPresent()) {
            Dog dog = optionalDog.get();
            return dog;
        } else {
            throw new DogNotFoundException("Dog Not Found", id);
        }
    }

    public Boolean deleteDogById(Long id){
        Optional<Dog> optionalDog = dogRepository.findById(id);

        if(optionalDog.isPresent()) {
            dogRepository.delete(optionalDog.get());
            return true;
        } else {
            throw new DogNotFoundException("Dog Not Found", id);
        }
    }

}
