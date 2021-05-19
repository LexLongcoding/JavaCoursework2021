package com.lex.dogs.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lex.dogs.models.Dog;
import com.lex.dogs.models.Tag;
import com.lex.dogs.models.User;
import com.lex.dogs.services.DogService;
import com.lex.dogs.services.TagService;
import com.lex.dogs.services.UserService;
import com.lex.dogs.validators.UserValidator;

@Controller
public class DogController {
	@Autowired
	private DogService dService;
	@Autowired
	private TagService tService;
	@Autowired
	private UserService uService;
	@Autowired
	private UserValidator validator;
	
	
	@GetMapping("/")
	public String baseRoute(Model viewModel, @ModelAttribute("user")User user) {
		return "landing.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user")User user, BindingResult result, HttpSession session) {
		validator.validate(user, result);
		if(result.hasErrors()) {
			return "landing.jsp";
		}
		
		User newUser = this.uService.registerUser(user);
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/dogs";
		
	}
	
	
	@GetMapping("/dogs")
	public String index(Model viewModel, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		//System.out.println((Long)session.getAttribute("user_id"));
		if(userId == null) {
			return"redirect:/";
		}
		
		
		System.out.println(userId);
		User user = this.uService.find(userId);
		List<Dog> allDogs = this.dService.getAllDogs();
		viewModel.addAttribute("dogs", allDogs);
		viewModel.addAttribute("user", user);
		return "index.jsp";
	}
	
	
	
	@PostMapping("/login")
	public String login(@RequestParam("loginEmail") String email, @RequestParam("loginPass") String password, RedirectAttributes redirectAttr, HttpSession session) {
		if(!this.uService.authenticateUser(email, password)) {
			redirectAttr.addFlashAttribute("loginerror","Invalid Credentials");
			return "redirect:/";
		}
		User user = this.uService.getByEmail(email);
		//System.out.println(user.getId());
		session.setAttribute("user_id", user.getId());
		//System.out.println((Long)session.getAttribute("user_id"));

		return "redirect:/dogs";
		
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/add")
	public String addPet(@ModelAttribute("dog") Dog dog) {
		return "new.jsp";
	}
	
	@PostMapping("/add")
	public String newPet(@Valid @ModelAttribute("dog") Dog dog, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "new.jsp";
		}
		Long userId = (Long)session.getAttribute("user_id");
		User userThatAddedDog = this.uService.find(userId); 
		dog.setOwner(userThatAddedDog);
		this.dService.createDog(dog);
		return "redirect:/dogs";
	}
	
	@GetMapping("/delete/{id}")
	public String deletePet(@PathVariable("id") Long id) {
		this.dService.deleteDog(id);
		return "redirect:/dogs";
	}
	
	@GetMapping("/profile/{id}")
	public String profile(@PathVariable("id")Long id, Model viewModel) {
		viewModel.addAttribute("user", this.uService.find(id));
		return "profile.jsp";
		
	}
	
	@GetMapping("/{id}")
	public String showDog(@PathVariable("id") Long id, Model viewModel, @ModelAttribute("tag") Tag tag, HttpSession session) {
		Dog dogToShowcase = this.dService.getSingleDog(id);
		viewModel.addAttribute("dog", dogToShowcase);
		viewModel.addAttribute("userId", session.getAttribute("user_id"));
		return "show.jsp";
	}
	
	@GetMapping("/edit/{id}")
	public String editDog(@PathVariable("id") Long id, @ModelAttribute("dog") Dog dog, Model viewModel, HttpSession session, RedirectAttributes redirectAttr) {
		Long userId = (long)session.getAttribute("user_id");
		Dog dogToEdit = this.dService.getSingleDog(id);
		if((long)dogToEdit.getOwner().getId() !=(long) userId) {
			redirectAttr.addFlashAttribute("ErrorMsg", "only dog owner may edit");
			return "redirect:/{id}";
		}
		viewModel.addAttribute("dog", dogToEdit);
		return "edit.jsp";
	}
	@PostMapping("/addTag/{id}")
	public String addTag(@Valid @ModelAttribute("tag") Tag tag, BindingResult result, @PathVariable("id") Long id) {
		Dog dogToAdd = this.dService.getSingleDog(id);
		tag.setDog(dogToAdd);
		this.tService.createTag(tag);
		return "redirect:/{id}";
	}
	
	@PostMapping("/edit/{id}")
	public String processEdit(@Valid @ModelAttribute("dog") Dog dog, BindingResult result, Model viewModel, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			viewModel.addAttribute("dog", this.dService.getSingleDog(id));
			return "edit.jsp";
		}
		
		this.dService.updateDog(dog);
		return "redirect:/{id}";
	}
	
	
	@GetMapping("/like/{id}")
	public String like(@PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		Long petId = id;
		User liker = this.uService.find(userId);
		Dog likedDog = this.dService.getSingleDog(petId);
		this.dService.addLiker(liker, likedDog);
		return "redirect:/dogs";
	}
	
	@GetMapping("/unlike/{id}")
	public String unlike(@PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		Long petId = id;
		User liker = this.uService.find(userId);
		Dog likedDog = this.dService.getSingleDog(petId);
		this.dService.removeLiker(liker, likedDog);
		return "redirect:/dogs";
	}
	
	@PostMapping("/addHTMLWay")
	public String newPetHTML(@RequestParam("name") String name, @RequestParam("breed") String breed, @RequestParam("age") int age, RedirectAttributes redirectAttr) {
		ArrayList<String> errors = new ArrayList<String>();
		if(name.equals("")) {
			errors.add("Hey you forgot to add a name");
		}
		if(errors.size() > 0) {
			for(String e : errors) {
				redirectAttr.addFlashAttribute("errors", e);
			}
			return "redirect:/add";
		}
		this.dService.createDogHTML(name, breed, age);
		return "redirect:/";
	}
}