package com.lex.exam.controllers;

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

import com.lex.exam.models.Idea;
import com.lex.exam.models.User;
import com.lex.exam.services.IdeaService;
import com.lex.exam.services.UserService;
import com.lex.exam.validators.UserValidator;

@Controller
public class HomeController {
	@Autowired
	private UserService uService;
	@Autowired
	private UserValidator validator;
	@Autowired
	private IdeaService iService;
	
	
	
	@GetMapping("/")
	public String baseRoute(Model viewModel, @ModelAttribute("user")User user) {
		return "index.jsp";
	}
	
	@GetMapping("/new")
	private String newIdeaPage(@ModelAttribute("idea") Idea idea, Model viewModel, HttpSession session) {
		Long userId =(Long)session.getAttribute("user_id");
		viewModel.addAttribute("user", this.uService.find(userId));
		viewModel.addAttribute("ideas", this.iService.getIdeas());
		return "new.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user")User user, BindingResult result, HttpSession session) {
		validator.validate(user, result);
		if(result.hasErrors()) {
			return "index.jsp";
		}
		
		User newUser = this.uService.registerUser(user);
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/dashboard";
		
	}
	
	
	@GetMapping("/ideas")
	public String index(Model viewModel, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		//System.out.println((Long)session.getAttribute("user_id"));
		if(userId == null) {
			return"redirect:/";
		}
		
		
		System.out.println(userId);
		User user = this.uService.find(userId);
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

		return "redirect:/dashboard";
		
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	@GetMapping("/dashboard")
	private String dashboard(@ModelAttribute("idea") Idea idea, Model viewModel, HttpSession session) {
		Long userId =(Long)session.getAttribute("user_id");
		viewModel.addAttribute("user", this.uService.find(userId));
		viewModel.addAttribute("ideas", this.iService.getIdeas());
		return "dashboard.jsp";
	}
	@PostMapping("/addIdea")
	public String addThought(@Valid @ModelAttribute("idea") Idea idea, BindingResult result, HttpSession session, Model viewModel) {
		if(result.hasErrors()) {
			Long userId =(Long)session.getAttribute("user_id");
			viewModel.addAttribute("user", this.uService.find(userId));
			return "new.jsp";
			
		}
		this.iService.create(idea);
		return "redirect:/dashboard";
		
	}
	@GetMapping("/like/{id}")
	public String like(HttpSession session, @PathVariable("id") Long id) {
		Long userId =(Long)session.getAttribute("user_id");
		User userToLike = this.uService.find(userId);
		Idea likedIdea = this.iService.getById(id);
		this.iService.likeIdea(likedIdea, userToLike);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/unlike/{id}")
	public String unlike(HttpSession session, @PathVariable("id") Long id) {
		Long userId =(Long)session.getAttribute("user_id");
		User userToLike = this.uService.find(userId);
		Idea likedIdea = this.iService.getById(id);
		this.iService.unlikeIdea(likedIdea, userToLike);
		return "redirect:/dashboard";
	}
	@GetMapping("/{id}/edit")
	public String Edit(@PathVariable("id") Long id, HttpSession session, Model model) {
		Long userId = this.userSession(session);
		Idea idea = this.iService.getById(id);
		if(userId == null)
			return "redirect:/";
		if(idea == null || !idea.getCreator().getId().equals(userId))
			return "redirect:/dashboard";
		
		model.addAttribute("idea", idea);
		model.addAttribute("userId", userId);
		return "/ideas/edit.jsp";
	}
	@PostMapping("/{id}")
	public String Update(@Valid @ModelAttribute("Idea") Idea idea, BindingResult result, @PathVariable("id") Long id, HttpSession session, Model model) {
		if(result.hasErrors()) {
			Long userId = this.userSession(session);
			model.addAttribute("idea", idea);
			model.addAttribute("userId", userId);
			return "/events/edit.jsp";
		}
		this.iService.update(idea);
		return "redirect:/ideas";
	}
	
	public Long userSession(HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return null;
		}
		return (Long)session.getAttribute("userId");
	}
	@GetMapping("/delete/{id}")
	public String deleteIdea(@PathVariable("id") Long id) {
		this.iService.delete(id);
		return "redirect:/dashboard";
	}
	@GetMapping("ideas/{id}/edit")
	public String editIdea(@PathVariable("id") Long id, @ModelAttribute("idea") Idea idea, Model viewModel, HttpSession session, RedirectAttributes redirectAttr) {
		Long userId = (long)session.getAttribute("user_id");
		Idea ideaToEdit = this.iService.getById(id);
		if((long)ideaToEdit.getCreator().getId() !=(long) userId) {
			redirectAttr.addFlashAttribute("ErrorMsg", "only creator may edit");
			return "redirect:/{id}";
		}
		viewModel.addAttribute("idea", ideaToEdit);
		return "edit.jsp";
	}
	
	@PostMapping("/edit/{id}")
	public String processEdit(@Valid @ModelAttribute("idea") Idea idea, BindingResult result, Model viewModel, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			viewModel.addAttribute("idea", this.iService.getById(id));
			return "edit.jsp";
		}
		
		this.iService.updateIdea(idea);
		return "redirect:/{id}";
	}
	@GetMapping("/{id}")
	public String showIdea(@PathVariable("id") Long id, Model viewModel,  HttpSession session) {
		Idea ideaToShow = this.iService.getById(id);
		viewModel.addAttribute("idea", ideaToShow);
		viewModel.addAttribute("userId", session.getAttribute("user_id"));
		return "show.jsp";
	}
	
	
}
	
	
	




