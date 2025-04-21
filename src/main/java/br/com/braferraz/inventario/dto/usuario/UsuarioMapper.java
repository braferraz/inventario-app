package br.com.braferraz.inventario.dto.usuario;

import br.com.braferraz.inventario.model.Usuario;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface UsuarioMapper {
    Usuario toEntity(UsuarioCreateDTO dto);
    Usuario toEntity(UsuarioUpdateDTO dto);
    UsuarioDTO toDTO(Usuario usuario);
    List<UsuarioDTO> toDTOList(List<Usuario> usuarios);
}
