package backend.resource;

import backend._config.Mapstruct.UsuarioMapper;
import backend.entity.model.request.UsuarioRequest;
import backend.entity.model.response.UsuarioResponse;
import backend.service.usuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/usuarios")
public class usuariosResource {

    @Autowired
    public UsuarioMapper mapper;

    @Autowired
    public usuariosService service;

    @PostMapping
    public ResponseEntity<UsuarioResponse> salve(@RequestBody UsuarioRequest DTO){
        return ResponseEntity.ok(service.save(DTO));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UsuarioResponse> deleteByIdDelete(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
