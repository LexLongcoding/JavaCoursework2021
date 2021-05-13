package com.lex.prodcat.controllers;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lex.prodcat.models.Category;
import com.lex.prodcat.models.Product;
import com.lex.prodcat.services.CatService;
import com.lex.prodcat.services.ProdService;

@Controller
public class HomeController {
	@Autowired
	private ProdService pService;
	@Autowired
	private CatService cService;
	
	@GetMapping("/")
	public String Index(Model viewModel) {
		List<Category> allCategories = this.cService.getAllCategories();
		List<Product> allProducts = this.pService.getAllProducts();
		viewModel.addAttribute("products", allProducts);
		viewModel.addAttribute("categories", allCategories);
		return "index.jsp";
	}
	
	
	@GetMapping("/newProduct")
	public String addProduct(@ModelAttribute("product") Product product) {
		return "new.jsp";
	}
	
	@PostMapping("/newProduct")
	public String newProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp";
		}
		this.pService.createProduct(product);
		return "redirect:/";
	}
	@GetMapping("/newCategory")
	public String addCategory(@ModelAttribute("category") Category category) {
		return "newCat.jsp";
	}
	
	@PostMapping("/newCategory")
	public String newCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "newCat.jsp";
		}
		this.cService.createCategory(category);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable("id") Long id) {
		this.pService.deleteProduct(id);
		return "redirect:/";
	}
	
	@GetMapping("/product/{id}")
	public String showProduct(@PathVariable("id") Long id, Model viewModel) {
		Product productToShowcase = this.pService.getSingleProduct(id);
		List<Category> otherCats = cService.findCategoriesNotInProduct(productToShowcase);
		viewModel.addAttribute("product", productToShowcase);
		viewModel.addAttribute("notInCategories", otherCats);
		viewModel.addAttribute("product", productToShowcase);
		return "show.jsp";
	}
	@GetMapping("/category/{id}")
	public String showCategory(@PathVariable("id") Long id, Model viewModel) {
		Category selectedCat= this.cService.getSingleCategory(id);
		List<Product> otherProds = pService.findProductsNotInCategory(selectedCat);
		viewModel.addAttribute("category", selectedCat);
		viewModel.addAttribute("notInProducts", otherProds);
		viewModel.addAttribute("category", selectedCat);
		return "showCat.jsp";
	}
	
	@GetMapping("/edit/{id}")
	public String editProduct(@PathVariable("id") Long id, @ModelAttribute("product") Product product, Model viewModel) {
		viewModel.addAttribute("product", this.pService.getSingleProduct(id));
		return "edit.jsp";
	}
	
	@PostMapping("/edit/{id}")
	public String processEdit(@Valid @ModelAttribute("product") Product product, BindingResult result, Model viewModel, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			viewModel.addAttribute("product", this.pService.getSingleProduct(id));
			return "edit.jsp";
		}
		this.pService.updateProduct(product);
		return "redirect:/{id}";
	}
	
	@PostMapping("/product/add")
	  public String addCategoryToProduct(@RequestParam("category_id") Long catId, @RequestParam("product_id") Long prodId){ 
		  Product product = pService.getSingleProduct(prodId);
		  Category category = cService.getSingleCategory(catId); 
		  pService.addCategory(category, product);
		  return "redirect:/";
	  }
	 @PostMapping("/category/add")
	  public String addProductToCategory(@RequestParam("product_id") Long proId, @RequestParam("category_id") Long catId) {
		  Category category = cService.getSingleCategory(catId);
		  Product product = pService.getSingleProduct(proId);
		  cService.addProduct(product, category);
		  return "redirect:/";
	  }
	/* @GetMapping("/addCat/{id}")
		public String addCat(@PathVariable("id") Long id, Category category) {
			Long catId = id;
			Category category = this.cService.getSingleCategory(catId);
			Product product = this.pService.getSingleProduct(productId);
			this.pService.category(category, product);
			return "redirect:/dogs";
		}*/
	
	 
	
	
	
	

}
