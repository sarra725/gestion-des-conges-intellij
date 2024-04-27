package com.example.conges3.Service.impl;

import com.example.conges3.Dto.EmployeeDTO;
import com.example.conges3.Dto.LoginDTO;
import com.example.conges3.Entity.Employee;
import com.example.conges3.Entity.Role;
import com.example.conges3.Repo.EmployeeRepo;
import com.example.conges3.Repo.RoleRepo;
import com.example.conges3.Repo.ServiceRepo;
import com.example.conges3.Service.EmployeeService;
import com.example.conges3.cresponse.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeIMPL implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private RoleRepo roleRepository;

    @Autowired
    private ServiceRepo serviceRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addEmployee(EmployeeDTO employeeDTO ) {
        Employee employee = new Employee(
                employeeDTO.getEmployeeid(),
                employeeDTO.getEmployeename(),
                employeeDTO.getEmail(),
                employeeDTO.getPassword(),
                employeeDTO.getRoleName()
        );



        // Assigner le rôle à l'employé
        Role role = roleRepository.findByName(employeeDTO.getRoleName()); // Supposons que vous récupérez le rôle par son nom depuis la base de données
        employee.setRole(role);

        // Associer le rôle et le service à l'employé

        employeeRepo.save(employee);
        return employee.getEmployeename();
    }

 /*   @Override
    public LoginResponse loginEmployee(LoginDTO loginDTO) {
        String msg = "";
        Employee employee1 = employeeRepo.findByEmail(loginDTO.getEmail());
        String roleName = null;
        if (employee1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = employee1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            roleName = null;
            if (isPwdRight) {
                Optional<Employee> employee = employeeRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                roleName = null;
                if (employee.isPresent()) {
                    Role role = employee1.getRole(); // Retrieve the role of the employee
                    roleName = role != null ? role.getName() : "admin";
                    return new LoginResponse("Login Success", true, roleName);
                } else {
                    return new LoginResponse("Login Failed", false, roleName);
                }
            } else {
                return new LoginResponse("password Not Match", false, roleName);
            }
        } else {
            return new LoginResponse("Email not exits", false, roleName);
        }
    }
*/
    
    public LoginResponse loginEmployee(LoginDTO loginDTO) {
        LoginResponse response = new LoginResponse(null, null);
        Employee employee1 = employeeRepo.findByEmail(loginDTO.getEmail());
        if ((loginDTO.getEmail() != null)&&(loginDTO.getPassword() != null)) {
        	System.out.println("okkk in");
        	List<Employee> employee = employeeRepo.findByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword());
        	if (employee.isEmpty())
        	{
        		response.setMessage("Email or password not exits !!");
            	response.setStatus(false);
            	
        	}else {
        		response.setMessage("Login Success");
        		response.setRoleName(employee.get(0).getRoleName().toUpperCase());
            	response.setStatus(true);
            	response.setIdUser(employee.get(0).getEmployeeid());
        	}
        }else {
        	response.setMessage("Email or password not exits !!");
        	response.setStatus(false);
        }
       
        return response;
    }
	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> listEmloyee=employeeRepo.findAll();
		return listEmloyee;
	}

	@Override
	public Optional<Employee> findById(Long id) {
		// TODO Auto-generated method stub
		return employeeRepo.findById(id);
	}




}




