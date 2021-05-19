package com.lex.authentication.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lex.authentication.models.User;
import com.lex.authentication.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired 
	private UserRepository uRepo;
	
	
	//register and hash user password
	public User Registration(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return uRepo.save(user);
	}
	
	//find the user by email
	public User findByEmail(String email) {
		return uRepo.findByEmail(email);
	}
	
	//find user by id
	public User findUserByID(Long id) {
		Optional<User> user = uRepo.findById(id);
		
		if (user.isPresent()) {
			return user.get();
		}else {
			return null;
		}
	}
	
	//authenticate user
	public boolean authenicateUser(String email, String password){
		//first find the user by email 
		User user = this.uRepo.findByEmail(email);
		
		if(user == null) {
			return false;
		}
		return BCrypt.checkpw(password, user.getPassword());
	}	
		
}
	


