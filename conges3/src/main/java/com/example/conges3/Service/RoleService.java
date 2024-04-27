
package com.example.conges3.Service;

import com.example.conges3.Entity.Conge;
import com.example.conges3.Entity.Role;

import java.util.List;

public interface RoleService {
    Role getRoleByName(String name);

    List<Role> getAll();
    Role creatRole(Role role);
    Role getOneRole(Long id);
    Role updateRole(Role role);
    void deletRole(Long id);
}
