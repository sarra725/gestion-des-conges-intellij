package com.example.conges3.Entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Conge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date date_debut;
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date date_fin;
    private String cause;
    @ManyToOne
    private Employee employee;
    @ManyToOne
    private TypeConge typeConge;
    public Employee getEmployee() {
        return employee;
    }
    public String getNomUtilisateur() {
        if (employee != null) {
            return employee.getEmployeename();
        } else {
            return null; // ou une valeur par défaut appropriée
        }
    }


    public String getServiceUtilisateur() {
        if (employee != null && employee.getService() != null) {
            return employee.getService().getNomService();
        } else {
            return null; // ou une valeur par défaut appropriée
        }
    }



    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setTypeConge(TypeConge typeConge) {
        this.typeConge = typeConge;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }


}
