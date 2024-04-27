package com.example.conges3.Repo;

import com.example.conges3.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {

    Optional<Employee> findOneByEmailAndPassword(String email, String password);
    Employee findByEmail(String email);
    Optional<Employee> findById(Long id);
}
