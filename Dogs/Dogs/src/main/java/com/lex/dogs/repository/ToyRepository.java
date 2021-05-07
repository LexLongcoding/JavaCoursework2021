package com.lex.dogs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lex.dogs.models.Toy;

@Repository
public interface ToyRepository extends CrudRepository<Toy, Long> {

}
