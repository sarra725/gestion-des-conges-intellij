package com.example.conges3.EController;

import com.example.conges3.Dto.EmployeeDTO;
import com.example.conges3.Dto.LoginDTO;
import com.example.conges3.Entity.Employee;
import com.example.conges3.Service.EmployeeService;
import com.example.conges3.cresponse.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin ("*")
@RequestMapping("api/v1/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    
    
    @PostMapping(path = "/save")
    public String saveEmployee(@RequestBody EmployeeDTO employeeDTO)
    {

        String id = employeeService.addEmployee(employeeDTO);
        return id;
    }





    @PostMapping(path = "/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO)
    {
        LoginResponse loginResponse = employeeService.loginEmployee(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
    
    @GetMapping (path="/list")
    public List<Employee> listEmployee () {
    	return employeeService.getAllEmployee();
    }
    
    
    @GetMapping (path="/list/{id}")
    public Optional<Employee> getEmployeeById (@PathVariable Long id) {
    	return employeeService.findById(id);
    }
}
