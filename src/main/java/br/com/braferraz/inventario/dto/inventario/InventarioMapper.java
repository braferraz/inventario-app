package br.com.braferraz.inventario.dto.inventario;

import br.com.braferraz.inventario.model.Inventario;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface InventarioMapper {
    Inventario toEntity(CreateInventarioDTO dto);
    Inventario toEntity(UpdateInventarioDTO dto);
    InventarioDTO toDTO(Inventario inventario);
    List<InventarioDTO> toDTOList(List<Inventario> inventarios);
}
