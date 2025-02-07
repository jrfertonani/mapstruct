package backend.entity.model.request;

import backend._config.Enums.Status;


public class UsuarioRequest {

    private String name;
    private String email;
    private Status status;

    public UsuarioRequest() {
    }

    public UsuarioRequest(String name, String email, Status status) {
        this.name = name;
        this.email = email;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}