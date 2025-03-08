package br.com.abertoagora.services;

import br.com.abertoagora.repository.AdminRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AdminServices {

    private final AdminRepository adminRepository;
    private final ModelMapper modelMapper;

    public AdminServices(AdminRepository adminRepository, ModelMapper modelMapper) {
        this.adminRepository = adminRepository;
        this.modelMapper = modelMapper;
    }
}
