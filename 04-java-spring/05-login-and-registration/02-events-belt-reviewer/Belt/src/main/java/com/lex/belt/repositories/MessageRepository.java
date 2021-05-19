package com.lex.belt.repositories;

import org.springframework.data.repository.CrudRepository;

import com.lex.belt.models.Message;

public interface MessageRepository extends CrudRepository<Message, Long> {

}
