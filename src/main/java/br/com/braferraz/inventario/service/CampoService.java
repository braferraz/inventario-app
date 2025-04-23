package br.com.braferraz.inventario.service;

import br.com.braferraz.inventario.dto.formulario.campo.CampoDTO;
import br.com.braferraz.inventario.dto.formulario.campo.CampoMapper;
import br.com.braferraz.inventario.dto.formulario.campo.CreateCampoDTO;
import br.com.braferraz.inventario.model.Campo;
import br.com.braferraz.inventario.repository.CampoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampoService {

    @Autowired
    private final CampoRepository campoRepository;
    @Autowired
    private final CampoMapper campoMapper;

    public CampoService(CampoRepository campoRepository, CampoMapper campoMapper) {
        this.campoRepository = campoRepository;
        this.campoMapper = campoMapper;
    }

    public CampoDTO criar(CreateCampoDTO dto) {
        Campo campo = campoMapper.toEntity(dto);
        Campo salvo = campoRepository.save(campo);
        return campoMapper.toDTO(salvo);
    }

    public List<CampoDTO> listarTodos(){
        return campoMapper.toDTOList(campoRepository.findAll());
    }

    public CampoDTO listarPorId(Long id){
        Campo campo = campoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(("Inventário não encontrado")));
        return campoMapper.toDTO(campo);
    }
//    public CampoDTO atualizar(UpdateCampoDTO dto, Long id) {
//        Campo campo = campoRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException(("Inventário não encontrado")));
//        campo.setNome(dto.getNome());
//        campo.setCodCliente(dto.getCodCliente());
//        campo.setDataInicio(dto.getDataInicio());
//        campo.setStatus(dto.getStatus());
//        campo.setInventariadores(dto.getInventariadores());
//
//        Campo atualizado = campoRepository.save(campo);
//
//        return campoMapper.toDTO(atualizado);
//    }
}
