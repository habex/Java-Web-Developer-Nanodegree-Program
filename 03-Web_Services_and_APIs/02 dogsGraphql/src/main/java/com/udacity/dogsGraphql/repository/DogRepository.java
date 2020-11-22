package com.udacity.dogsGraphql.repository;

import com.udacity.dogsGraphql.entity.Dog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends CrudRepository<Dog, Long> {

}
