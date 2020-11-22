package com.udacity.dogsGraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udacity.dogsGraphql.entity.Dog;
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
        Optional<Dog> dog = dogRepository.findById(id);
        return dog.get();
    }

}
