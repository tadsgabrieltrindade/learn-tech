package com.devsuperior.jparepository.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.jparepository.entities.Users;
import com.devsuperior.jparepository.repository.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Users>> findAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	//http://localhost:8080/users/page?page=0&size=10&sort=name,salary,asc
	@GetMapping(value = "/page")
	public ResponseEntity<Page<Users>> findAll(Pageable pageable){
		return ResponseEntity.ok(repository.findAll(pageable));
	}
	
	@GetMapping(value = "/search-salary")
	public ResponseEntity<Page<Users>> searchBySalary(@RequestParam(defaultValue = "0") Double minSalary, @RequestParam(defaultValue = "1000000000000") Double maxSalary, Pageable pageable) {
	    Page<Users> result = repository.findBySalaryBetween(minSalary, maxSalary, pageable);
	    return ResponseEntity.ok(result);
	}
	
	@GetMapping(value = "/search-name")
	public ResponseEntity<Page<Users>> searchByName(@RequestParam(defaultValue = "") String name, Pageable pageable) {
	    Page<Users> result = repository.searchByName(name, pageable);
	    return ResponseEntity.ok(result);
	}
}
