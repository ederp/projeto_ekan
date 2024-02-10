package io.swagger.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.swagger.model.Documento;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Integer> {

}
