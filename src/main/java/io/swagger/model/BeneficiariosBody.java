package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * BeneficiariosBody
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-02-08T13:56:34.956717658Z[GMT]")


public class BeneficiariosBody   {
	@JsonProperty("id")
	private Integer id;
	
	@JsonProperty("nome")
	private String nome;

	@JsonProperty("telefone")
	private String telefone;

	@JsonProperty("dataNascimento")
	private LocalDate dataNascimento;

	@JsonProperty("dataInclusao")
	private LocalDate dataInclusao;

	@JsonProperty("dataAtualizacao")
	private LocalDate dataAtualizacao;

	@JsonProperty("documentos")
	private List<BeneficiariosDocumentos> documentos;

	public BeneficiariosBody(Integer id, String nome, String telefone, 
			LocalDate dataNascimento, LocalDate dataInclusao,
			LocalDate dataAtualizacao, List<BeneficiariosDocumentos> documentos) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.dataInclusao = dataInclusao;
		this.dataAtualizacao = dataAtualizacao;
		this.documentos = documentos;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Get nome
	 * @return nome
	 **/
	@Schema(description = "")

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Get telefone
	 * @return telefone
	 **/
	@Schema(description = "")

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * Get dataNascimento
	 * @return dataNascimento
	 **/
	@Schema(description = "")

	@Valid
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public LocalDate getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(LocalDate dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public LocalDate getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDate dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	/**
	 * Get documentos
	 * @return documentos
	 **/
	@Schema(description = "")
	@Valid
	public List<BeneficiariosDocumentos> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<BeneficiariosDocumentos> documentos) {
		this.documentos = documentos;
	}


	@Override
	public int hashCode() {
		return Objects.hash(dataAtualizacao, dataInclusao, dataNascimento, documentos, id, nome, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BeneficiariosBody other = (BeneficiariosBody) obj;
		return Objects.equals(dataAtualizacao, other.dataAtualizacao)
				&& Objects.equals(dataInclusao, other.dataInclusao)
				&& Objects.equals(dataNascimento, other.dataNascimento) && Objects.equals(documentos, other.documentos)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(telefone, other.telefone);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class BeneficiariosBody {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
		sb.append("    telefone: ").append(toIndentedString(telefone)).append("\n");
		sb.append("    dataNascimento: ").append(toIndentedString(dataNascimento)).append("\n");
		sb.append("    dataInclusao: ").append(toIndentedString(dataInclusao)).append("\n");
		sb.append("    dataAtualizacao: ").append(toIndentedString(dataAtualizacao)).append("\n");
		sb.append("    documentos: ").append(toIndentedString(documentos)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
