package com.matthew.springdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/addjoke", method=RequestMethod.POST)
	public String addJoke(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("joke") String joke, Model viewModel) {
		viewModel.addAttribute("name", name);
		viewModel.addAttribute("email", email);
		viewModel.addAttribute("joke", joke);
		return "result.jsp";
	}
	
	@RequestMapping("/color/{variable}")
	public String favColor(Model viewModel, @PathVariable("variable") String color) {
		viewModel.addAttribute("color", color);
		return "fav.jsp";
	}
	
}
