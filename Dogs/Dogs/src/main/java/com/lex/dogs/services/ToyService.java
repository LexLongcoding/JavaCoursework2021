package com.lex.dogs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lex.dogs.models.Toy;
import com.lex.dogs.repository.ToyRepository;

@Service
public class ToyService {
	@Autowired
	private ToyRepository tRepo;
	
	//create
	public Toy create(Toy toy) {
		return this.tRepo.save(toy);
	}

}
