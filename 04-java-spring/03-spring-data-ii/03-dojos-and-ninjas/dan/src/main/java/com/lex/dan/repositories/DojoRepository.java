package com.lex.dan.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lex.dan.models.Dojo;

public interface DojoRepository extends CrudRepository<Dojo, Long>{
	List<Dojo> findAll();
}
