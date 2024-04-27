package com.example.conges3.Service.impl;


import com.example.conges3.Entity.Service;
import com.example.conges3.Repo.ServiceRepo;
import com.example.conges3.Service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@org.springframework.stereotype.Service
public class ServiceIMPL implements ServiceService {

    @Autowired
    private ServiceRepo serviceRepo;

    @Override
    public List<Service> getAll() {
        return serviceRepo.findAll();
    }

    @Override
    public Service creatService(Service service) {
        return serviceRepo.save(service);
    }

    @Override
    public Service getOneService(Long id) {
        return serviceRepo.findById(id).get();
    }

    @Override
    public Service updateService(Service service) {
        return serviceRepo.saveAndFlush(service);
    }

    @Override
    public void deletService(Long id) {
        serviceRepo.deleteById(id);


    }
}
