package br.com.braferraz.inventario.controller;

import br.com.braferraz.inventario.dto.inventario.CreateInventarioDTO;
import br.com.braferraz.inventario.dto.inventario.InventarioDTO;
import br.com.braferraz.inventario.dto.inventario.UpdateInventarioDTO;
import br.com.braferraz.inventario.dto.usuario.UsuarioCreateDTO;
import br.com.braferraz.inventario.dto.usuario.UsuarioDTO;
import br.com.braferraz.inventario.model.Inventario;
import br.com.braferraz.inventario.service.InventarioService;
import br.com.braferraz.inventario.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventario")
public class InventarioController {
    @Autowired
    private final InventarioService inventarioService;

    public InventarioController(InventarioService inventarioService){
        this.inventarioService = inventarioService;
    }

    @PostMapping
    public ResponseEntity<InventarioDTO> criar(@RequestBody CreateInventarioDTO dto) {
        return ResponseEntity.ok(inventarioService.criar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventarioDTO> atualizar(@PathVariable Long id, @RequestBody @Valid UpdateInventarioDTO dto) {
        return ResponseEntity.ok(inventarioService.atualizar(dto, id));
    }

    @GetMapping
    public ResponseEntity<List<InventarioDTO>> listarTodos() {
        return ResponseEntity.ok(inventarioService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventarioDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(inventarioService.listarPorId(id));
    }
}
