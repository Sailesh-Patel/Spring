package com.lbg.demo.phone.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.demo.phone.domain.Phone;

@RestController
public class PhoneController {

	private List<Phone> phones = new ArrayList<>();

	@GetMapping("/getphone1")
	public String upgrade1() {
		return "Time for an upgrade";
	}

	@GetMapping("/getphone2")
	public String upgrade2() {
		return "What phone should i go for?";
	}

//	@PostMapping("/create")
//	public String createPhone(@RequestBody Phone newPhone) {
//		this.phones.add(newPhone);
//		return newPhone.toString();
//	}

	// Response entity with create

	@PostMapping("/create")
	public ResponseEntity<Phone> createPhone(@RequestBody Phone newPhone) {
		this.phones.add(newPhone);
		Phone body = this.phones.get(this.phones.size() - 1);
		return new ResponseEntity<Phone>(body, HttpStatus.CREATED);
	}

	// get all command
	@GetMapping("/get")
	public List<Phone> getPhones() {
		return phones;
	}

	// get by id

//	@GetMapping("/get/{id}")
//	public Phone getPhone(@PathVariable int id) {
//		return this.phones.get(id);
//	}

	// response entity with get to status not found

	@GetMapping("/get/{id}")
	public ResponseEntity<Phone> getPhone(@PathVariable int id) {
		if (id < 0 || id >= this.phones.size()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Phone found = this.phones.get(id);

		return ResponseEntity.ok(found);
	}

	// delete

	@DeleteMapping("/remove/{id}")
	public Phone remove(@PathVariable int id) {
		return this.phones.remove(id);
	}

	// update

	@PutMapping("/update/{id}")
	public Phone updatePhone(@PathVariable int id, @RequestBody Phone newPhone) {
		return this.phones.set(id, newPhone);
	}

}
