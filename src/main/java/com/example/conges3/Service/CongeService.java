package com.example.conges3.Service;

import com.example.conges3.Entity.Conge;
import com.example.conges3.Entity.Employee;

import java.util.List;

public interface CongeService {

    List<Conge> getAll();
    List<Conge> findByEmployee(Employee employee);
    Conge creatConge(Conge conge);
    Conge getOneConge(Long id);
    Conge updateConge(Conge conge);
    void deletConge(Long id);

}
