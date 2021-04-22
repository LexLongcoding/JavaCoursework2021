package com.lex.strings;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SuppressWarnings("unused")
@SpringBootApplication
@RestController
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@RequestMapping("/")
	public String msg1() {
		return "Greetings user!";

	}
	@RequestMapping("/random")
	public String msg2() {
		return "Spring boot makes Java easier";

	}
}