package com.lex.prodcat.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lex.prodcat.models.Category;
import com.lex.prodcat.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>  {
	List<Category> findAll();
	
	List<Category> findByProductsNotContains(Product product);
}