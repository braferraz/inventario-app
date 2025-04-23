package br.com.braferraz.inventario.controller;

import br.com.braferraz.inventario.dto.formulario.template.CreateTemplateDTO;
import br.com.braferraz.inventario.dto.formulario.template.TemplateDTO;
import br.com.braferraz.inventario.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/template")
public class TemplateController {
    @Autowired
    private final TemplateService templateFormularioService;

    public TemplateController(TemplateService templateFormularioService){
        this.templateFormularioService = templateFormularioService;
    }

    @PostMapping
    public ResponseEntity<TemplateDTO> criar(@RequestBody CreateTemplateDTO dto) {
        return ResponseEntity.ok(templateFormularioService.criar(dto));
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<TemplateDTO> atualizar(@PathVariable Long id, @RequestBody @Valid UpdateTemplateDTO dto) {
//        return ResponseEntity.ok(templateFormularioService.atualizar(dto, id));
//    }

    @GetMapping
    public ResponseEntity<List<TemplateDTO>> listarTodos() {
        return ResponseEntity.ok(templateFormularioService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TemplateDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(templateFormularioService.listarPorId(id));
    }
}
