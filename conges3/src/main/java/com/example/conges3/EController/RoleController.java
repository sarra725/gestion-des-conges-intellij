package com.example.conges3.EController;

import com.example.conges3.Entity.Role;
import com.example.conges3.Service.impl.RoleIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleIMPL roleIMPL;
    @GetMapping("/all")
    public List<Role> getAll(){return roleIMPL.getAll();}
    @GetMapping("/getOne/{id}")
    public Role getOneRole(@PathVariable Long id){return roleIMPL.getOneRole(id);}
    @PostMapping("/add")
    public Role creatRole(@RequestBody Role role){return roleIMPL.creatRole(role);}
    @DeleteMapping("delete/{id}")
    public HashMap<String,String> deletrole (@PathVariable Long id)
    {
        HashMap<String,String > msg=new HashMap<>();
        try {
            roleIMPL.deletRole(id);
            msg.put("etat","product delete");
            return msg;
        }catch (Exception e){
            msg.put("etat","product not found");
            return msg;
        }
    }

    @PutMapping("/update/{id}")
    public Role update(@RequestBody Role category, @PathVariable Long id){
        Role c=this.roleIMPL.getOneRole(id);
        if (c!=null)
        {
            category.setId(id);
            return roleIMPL.updateRole(category);
        }else{
            throw new RuntimeException("FAIL!");}
    }

    @GetMapping("/admin")
    public String adminPage() {
        // Redirection vers la page admin
        return "admin"; // Nom de la vue pour la page admin
    }

    @GetMapping("/user")
    public String userPage() {
        // Redirection vers la page utilisateur
        return "user"; // Nom de la vue pour la page utilisateur
    }
}
