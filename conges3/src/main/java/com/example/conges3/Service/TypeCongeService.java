package com.example.conges3.Service;

import com.example.conges3.Entity.Conge;
import com.example.conges3.Entity.TypeConge;

import java.util.List;

public interface TypeCongeService {

    List<TypeConge> getAll();
    TypeConge creatTypeConge(TypeConge typeConge);
    TypeConge getOneTypeConge(Long id);
    TypeConge updateTypeConge(TypeConge typeConge);
    void deletTypeConge(Long id);
}
