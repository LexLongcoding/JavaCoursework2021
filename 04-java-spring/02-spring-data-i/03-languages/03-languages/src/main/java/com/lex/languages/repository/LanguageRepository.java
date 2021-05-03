package com.lex.languages.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lex.languages.models.Language;

public interface LanguageRepository extends CrudRepository<Language, Long> {
	List<Language> findAll();

}
