package io.swagger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.model.Beneficiario;
import io.swagger.model.BeneficiariosBody;
import io.swagger.model.BeneficiariosDocumentos;
import io.swagger.model.Documento;

@Service
public class BeneficiarioService {

	@Autowired
	private BeneficiarioRepository beneficiarioRepository;
	
	@Autowired
	private DocumentoRepository documentoRepository;

	public BeneficiarioService(BeneficiarioRepository repository) {
		super();
		this.beneficiarioRepository = repository;
	}
	
	@Transactional
	public Beneficiario create(Beneficiario beneficiario) {
		Beneficiario beneficiarioSaida = this.beneficiarioRepository.save(beneficiario);
		List<Documento> listaDocumentos = beneficiarioSaida.getDocumentos();
		for (Documento documento : listaDocumentos) {
			documento.setBeneficiario(beneficiarioSaida);
		}
		this.documentoRepository.saveAll(listaDocumentos);
		return beneficiarioSaida;
	}
	
	public List<BeneficiariosBody> findAll(){
		List<Beneficiario> listaBeneficiarios = this.beneficiarioRepository.findAll();
		List<BeneficiariosBody> listaBeneficiariosSaida = new ArrayList<>();
		for (Beneficiario beneficiario : listaBeneficiarios) {
			listaBeneficiariosSaida.add(BeneficiarioMapper.INSTANCE.toBeneficiariosBody(beneficiario));
		}
		return listaBeneficiariosSaida;
	}
	
	
	private Optional<Beneficiario> findBeneficiarioById(Integer id) {
		return this.beneficiarioRepository.findById(id);
	}
	
	public List<BeneficiariosDocumentos> findDocumentosBeneficiarioById(Integer id) {
		List<Documento> listaDocumentos = new ArrayList<Documento>();
		List<BeneficiariosDocumentos> listaDocumentosSaida = new ArrayList<>();
		Optional<Beneficiario> optBeneficiario = this.findBeneficiarioById(id);
		if(! optBeneficiario.isEmpty()) {
			listaDocumentos.addAll(optBeneficiario.get().getDocumentos());
		}
		for (Documento doc : listaDocumentos) {
			listaDocumentosSaida.add(BeneficiarioMapper.INSTANCE.toBeneficiariosDocumentos(doc));
		}
		return listaDocumentosSaida;
	}
	
	@Transactional
	public Beneficiario update(Integer id, Beneficiario beneficiario) {
		Optional<Beneficiario> optBeneficiario = this.findBeneficiarioById(id);
		if(! optBeneficiario.isEmpty()) {
			Beneficiario beneficiarioUpdate = optBeneficiario.get();
			
			beneficiarioUpdate.setNome(beneficiario.getNome());
			beneficiarioUpdate.setTelefone(beneficiario.getTelefone());
			beneficiarioUpdate.setDataNascimento(beneficiario.getDataNascimento());
			beneficiarioUpdate.setDataInclusao(beneficiario.getDataInclusao());
			beneficiarioUpdate.setDataAtualizacao(beneficiario.getDataAtualizacao());
			
			Beneficiario beneficiarioSaida = this.beneficiarioRepository.save(beneficiarioUpdate);
			
			List<Documento> listaDocumentos = beneficiarioSaida.getDocumentos();
			listaDocumentos.removeAll(listaDocumentos);
			listaDocumentos.addAll(beneficiario.getDocumentos());
			this.documentoRepository.saveAll(listaDocumentos);
			
			return beneficiarioSaida;

		}
		return null;
	}
	
	@Transactional
	public boolean removeById(Integer id) {
		Optional<Beneficiario> optBeneficiario = this.findBeneficiarioById(id);
		if(! optBeneficiario.isEmpty()) {
			for (Documento doc : optBeneficiario.get().getDocumentos()) {
				this.documentoRepository.delete(doc);
			}
			this.beneficiarioRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
}
