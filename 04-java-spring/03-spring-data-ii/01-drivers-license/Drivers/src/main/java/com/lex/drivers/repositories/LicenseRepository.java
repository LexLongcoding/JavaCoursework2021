package com.lex.drivers.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lex.drivers.models.License;

public interface LicenseRepository extends CrudRepository<License, Long>{
	public List<License> findAll();
	public License findTopByOrderByNumberDesc();
}
