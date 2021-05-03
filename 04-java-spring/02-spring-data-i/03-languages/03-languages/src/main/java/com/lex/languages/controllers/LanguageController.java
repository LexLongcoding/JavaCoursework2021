package com.lex.languages.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lex.languages.models.Language;
import com.lex.languages.services.LanguageService;

@Controller
@RequestMapping("/")
public class LanguageController {
	@Autowired
	private LanguageService lService;
	
	@GetMapping("languages")
	public String index(Model viewModel) {
		List<Language> allLanguages = this.lService.getAllLanguages();
		viewModel.addAttribute("languages", allLanguages);
		return "index.jsp";
	}
	@RequestMapping("/new")
	public String New(@ModelAttribute("language") Language language) {
		return "new.jsp";
	}
	@RequestMapping("/{id}")
	public String Show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("language", lService.getSingleLanguage(id));
		return "show.jsp";
	}
	@RequestMapping("/{id}/edit")
	public String Edit(@PathVariable("id") Long id, Model model) {
		Language language  = lService.getSingleLanguage(id);
		if (language != null){
            model.addAttribute("language", language);
            return "edit.jsp";
        }else{
            return "redirect:/languages";
        }
	}
	@PostMapping("/{id}/edit")
	public String updateLanguage(@PathVariable("id") Long id, @Valid @ModelAttribute("language") Language lang,  BindingResult result) {
		 if (result.hasErrors()) {
	            return "edit.jsp";
	        }else{
	            lService.updateLanguage(id, lang);
	            return "redirect:/languages";
	        }
	    }
	
	@RequestMapping(value="/{id}/delete")
    public String deleteLanguage(@PathVariable("id") long id) {
        lService.deleteLanguage(id);
        return "redirect:/languages";
    }
	
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String Create(@Valid @ModelAttribute("language") Language lang, BindingResult result, @RequestParam Map<String,String> body) {
		if(result.hasErrors())
			return "new.jsp";
		lService.createLanguage(lang);
		return "redirect:/languages";
	}
}
	