package com.lex.dogs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lex.dogs.models.User;
import com.lex.dogs.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository uRepo;
	
	public User find(Long id) {
		User user = this.uRepo.findById(id).orElse(null);
		return user;
	}
	public List<User> allUsers(){
		return this.uRepo.findAll();
	}

}
