package br.com.abertoagora.repository;

import br.com.abertoagora.model.ADMIN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<ADMIN, Long> { }
