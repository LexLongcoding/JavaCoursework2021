package com.lex.flow.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lex.flow.models.Answer;
import com.lex.flow.repositories.AnswerRepository;


@Service
public class AnswerService {
	@Autowired
	private AnswerRepository aRepo;
	
	public Answer createAnswer(Answer answer) {
		return this.aRepo.save(answer);
	}
	
}