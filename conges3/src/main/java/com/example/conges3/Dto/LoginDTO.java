package com.example.conges3.Dto;

public class LoginDTO {


    private String email;
    private String password;
    private String role;



    public LoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public LoginDTO(){

    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
