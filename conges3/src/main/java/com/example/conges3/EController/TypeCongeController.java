package com.example.conges3.EController;


import com.example.conges3.Entity.TypeConge;

import com.example.conges3.Service.impl.TypeCongeIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/typeconge")
public class TypeCongeController {

    @Autowired
    private TypeCongeIMPL typecongeIMPL;
    @GetMapping("/all")
    public List<TypeConge> getAll(){return typecongeIMPL.getAll();}
    @GetMapping("/getOne/{id}")
    public TypeConge getOneTypeConge(@PathVariable Long id){return typecongeIMPL.getOneTypeConge(id);}
    @PostMapping("/add")
    public TypeConge creatTypeConge(@RequestBody TypeConge typeconge){return typecongeIMPL.creatTypeConge(typeconge);}
    @DeleteMapping("/delete/{id}")
    public HashMap<String,String> deletTypeConge (@PathVariable Long id)
    {
        HashMap<String,String > msg=new HashMap<>();
        try {
            typecongeIMPL.deletTypeConge(id);
            msg.put("etat","product delete");
            return msg;
        }catch (Exception e){
            msg.put("etat","product not found");
            return msg;
        }
    }

    @PutMapping("/update/{id}")
    public TypeConge update(@RequestBody TypeConge category,@PathVariable Long id){
        TypeConge c=this.typecongeIMPL.getOneTypeConge(id);
        if (c!=null)
        {
            category.setId(id);
            return typecongeIMPL.updateTypeConge(category);
        }else{
            throw new RuntimeException("FAIL!");}
    }


}
