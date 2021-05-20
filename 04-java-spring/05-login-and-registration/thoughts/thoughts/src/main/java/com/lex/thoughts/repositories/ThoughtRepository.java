package com.lex.thoughts.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lex.thoughts.models.Thought;

@Repository
public interface ThoughtRepository extends CrudRepository<Thought, Long>{
	List<Thought> findAll();

}
