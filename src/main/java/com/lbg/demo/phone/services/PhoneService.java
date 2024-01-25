package com.lbg.demo.phone.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.demo.phone.domain.Phone;

@Service
public class PhoneService {

	private List<Phone> phones = new ArrayList<>();

	// post mapping 'create'
	public ResponseEntity<Phone> createPhone(Phone newPhone) {
		this.phones.add(newPhone);
		Phone body = this.phones.get(this.phones.size() - 1);
		return new ResponseEntity<Phone>(body, HttpStatus.CREATED);
	}

	// get mapping by id 'get/id'
	public ResponseEntity<Phone> getPhone(int id) {
		if (id < 0 || id >= this.phones.size()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Phone found = this.phones.get(id);

		return ResponseEntity.ok(found);
	}

	// get mapping for 'get all'
	public List<Phone> getPhones() {
		return phones;
	}

	// delete mapping for 'remove by id'
	public Phone remove(int id) {
		return this.phones.remove(id);
	}

	// put mapping for 'update by id'

	public Phone updatePhone(int id, Phone newPhone) {
		return this.phones.set(id, newPhone);
	}

}
