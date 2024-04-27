package com.example.conges3.Service;

import com.example.conges3.Dto.EmployeeDTO;
import com.example.conges3.Dto.LoginDTO;
import com.example.conges3.Entity.Employee;
import com.example.conges3.cresponse.LoginResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService {
    String addEmployee(EmployeeDTO employeeDTO);

    LoginResponse loginEmployee(LoginDTO loginDTO);
    
    List<Employee> getAllEmployee();
    
    Optional<Employee> findById(Long id);




}
