package com.lex.routing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
@RestController
@RequestMapping("/coding")
public class CodingController {
	@RequestMapping("")
	public String index() {
		return  "Hello Coding Dojo!";
	}
	@RequestMapping("/python")
	public String pg2() {
		return  "Python/Django was awesome!";
	}
	@RequestMapping("/java")
	public String pg3() {
		return  "Java/Spring is better!";
	}
	
	
	

}
