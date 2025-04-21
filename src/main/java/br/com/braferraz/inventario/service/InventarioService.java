package br.com.braferraz.inventario.service;

import br.com.braferraz.inventario.dto.inventario.CreateInventarioDTO;
import br.com.braferraz.inventario.dto.inventario.InventarioDTO;
import br.com.braferraz.inventario.dto.inventario.InventarioMapper;
import br.com.braferraz.inventario.dto.inventario.UpdateInventarioDTO;
import br.com.braferraz.inventario.model.Inventario;
import br.com.braferraz.inventario.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioService {

    @Autowired
    private final InventarioRepository inventarioRepository;
    @Autowired
    private final InventarioMapper inventarioMapper;

    public InventarioService(InventarioRepository inventarioRepository, InventarioMapper inventarioMapper) {
        this.inventarioRepository = inventarioRepository;
        this.inventarioMapper = inventarioMapper;
    }

    public InventarioDTO criar(CreateInventarioDTO dto) {
        Inventario inventario = inventarioMapper.toEntity(dto);
        Inventario salvo = inventarioRepository.save(inventario);
        return inventarioMapper.toDTO(salvo);
    }

    public List<InventarioDTO> listarTodos(){
        return inventarioMapper.toDTOList(inventarioRepository.findAll());
    }

    public InventarioDTO listarPorId(Long id){
        Inventario inventario = inventarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(("Inventário não encontrado")));
        return inventarioMapper.toDTO(inventario);
    }
    public InventarioDTO atualizar(UpdateInventarioDTO dto, Long id) {
        Inventario inventario = inventarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(("Inventário não encontrado")));
        inventario.setNome(dto.getNome());
        inventario.setCodCliente(dto.getCodCliente());
        inventario.setDataInicio(dto.getDataInicio());
        inventario.setStatus(dto.getStatus());
        inventario.setInventariadores(dto.getInventariadores());

        Inventario atualizado = inventarioRepository.save(inventario);

        return inventarioMapper.toDTO(atualizado);
    }
}
