package br.com.braferraz.inventario.controller;

import br.com.braferraz.inventario.dto.formulario.campo.CampoDTO;
import br.com.braferraz.inventario.dto.formulario.campo.CreateCampoDTO;
import br.com.braferraz.inventario.service.CampoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campo")
public class CampoController {
    @Autowired
    private final CampoService campoService;

    public CampoController(CampoService campoService){
        this.campoService = campoService;
    }

    @PostMapping
    public ResponseEntity<CampoDTO> criar(@RequestBody @Valid CreateCampoDTO dto) {
        return ResponseEntity.ok(campoService.criar(dto));
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<CampoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid UpdateCampoDTO dto) {
//        return ResponseEntity.ok(campoService.atualizar(dto, id));
//    }

    @GetMapping
    public ResponseEntity<List<CampoDTO>> listarTodos() {
        return ResponseEntity.ok(campoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampoDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(campoService.listarPorId(id));
    }
}
