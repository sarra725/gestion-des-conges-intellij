package com.example.conges3.Dto;

public class EmployeeDTO {

    private int employeeid;
    private String employeename;
    private String email;
    private String password;
    private Long roleId; // Nouveau champ pour l'identifiant du rôle
    private Long serviceId;

    private String roleName;
    public EmployeeDTO(int employeeid, String employeename, String email, String password , Long roleId, Long serviceId, String roleName) {
        this.employeeid = employeeid;
        this.employeename = employeename;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
        this.serviceId = serviceId;
        this.roleName=roleName;

    }
    
 

    public EmployeeDTO(){

    }

    public int getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(int employeeid) {
        this.employeeid = employeeid;
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getServiceId() {
        return serviceId;
    }



    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }



	@Override
    public String toString() {
        return "EmployeeDTO{" +
                "employeeid=" + employeeid +
                ", employeename='" + employeename + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roleId=" + roleId +
                ", serviceId=" + serviceId +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
