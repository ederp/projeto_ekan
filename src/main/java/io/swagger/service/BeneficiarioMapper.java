package io.swagger.service;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import io.swagger.model.Beneficiario;
import io.swagger.model.BeneficiariosBody;
import io.swagger.model.BeneficiariosDocumentos;
import io.swagger.model.Documento;

@Mapper
public interface BeneficiarioMapper {
	BeneficiarioMapper INSTANCE = Mappers.getMapper(BeneficiarioMapper.class);
	BeneficiariosBody toBeneficiariosBody(Beneficiario beneficiario);
	BeneficiariosDocumentos toBeneficiariosDocumentos(Documento doc);
}
