package com.example.conges3.Service.impl;

import com.example.conges3.Entity.Employee;
import com.example.conges3.Entity.Role;
import com.example.conges3.Repo.RoleRepo;
import com.example.conges3.Service.RoleService;
import jakarta.persistence.OneToMany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleIMPL implements RoleService {
    @Autowired
    private RoleRepo roleRepo;

    @Override
    public Role getRoleByName(String name) {
        return roleRepo.findByName(name);
    }

    @Override
    public List<Role> getAll() {
        return roleRepo.findAll();
    }

    @Override
    public Role creatRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public Role getOneRole(Long id) {
        return roleRepo.findById(id).get();
    }

    @Override
    public Role updateRole(Role role) {
        return roleRepo.saveAndFlush(role);
    }

    @Override
    public void deletRole(Long id) {
        roleRepo.deleteById(id);

    }


    public Role getUserRole() {
        // Supposons que vous récupérez le rôle de l'utilisateur par ID ou tout autre moyen
        // Pour l'exemple, supposons que vous avez une méthode dans RoleRepo pour récupérer le rôle par ID
        Long userId = 1L; // Remplacez 1L par l'ID de l'utilisateur actuel
        // Utilisez RoleRepo pour récupérer le rôle de l'utilisateur par ID
        // Si vous récupérez le rôle de l'utilisateur par son ID, vous pouvez utiliser le code suivant
        // Role userRole = roleRepo.findByUserId(userId);

        // Pour cet exemple, renvoyons simplement un rôle prédéfini
        return roleRepo.findByName("user");
    }
}
