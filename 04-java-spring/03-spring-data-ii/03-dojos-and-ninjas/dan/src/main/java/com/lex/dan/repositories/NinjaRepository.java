package com.lex.dan.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lex.dan.models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja, Long>{
	List<Ninja> findAll();
}
