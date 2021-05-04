package com.lex.dogs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lex.dogs.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long>{

}