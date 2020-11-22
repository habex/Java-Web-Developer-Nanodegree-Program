package com.udacity.dogsGraphql.repository;

import com.udacity.dogsGraphql.entity.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {
}
