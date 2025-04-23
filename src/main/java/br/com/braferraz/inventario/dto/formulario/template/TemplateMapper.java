package br.com.braferraz.inventario.dto.formulario.template;

import br.com.braferraz.inventario.model.Template;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface TemplateMapper {
    Template toEntity(CreateTemplateDTO dto);
//    Template toEntity(UpdateTemplateFormularioDTO dto);
    TemplateDTO toDTO(Template templFormulario);
    List<TemplateDTO> toDTOList(List<Template> templFormularios);
}
