package com.lex.prodcat.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lex.prodcat.models.Category;
import com.lex.prodcat.models.Product;
import com.lex.prodcat.repositories.ProductRepository;

@Service
public class ProdService {
	private ProductRepository pRepo;
	public ProdService(ProductRepository repo) {
		this.pRepo = repo;
	}
	// get all dogs
		public List<Product> getAllProducts(){
			return this.pRepo.findAll();
		}
		// get one dog
		public Product getSingleProduct(Long id) {
			return this.pRepo.findById(id).orElse(null);
		}
		// Create a Dog
		public Product createProduct(Product newProduct) {
			return this.pRepo.save(newProduct);
		}
		// update a dog
		public Product updateProduct(Product product) {
			return this.pRepo.save(product);
		
		}
		public List<Product> findProductsNotInCategory(Category category) {
			return pRepo.findByCategoriesNotContains(category);
		}
		// delete a dog
		public void deleteProduct(Long id) {
			this.pRepo.deleteById(id);
		}
		// add product to category
		public void addCategory(Category category, Product product) {
			///get the list of cats
			List<Category> categories = product.getCategories();
			//add category to the list
			categories.add(category);
			//update list in DB
			this.pRepo.save(product);
		}
		
			
		
}	 
	

