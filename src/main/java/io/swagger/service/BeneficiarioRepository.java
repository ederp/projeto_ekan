package io.swagger.service;

import org.springframework.data.jpa.repository.JpaRepository;

import io.swagger.model.Beneficiario;

public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Integer> {

}
