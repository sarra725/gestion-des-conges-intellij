package com.example.conges3.Repo;

import com.example.conges3.Entity.Conge;
import com.example.conges3.Entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CongeRepo extends JpaRepository<Conge,Long> {
	
	List<Conge> findByEmployee(Employee employee);
}
