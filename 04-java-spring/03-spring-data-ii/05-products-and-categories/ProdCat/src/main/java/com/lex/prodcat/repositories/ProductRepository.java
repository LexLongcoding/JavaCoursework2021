package com.lex.prodcat.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lex.prodcat.models.Category;
import com.lex.prodcat.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

	List<Product> findAll();
	
	List<Product> findByCategoriesNotContains(Category category);
}
