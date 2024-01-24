package com.lbg.demo.classdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping("/hello")
	public String greeting() {
		return "Hello!";
	}

	@GetMapping("/hello1")
	public String super_Hero() {
		return "Daredevil";
	}

	@GetMapping("/hello2")
	public String super_Villan() {
		return "I'm Kingpin";
	}

	@PostMapping("/hero")
	public String createHero(@RequestBody Hero newHero) {
		return newHero.toString();
	}

}
