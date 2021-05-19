package com.lex.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lex.authentication.models.User;
import com.lex.authentication.services.UserService;
import com.lex.authentication.validator.UserValidator;

@Controller
public class HomeController {
	@Autowired
	private UserValidator validator;
	
	@Autowired
	private  UserService uRepo;
	
	@GetMapping("/registration")
	public String registerForm(@ModelAttribute("user") User user) {
		return "registrationPage.jsp";
	}
	
	@GetMapping("/login")
	public String login() {
		return "loginPage.jsp";
			}
	@PostMapping("/registration")
	public String registrationUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		validator.validate(user, result);
		if(result.hasErrors()) {
			return "registrationPage.jsp";
		}
		User u = uRepo.Registration(user);
		session.setAttribute("user", u.getId());
		return "redirect:/home";	
	}
	
	@PostMapping("/login")
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model viewModel, HttpSession session){
		boolean isAuthenicated = uRepo.authenicateUser(email, password);
		if(isAuthenicated) {
			User u = uRepo.findByEmail(email);
			session.setAttribute("user", u);
			return "homePage.jsp";
		}else {
			viewModel.addAttribute("error", "Invalid Credentials. Please try again");
			return "loginPage.jsp";
		}
	}
	
	@GetMapping("/home")
	public String home(HttpSession session, Model viewModel) {
		Long userId = (Long) session.getAttribute("user");
		User u = uRepo.findUserByID(userId);
		viewModel.addAttribute("user", u);
		return "homePage.jsp";
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
	
}