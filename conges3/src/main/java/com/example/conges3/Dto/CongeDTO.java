package com.example.conges3.Dto;

import java.util.Date;

public class CongeDTO {
    private Date date_debut;
    private Date date_fin;
    private String cause;
    private Long employeeId; // Identifiant de l'employé
    private Long typeCongeId; // Identifiant du type de congé

    private String serviceUtilisateur;
    // Getters and setters

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

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getTypeCongeId() {
        return typeCongeId;
    }

    public void setTypeCongeId(Long typeCongeId) {
        this.typeCongeId = typeCongeId;
    }

    public String getServiceUtilisateur() {
        return serviceUtilisateur;
    }

    public void setServiceUtilisateur(String serviceUtilisateur) {
        this.serviceUtilisateur = serviceUtilisateur;
    }


}
