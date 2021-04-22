package com.lex.controllerspractice.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController

public class HomeController {
	@RequestMapping("/")
    public String home() {
            return "Hello World!";
    }
	@RequestMapping("/world")
    public String world() {
            return "Class level annotations are cool too!";
    }

}
