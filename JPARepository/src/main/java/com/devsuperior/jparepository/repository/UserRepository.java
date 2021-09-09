package com.devsuperior.jparepository.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.jparepository.entities.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

	Page<Users> findBySalaryBetween(Double minSalary, Double maxSalary, Pageable pageable);

	Page<Users> searchByName(String name, Pageable pageable);

	
}
