package com.lex.languages.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lex.languages.models.Language;
import com.lex.languages.repository.LanguageRepository;

@Service
public class LanguageService{
	// dependency inject our repository so this service has access to all methods in the repository interface
	private LanguageRepository lRepo;
	
	public LanguageService(LanguageRepository lrepo) {
		this.lRepo = lrepo;
	}
	// get all languages
	public List<Language> getAllLanguages(){
		return this.lRepo.findAll();
	}
	// get one language
	public Language getSingleLanguage(Long id) {
		return this.lRepo.findById(id).orElse(null);
	}
	// Create a language
	public Language createLanguage(Language newLanguage) {
		return this.lRepo.save(newLanguage);
	}
	// update a language
	public Language updateLanguage(Long id, Language lang) {
		return this.lRepo.save(lang);
	}
	// delete a language
	public void deleteLanguage(Long id) {
		this.lRepo.deleteById(id);
	}
	// create language with HTML forms
	//public Language createLanguageHTML(String name, String creator, float currentVersion) {
		//Language newLanguage = new Language(name, creator, currentVersion);
		//return this.lRepo.save(newLanguage);
	//}
	
	
}
