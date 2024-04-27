package com.example.conges3.Service.impl;

import com.example.conges3.Entity.Conge;
import com.example.conges3.Entity.Employee;
import com.example.conges3.Repo.CongeRepo;
import com.example.conges3.Service.CongeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CongeIMPL implements CongeService {


    @Autowired
    private CongeRepo congeRepo;
    @Override
    public List<Conge> getAll() {
        return congeRepo.findAll();
    }

    @Override
    public Conge creatConge(Conge conge) {
        conge.setResponse("wait");
        return congeRepo.save(conge);
    }

    @Override
    public Conge getOneConge(Long id) {
        return congeRepo.findById(id).get();
    }

    @Override
    public Conge updateConge(Conge conge) {
        return congeRepo.saveAndFlush(conge);
    }

    @Override
    public void deletConge(Long id) {
        congeRepo.deleteById(id);
    }

	@Override
	public List<Conge> findByEmployee(Employee employee) {
		
		return congeRepo.findByEmployee(employee);
	}


}
