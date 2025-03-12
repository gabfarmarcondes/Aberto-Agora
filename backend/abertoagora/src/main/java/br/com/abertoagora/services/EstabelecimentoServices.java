package br.com.abertoagora.services;

import br.com.abertoagora.repository.elastic.EstabelecimentoElasticRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstabelecimentoServices {

    private final EstabelecimentoElasticRepository estabelecimentoElasticRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public EstabelecimentoServices(EstabelecimentoElasticRepository estabelecimentoElasticRepository, ModelMapper modelMapper) {
        this.estabelecimentoElasticRepository = estabelecimentoElasticRepository;
        this.modelMapper = modelMapper;
    }
}
