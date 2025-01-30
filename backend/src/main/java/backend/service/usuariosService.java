package backend.service;

import backend._config.Exeptions.serviceExceptions.ObjectNotFoundException;
import backend.entity.DTO.usuariosDTO;
import backend.entity.model.Usuarios;
import backend.repository.usuariosRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class usuariosService {

    @Autowired
    public ModelMapper mapper;

    @Autowired
    public usuariosRepository repository;


    public Usuarios save(usuariosDTO DTO) {
        return repository.save(
                mapper.map(DTO, Usuarios.class)
        );
    }

    public List<Usuarios> findAll(){
        return repository.findAll();
    };

    public Usuarios findById(Long id) {
        return mapper.map(
                repository.findById(id).orElseThrow(
                        ()-> new ObjectNotFoundException("Usuario não encontrado ID: " + id)
                ), Usuarios.class);
    }

    public Usuarios upDate(Long id,usuariosDTO DTO){
        findById(id);
        return repository.save(
                mapper.map(DTO, Usuarios.class)
        );
    }

    public void deleteById(Long id){
        findById(id);
        repository.deleteById(id);
    }
}
