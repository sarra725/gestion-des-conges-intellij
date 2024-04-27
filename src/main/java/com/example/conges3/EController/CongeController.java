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
@RequestMapping("api/v1/conge")
public class CongeController {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private TypeCongeRepo typeCongeRepo;
    @Autowired
    private CongeIMPL congeIMPL;
    
    @GetMapping("/all/{id}")
    public List<Conge> getAllCongeByIdUser(@PathVariable Long id){
    	Employee employee = new Employee();
    	if (id != null)
    	  employee = employeeRepo.findById(id).orElse(null);
    	
    	return congeIMPL.findByEmployee(employee);
    	}
    
    
    @GetMapping("/all")
    public List<Conge> getAll(){
    	return congeIMPL.getAll();
    	}
    @GetMapping("/getOne/{id}")
    public Conge getOneConge(@PathVariable Long id){
    	return congeIMPL.getOneConge(id);
    	}
    @PostMapping("/add")
    public Conge createConge(@RequestBody CongeDTO congeDTO) {

        Conge conge = new Conge();
        conge.setDate_debut(congeDTO.getDate_debut());
        conge.setDate_fin(congeDTO.getDate_fin());
        conge.setCause(congeDTO.getCause());
        conge.setResponse(congeDTO.getResponse());


         if (congeDTO.getEmployeeId()!= null) {
        	 Employee employee = employeeRepo.findById(congeDTO.getEmployeeId()).orElse(null);
        	 conge.setEmployee(employee);
         }
       
         if (congeDTO.getTypeCongeId()!= null) {
        	 TypeConge typeConge = typeCongeRepo.findById(congeDTO.getTypeCongeId()).orElse(null);
        	 conge.setTypeConge(typeConge);        	 
         }

            
        conge.setResponse("wait");
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

    @PutMapping("/accepter/{id}")
    public Conge accepterConge(@PathVariable Long id) {
        Conge existingConge = congeIMPL.getOneConge(id);
        if (existingConge != null) {
            existingConge.setResponse("accepted");
            return congeIMPL.updateConge(existingConge);
        } else {
            throw new RuntimeException("Demande de congé non trouvée!");
        }
    }

    @PutMapping("/refuser/{id}")
    public Conge refuserConge(@PathVariable Long id) {
        Conge existingConge = congeIMPL.getOneConge(id);
        if (existingConge != null) {
            existingConge.setResponse("refused");
            return congeIMPL.updateConge(existingConge);
        } else {
            throw new RuntimeException("Demande de congé non trouvée!");
        }
    }
    
    @GetMapping("/response/{id}/{msg}")
    public Conge responseConge(@PathVariable Long id,@PathVariable String msg) {
        Conge existingConge = congeIMPL.getOneConge(id);
        if (existingConge != null) {
            existingConge.setResponse(msg);
            return congeIMPL.updateConge(existingConge);
        } else {
            throw new RuntimeException("Demande de congé non trouvée!");
        }
    }
}
