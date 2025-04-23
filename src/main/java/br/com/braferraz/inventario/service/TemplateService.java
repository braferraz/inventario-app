package br.com.braferraz.inventario.service;

import br.com.braferraz.inventario.dto.formulario.template.CreateTemplateDTO;
import br.com.braferraz.inventario.dto.formulario.template.TemplateDTO;
import br.com.braferraz.inventario.dto.formulario.template.TemplateMapper;
import br.com.braferraz.inventario.model.Campo;
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

    public TemplateDTO criarComCamposExistentes(CreateTemplateDTO dto) {
        // 1. Criar o novo Template
        Template template = new Template();
        template.setNome(dto.getNome());

        // 2. Buscar os Campos existentes
        List<Campo> campos = campoRepository.findAllById(dto.getCampos());

        // 3. Associar os campos ao novo Template
        for (Campo campo : campos) {
            campo.setTemplate(template); // Vincula o campo ao template
        }

        // 4. Setar os campos no Template
        template.setCampos(campos);

        // 5. Salvar o template (cascateia para atualizar os campos vinculados)
        Template salvo = templateRepository.save(template);

        // 6. Retornar o DTO mapeado
        return templateFormularioMapper.toDTO(salvo);
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
