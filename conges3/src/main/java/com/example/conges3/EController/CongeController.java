package com.example.conges3.EController;

import com.example.conges3.Dto.CongeDTO;
import com.example.conges3.Entity.Conge;
import com.example.conges3.Entity.Employee;
import com.example.conges3.Entity.TypeConge;
import com.example.conges3.Repo.CongeRepo;
import com.example.conges3.Repo.EmployeeRepo;
import com.example.conges3.Repo.TypeCongeRepo;
import com.example.conges3.Service.impl.CongeIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

import static java.lang.System.*;

@CrossOrigin(origins = {"http://localhost:4200","http://localhost:51555"})
@RestController
@RequestMapping("/conge")
public class CongeController {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private TypeCongeRepo typeCongeRepo;
    @Autowired
    private CongeIMPL congeIMPL;
    @GetMapping("/all")
    public List<Conge> getAll(){return congeIMPL.getAll();}
    @GetMapping("/getOne/{id}")
    public Conge getOneConge(@PathVariable Long id){return congeIMPL.getOneConge(id);}
    @PostMapping("/add")
    public Conge createConge(@RequestBody CongeDTO congeDTO) {

        Conge conge = new Conge();
        conge.setDate_debut(congeDTO.getDate_debut());
        conge.setDate_fin(congeDTO.getDate_fin());
        conge.setCause(congeDTO.getCause());



        Employee employee = employeeRepo.findById(congeDTO.getEmployeeId()).orElse(null);
        TypeConge typeConge = typeCongeRepo.findById(congeDTO.getTypeCongeId()).orElse(null);

            conge.setEmployee(employee);
            conge.setTypeConge(typeConge);

            return congeIMPL.creatConge(conge);

    }

    @DeleteMapping("/delete/{id}")
    public HashMap<String,String> deletConge (@PathVariable Long id)
    {
        HashMap<String,String > msg=new HashMap<>();
        try {
            congeIMPL.deletConge(id);
            msg.put("etat","product delete");
            return msg;
        }catch (Exception e){
            msg.put("etat","product not found");
            return msg;
        }
    }

    @PutMapping("/update/{id}")
    public Conge update(@RequestBody Conge category,@PathVariable Long id){
        Conge c=this.congeIMPL.getOneConge(id);
        if (c!=null)
        {
            category.setId(id);
            return congeIMPL.updateConge(category);
        }else{
            throw new RuntimeException("FAIL!");}
    }

}
