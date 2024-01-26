package com.lbg.demo.phone.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.demo.phone.domain.Phone;
import com.lbg.demo.phone.repos.PhoneRepo;

@Service
public class PhoneService {

	private PhoneRepo repo;

	public PhoneService(PhoneRepo repo) {
		super();
		this.repo = repo;
	}

	// post mapping 'create'
	public ResponseEntity<Phone> createPhone(Phone newPhone) {
		Phone created = this.repo.save(newPhone);
		return new ResponseEntity<Phone>(created, HttpStatus.CREATED);
	}

	// get mapping by id 'get/id'
	public ResponseEntity<Phone> getPhone(int id) {
		Optional<Phone> found = this.repo.findById(id);
		if (found.isEmpty()) {
			return new ResponseEntity<Phone>(HttpStatus.NOT_FOUND);
		}
		Phone body = found.get();
		return ResponseEntity.ok(body);
	}

	// get mapping for 'get all'
	public List<Phone> getPhones() {
		return this.repo.findAll();
	}

	// delete mapping for 'remove by id'
	public boolean remove(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

	// put mapping for 'update by id'

	public ResponseEntity<Phone> update(int id, Phone newPhone) {
		Optional<Phone> found = this.repo.findById(id);
		if (found.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Phone existing = found.get();
		if (newPhone.getBrand() != null) {
			existing.setBrand(newPhone.getBrand());
		}
		if (newPhone.getModel() != null) {
			existing.setModel(newPhone.getModel());
		}
		if (newPhone.getContract() != null) {
			existing.setContract(newPhone.getContract());
		}
		Phone updated = this.repo.save(existing);
		return ResponseEntity.ok(updated);
	}

}
