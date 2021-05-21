package com.lex.exam.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lex.exam.models.User;
import com.lex.exam.repositories.UserRepository;

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
	
	
	public User registerUser (User user) {
		//generate a hash
		String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		// set the hashed password on the user's password field
		user.setPassword(hash);
		//save that new user password to the database
		return this.uRepo.save(user);
		
	}
	public boolean authenticateUser(String email, String password) {
		User user = this.uRepo.findByEmail(email);
	
	if(user == null) {
		return false;
	}
	return BCrypt.checkpw(password, user.getPassword());
	}
	
	public User getByEmail(String email) {
		return this.uRepo.findByEmail(email);
	}

}
