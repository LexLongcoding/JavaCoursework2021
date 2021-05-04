package com.lex.dogs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lex.dogs.models.Tag;
import com.lex.dogs.repository.TagRepository;

@Service
public class TagService {
	@Autowired
	private TagRepository tRepo;
	
	//Create Method
	public Tag createTag(Tag tag) {
		return this.tRepo.save(tag);
	}

}
