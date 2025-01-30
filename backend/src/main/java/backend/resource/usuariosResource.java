package backend.resource;

import backend.entity.DTO.usuariosDTO;
import backend.entity.model.Usuarios;
import backend.service.usuariosService;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/usuarios")
public class usuariosResource {

    @Autowired
    public ModelMapper mapper;

    @Autowired
    public usuariosService service;

    @PostMapping
    public ResponseEntity<usuariosDTO> save(@RequestBody usuariosDTO DTO) {
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(
                        service.save(DTO)
                ).toUri();
        return ResponseEntity.created(uri).body(DTO);
    }

    @GetMapping
    public ResponseEntity<List<Usuarios>> findAll(){
        return ResponseEntity.ok().body(
                service.findAll()
                        .stream().map(x -> mapper.map(
                                x, Usuarios.class)
                        ).toList()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(
                mapper.map( service.findById(id), Usuarios.class)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<usuariosDTO> upDate(@PathVariable Long id,
                                           @RequestBody usuariosDTO DTO){
        DTO.setId(id);
        Usuarios obj = service.upDate(id,DTO);
        return ResponseEntity.ok().body(DTO);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<usuariosDTO> delete (@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
