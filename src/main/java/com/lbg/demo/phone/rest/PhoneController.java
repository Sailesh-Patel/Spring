package com.lbg.demo.phone.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.demo.phone.domain.Phone;
import com.lbg.demo.phone.services.PhoneService;

@RestController
public class PhoneController {

	private PhoneService service;

	public PhoneController(PhoneService service) {
		super();
		this.service = service;
	}

	@GetMapping("/getphone1")
	public String upgrade1() {
		return "Time for an upgrade";
	}

	@GetMapping("/getphone2")
	public String upgrade2() {
		return "What phone should i go for?";
	}

	@PostMapping("/create")
	public ResponseEntity<Phone> createPhone(@RequestBody Phone newPhone) {
		return this.service.createPhone(newPhone);
	}

	@GetMapping("/get")
	public List<Phone> getPhones() {
		return this.service.getPhones();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Phone> getPhone(@PathVariable int id) {
		return this.service.getPhone(id);

	}

	@DeleteMapping("/remove/{id}")
	public Phone remove(@PathVariable int id) {
		return this.service.remove(id);
	}

	@PutMapping("/update/{id}")
	public Phone updatePhone(@PathVariable int id, @RequestBody Phone newPhone) {
		return this.service.updatePhone(id, newPhone);
	}

}
