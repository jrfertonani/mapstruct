package backend._config.Mapstruct;

import backend.entity.model.request.UsuarioRequest;
import backend.entity.model.response.UsuarioResponse;
import backend.entity.model.Usuarios;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mapping(target = "id", ignore = true)
    Usuarios toEntity(UsuarioRequest DTO);

    UsuarioResponse toDto(Usuarios entity);

    List<UsuarioResponse> toListResponse(List<Usuarios> lista);

}
