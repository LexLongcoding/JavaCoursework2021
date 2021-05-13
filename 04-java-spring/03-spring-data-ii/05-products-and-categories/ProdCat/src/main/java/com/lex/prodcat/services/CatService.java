package com.lex.prodcat.services;

import java.util.List;


import org.springframework.stereotype.Service;

import com.lex.prodcat.models.Category;
import com.lex.prodcat.models.Product;
import com.lex.prodcat.repositories.CategoryRepository;

@Service
public class CatService {
	private CategoryRepository cRepo;
	public CatService(CategoryRepository repo) {
		this.cRepo = repo;
	}
	// get all dogs
		public List<Category> getAllCategories(){
			return this.cRepo.findAll();
		}
		// get one dog
		public Category getSingleCategory(Long id) {
			return this.cRepo.findById(id).orElse(null);
		}
		// Create a Dog
		public Category createCategory(Category newCategory) {
			return this.cRepo.save(newCategory);
		}
		// update a dog
		public Category updateCategory(Category category) {
			return this.cRepo.save(category);
		}
		// delete a dog
		public void deleteCategory(Long id) {
			this.cRepo.deleteById(id);
		}
		public List<Category> findCategoriesNotInProduct(Product product) {
			return cRepo.findByProductsNotContains(product);
		}
		// add a product to category
		public void addProduct(Product product, Category category) {
			///get the list of products
			List<Product> products = category.getProducts();
			//add category to the list
			products.add(product);
			//update list in DB
			this.cRepo.save(category);
			
		}
}	 