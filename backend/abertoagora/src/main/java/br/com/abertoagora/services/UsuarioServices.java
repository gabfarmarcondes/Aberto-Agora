package br.com.abertoagora.services;

import br.com.abertoagora.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServices {
    private final UsuarioRepository usuarioRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public UsuarioServices(UsuarioRepository usuarioRepository, ModelMapper modelMapper) {
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
    }
}
