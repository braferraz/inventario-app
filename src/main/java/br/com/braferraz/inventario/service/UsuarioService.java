package br.com.braferraz.inventario.service;

import br.com.braferraz.inventario.dto.usuario.UsuarioCreateDTO;
import br.com.braferraz.inventario.dto.usuario.UsuarioDTO;
import br.com.braferraz.inventario.dto.usuario.UsuarioMapper;
import br.com.braferraz.inventario.model.Usuario;
import br.com.braferraz.inventario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private final UsuarioRepository usuarioRepository;
    @Autowired
    private final UsuarioMapper usuarioMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    public UsuarioDTO criar(UsuarioCreateDTO dto) {
        Usuario usuario = usuarioMapper.toEntity(dto);
        Usuario salvo = usuarioRepository.save(usuario);
        return usuarioMapper.toDTO(salvo);
    }

    public List<UsuarioDTO> listarTodos(){
        return usuarioMapper.toDTOList(usuarioRepository.findAll());
    }

    public UsuarioDTO listarPorId(Long id){
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(("Usuário não encontrado")));
        return usuarioMapper.toDTO(usuario);
    }
    public UsuarioDTO atualizar(UsuarioCreateDTO dto, Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(("Usuário não encontrado")));
        usuario.setNome(dto.getNome());
        usuario.setRegional(dto.getRegional());
        usuario.setEmail(dto.getEmail());

        Usuario atualizado = usuarioRepository.save(usuario);

        return usuarioMapper.toDTO(atualizado);
    }

}
