package br.com.abertoagora.services;

import br.com.abertoagora.repository.ProprietarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProprietarioServices {

    private final ProprietarioRepository proprietarioRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProprietarioServices(ProprietarioRepository proprietarioRepository, ModelMapper modelMapper) {
        this.proprietarioRepository = proprietarioRepository;
        this.modelMapper = modelMapper;
    }
}
