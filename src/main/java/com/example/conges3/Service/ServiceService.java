
package com.example.conges3.Service;

import com.example.conges3.Entity.Conge;
import com.example.conges3.Entity.Role;
import com.example.conges3.Entity.Service;

import java.util.List;

public interface ServiceService {


    List<Service> getAll();
    Service creatService(Service service);
    Service getOneService(Long id);
    Service updateService(Service service);
    void deletService(Long id);
}
