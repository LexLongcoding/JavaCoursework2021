package com.lex.flow.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lex.flow.models.Answer;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {

}
