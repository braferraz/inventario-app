package br.com.braferraz.inventario.dto.formulario.campo;

import br.com.braferraz.inventario.model.Campo;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface CampoMapper {
    Campo toEntity(CreateCampoDTO dto);
//    Campo toEntity(UpdateCampo dto);
    CampoDTO toDTO(Campo campo);
    List<CampoDTO> toDTOList(List<Campo> campos);
}
