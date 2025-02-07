package backend.service;

import backend._config.Exeptions.serviceExceptions.ObjectNotFoundException;
import backend._config.Mapstruct.UsuarioMapper;
import backend.entity.model.request.UsuarioRequest;
import backend.entity.model.response.UsuarioResponse;
import backend.repository.usuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class usuariosService {

    @Autowired
    public UsuarioMapper mapper;

    @Autowired
    public usuariosRepository repository;

    public UsuarioResponse save(UsuarioRequest request){

        return mapper.toDto(
                repository.save
                        (mapper.toEntity(request)
                        )
        );
    }

    public List<UsuarioResponse> findAll(){
        return mapper.toListResponse(
                repository.findAll()
        );
    }


    public UsuarioResponse findById(Long id){
        return mapper.toDto(
                repository.findById(id).orElseThrow(()-> new ObjectNotFoundException("Objeto not foulnd"))
        );
    }

    public void deleteById(Long id){
        findById(id);
        repository.deleteById(id);
    }

}
