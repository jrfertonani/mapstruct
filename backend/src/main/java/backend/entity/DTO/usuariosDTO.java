package backend.entity.DTO;

import backend._config.Enums.Status;

import java.io.Serial;


public class usuariosDTO {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Status status;

    public usuariosDTO() {
    }

    public usuariosDTO(Long id, String name, Status status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
