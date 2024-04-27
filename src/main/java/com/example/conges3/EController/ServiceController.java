package com.example.conges3.EController;


import com.example.conges3.Entity.Conge;
import com.example.conges3.Entity.Service;
import com.example.conges3.Service.impl.CongeIMPL;
import com.example.conges3.Service.impl.ServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private ServiceIMPL serviceIMPL;
    @GetMapping("/all")
    public List<Service> getAll(){return serviceIMPL.getAll();}
    @GetMapping("/getOne/{id}")
    public Service getOneService(@PathVariable Long id){return serviceIMPL.getOneService(id);}
    @PostMapping("/add")
    public Service creatService(@RequestBody Service service){return serviceIMPL.creatService(service);}
    @DeleteMapping("/delete/{id}")
    public HashMap<String,String> deletService (@PathVariable Long id)
    {
        HashMap<String,String > msg=new HashMap<>();
        try {
            serviceIMPL.deletService(id);
            msg.put("etat","product delete");
            return msg;
        }catch (Exception e){
            msg.put("etat","product not found");
            return msg;
        }
    }

    @PutMapping("/update/{id}")
    public Service update(@RequestBody Service category,@PathVariable Long id){
        Service c=this.serviceIMPL.getOneService(id);
        if (c!=null)
        {
            category.setId(id);
            return serviceIMPL.updateService(category);
        }else{
            throw new RuntimeException("FAIL!");}
    }

}
