package com.lex.languages.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lex.languages.models.Language;
import com.lex.languages.services.LanguageService;

@RestController
@RequestMapping("/api")
public class APILanguageController {
	@Autowired
	private LanguageService lService;
	
	@GetMapping("")
	public List<Language> index(){
		return this.lService.getAllLanguages();
		
	}
	
	@GetMapping("/{id}")
	public Language getLanguage(@PathVariable("id") Long id){
		return this.lService.getSingleLanguage(id);
	}
	
	@PostMapping("/create")
	public Language create(Language language) {
		return this.lService.createLanguage(language);
	}
	
	//@RequestMapping ("/value="/delete/{id}", method = RequestMethod.Delete)
	@DeleteMapping (value="/delete/{id}")
	public void deleteLanguage(@PathVariable("id")Long id) {
		this.lService.deleteLanguage(id);
	}
	//@RequestMapping ("/value="/update/{id}", method = RequestMethod.Put)
		//@PutMapping (value="/update/{id}")
		//public Language updateLanguage(@PathVariable("id")Long id, Language updatedLanguage, BindingResult result ) {
			//return this.lService.updateLanguage(updatedLanguage);
			
			
		}
			

//}
	

