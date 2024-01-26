package com.lbg.demo.contract.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.demo.contract.domain.Contract;
import com.lbg.demo.contract.services.ContractService;

@RestController
@RequestMapping("/Contract")
public class ContractController {

	private ContractService service;

	public ContractController(ContractService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public Contract create(@RequestBody Contract newContract) {
		return this.service.create(newContract);
	}

//	@PostMapping("/create")
//	public ResponseEntity<Phone> createPhone(@RequestBody Phone newPhone) {
//		return this.service.createPhone(newPhone);
//	}

	@GetMapping("/get")
	public List<Contract> readAll() {
		return this.service.readAll();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Contract> read(@PathVariable int id) {
		return this.service.read(id);

	}

	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable int id) {
		return this.service.delete(id);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Contract> update(@PathVariable int id, @RequestBody Contract newContract) {
		return this.service.update(id, newContract);
	}

}
