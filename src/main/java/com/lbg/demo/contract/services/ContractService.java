package com.lbg.demo.contract.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.demo.contract.domain.Contract;
import com.lbg.demo.contract.repo.ContractRepo;

@Service
public class ContractService {

	private ContractRepo repo;

	public ContractService(ContractRepo repo) {
		super();
		this.repo = repo;
	}

//	 post mapping 'create'
	public Contract create(Contract newContract) {
		return this.repo.save(newContract);
	}

//	public ResponseEntity<Contract> createContact(Contact newContract) {
//		Phone created = this.repo.save(newPhone);
//		return new ResponseEntity<Contract>(created, HttpStatus.CREATED);
//	}

	// get mapping by id 'get/id'
	public ResponseEntity<Contract> read(int id) {
		Optional<Contract> found = this.repo.findById(id);
		if (found.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(found.get());
	}

	// get mapping for 'get all'
	public List<Contract> readAll() {
		return this.repo.findAll();
	}

	// delete mapping for 'remove by id'
	public boolean delete(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

	// put mapping for 'update by id'

	public ResponseEntity<Contract> update(int id, Contract newContract) {
		Optional<Contract> found = this.repo.findById(id);
		if (found.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Contract existing = found.get();
		if (newContract.getLength() != null) {
			existing.setLength(newContract.getLength());
		}
		if (newContract.getData() != null) {
			existing.setData(newContract.getData());
		}
		if (newContract.getMinutes() != null) {
			existing.setMinutes(newContract.getMinutes());
		}
		Contract updated = this.repo.save(existing);
		return ResponseEntity.ok(updated);
	}

}
