package br.com.braferraz.inventario.service;

import br.com.braferraz.inventario.dto.formulario.template.CreateTemplateDTO;
import br.com.braferraz.inventario.dto.formulario.template.TemplateDTO;
import br.com.braferraz.inventario.dto.formulario.template.TemplateMapper;
import br.com.braferraz.inventario.model.Campo;
import br.com.braferraz.inventario.model.Inventario;
import br.com.braferraz.inventario.model.Template;
import br.com.braferraz.inventario.repository.CampoRepository;
import br.com.braferraz.inventario.repository.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateService {

    @Autowired
    private final TemplateRepository templateFormularioRepository;
    @Autowired
    private final CampoRepository campoRepository;
    @Autowired
    private final TemplateMapper templateFormularioMapper;

    public TemplateService(TemplateRepository templateFormularioRepository, TemplateMapper templateFormularioMapper, CampoRepository campoRepository) {
        this.templateFormularioRepository = templateFormularioRepository;
        this.templateFormularioMapper = templateFormularioMapper;
        this.campoRepository = campoRepository;
    }

    public TemplateDTO criar(CreateTemplateDTO dto) {
//        Template template = templateFormularioMapper.toEntity(dto);
//        Template salvo = templateFormularioRepository.save(template);
//        return templateFormularioMapper.toDTO(salvo);

        Template template = new Template();
        template.setNome(dto.getNome());

        // Carrega os Campos existentes pelos IDs recebidos
        List<Campo> campos = campoRepository.findAllById(dto.getCampoIds());
        template.setCampos(campos);

        return templateFormularioMapper.toDTO(templateFormularioRepository.save(template));
    }

    public List<TemplateDTO> listarTodos(){
        return templateFormularioMapper.toDTOList(templateFormularioRepository.findAll());
    }

    public TemplateDTO listarPorId(Long id){
        Template templateFormulario = templateFormularioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(("Template não encontrado")));
        return templateFormularioMapper.toDTO(templateFormulario);
    }
}
