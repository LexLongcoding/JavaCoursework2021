package com.lex.flow.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lex.flow.models.Question;
import com.lex.flow.models.Tag;
import com.lex.flow.services.AnswerService;
import com.lex.flow.services.QuestionService;
import com.lex.flow.services.TagService;

@Controller
public class HomeController {
	@Autowired
	private AnswerService aService;
	@Autowired
	private QuestionService qService;
	@Autowired
	private TagService tService;
	
	@GetMapping("/")
	public String Index(Model viewModel) {
		List<Question> allQuestions = this.qService.getAllQuestions();
		List<Tag> allTags = this.tService.getAllTags();
		viewModel.addAttribute("questions", allQuestions);
		viewModel.addAttribute("tags", allTags);
		return "index.jsp";
	}

	
	
	

}
