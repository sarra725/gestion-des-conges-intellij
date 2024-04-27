package com.example.conges3.Service;

import com.example.conges3.Entity.Conge;

import java.util.List;

public interface CongeService {

    List<Conge> getAll();
    Conge creatConge(Conge conge);
    Conge getOneConge(Long id);
    Conge updateConge(Conge conge);
    void deletConge(Long id);
}
