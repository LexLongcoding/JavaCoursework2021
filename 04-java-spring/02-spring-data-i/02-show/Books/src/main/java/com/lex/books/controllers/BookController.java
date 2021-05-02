package com.lex.books.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lex.books.models.Book;
import com.lex.books.services.BookService;

@Controller
// i cant get this thing to find my jsp files?
public class BookController {
    
    private final BookService bookService;
    
    public BookController(BookService bookService){
        this.bookService = bookService;
    }
    @RequestMapping("/books")
    public String books(Model model) {
        List<Book> books = this.bookService.allBooks();
        model.addAttribute("books", books);
        return "show.jsp";
        //return "books.jsp";
    }
    @RequestMapping("/books/{index}")
    public String findBookByIndex(Model model, @PathVariable("index") int index) {
        Book book = bookService.findBookByIndex(index);
        model.addAttribute("book", book);
        
        return "show.jsp";
    }
    
    @RequestMapping(path = "/search", method = RequestMethod.POST)
    public String UserSearchBookByIndex(Model model, @RequestParam(value = "index") int index) {
    	
    	return findBookByIndex(model, index);
        
    }
    
    
    @RequestMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {
    	
    	return "books/new.jsp";
    }
    
    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
    	
    	if(result.hasErrors()) {
    		System.out.println("error");	
    		return "books/new.jsp";
    	}
    	
    	else {
    		
    		List<Book> books = this.bookService.allBooks();
    		int last_index = books.size() -1  ;
    		System.out.println(last_index);
    		String printout = "/books/" + last_index;
    		System.out.println(printout);
    		return "redirect:"+printout;
    	}
    	
    }
}