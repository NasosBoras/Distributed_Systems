package com.example.springbootdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomController {
	
	@GetMapping(value = "/test")
	public String homePage() {
		return "test";
	}
}
