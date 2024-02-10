package io.swagger.service;

import java.util.ArrayList;
import java.util.List;

import io.swagger.model.Beneficiario;
import io.swagger.model.BeneficiariosBody;
import io.swagger.model.BeneficiariosDocumentos;
import io.swagger.model.Documento;

public class BeneficiarioMapperImpl implements BeneficiarioMapper {

	@Override
	public BeneficiariosBody toBeneficiariosBody(Beneficiario beneficiario) {
		// TODO Auto-generated method stub
		List<BeneficiariosDocumentos> bd = new ArrayList<>();
		for (Documento documento : beneficiario.getDocumentos()) {
			bd.add(this.toBeneficiariosDocumentos(documento));
		}
		return new BeneficiariosBody(beneficiario.getId(), 
				beneficiario.getNome(), 
				beneficiario.getTelefone(), 
				beneficiario.getDataNascimento(), 
				beneficiario.getDataInclusao(), 
				beneficiario.getDataAtualizacao(), 
				bd);
	}

	@Override
	public BeneficiariosDocumentos toBeneficiariosDocumentos(Documento doc) {
		// TODO Auto-generated method stub
		return new BeneficiariosDocumentos(doc.getId(), 
				doc.getTipoDocumento(), 
				doc.getDescricao(), 
				doc.getDataInclusao(), 
				doc.getDataAtualizacao());
	}

}
