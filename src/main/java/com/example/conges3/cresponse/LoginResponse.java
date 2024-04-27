package com.example.conges3.cresponse;

public class LoginResponse {
    String message;
    Boolean status;
    private String roleName;
    private int idUser;

    public LoginResponse(String message, Boolean status, String roleName) {
        this.message = message;
        this.status = status;
        this.roleName = roleName;
    }

    public LoginResponse(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }
    public LoginResponse(){}
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	@Override
    public String toString() {
        return "LoginResponse{" +
                "message='" + message + '\'' +
                ", status=" + status +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
