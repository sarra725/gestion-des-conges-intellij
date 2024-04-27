package com.example.conges3.Service.impl;

import com.example.conges3.Entity.Employee;
import com.example.conges3.Entity.TypeConge;
import com.example.conges3.Repo.CongeRepo;
import com.example.conges3.Repo.TypeCongeRepo;
import com.example.conges3.Service.TypeCongeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeCongeIMPL implements TypeCongeService {

    @Autowired
    private TypeCongeRepo typecongeRepo;

    @Override
    public List<TypeConge> getAll() {
        return typecongeRepo.findAll();
    }

    @Override
    public TypeConge creatTypeConge(TypeConge typeConge) {
        return typecongeRepo.save(typeConge);
    }

    @Override
    public TypeConge getOneTypeConge(Long id) {
        return typecongeRepo.findById(id).get();
    }

    @Override
    public TypeConge updateTypeConge(TypeConge typeConge) {
        return typecongeRepo.saveAndFlush(typeConge);
    }

    @Override
    public void deletTypeConge(Long id) {
        typecongeRepo.deleteById(id);

    }



}
