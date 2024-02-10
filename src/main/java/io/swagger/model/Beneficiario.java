package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.model.Documento;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Beneficiario
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-02-08T13:56:34.956717658Z[GMT]")

@Entity
@Table(name = "beneficiarios")
public class Beneficiario   {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Integer id;

	@Column(name = "nome")
	@JsonProperty("nome")
	@NotBlank(message = "Nome inválido: nome vazio")
	@NotNull(message = "Nome inválido: nome nulo")
	private String nome;

	@Column(name = "telefone")
	@JsonProperty("telefone")
	@NotBlank(message = "Telefone inválido: telefone vazio")
	@NotNull(message = "Telefone inválido: telefone nulo")
	@Pattern(regexp = "\\([1-9]\\d\\)\\s9?\\d{4}-\\d{4}", message = "Número de telefone inválido")
	private String telefone;

	@Column(name = "data_nascimento")
	@JsonProperty("dataNascimento")
	@NotNull(message = "Data de nascimento inválida: data nula")
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dataNascimento;

	@Column(name = "data_inclusao")
	@JsonProperty("dataInclusao")
	@NotNull(message = "Data de inclusão de beneficiário inválida: data nula")
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dataInclusao;

	@Column(name = "data_atualizacao")
	@JsonProperty("dataAtualizacao")
	@NotNull(message = "Data de atualização de beneficiário inválida: data nula")
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dataAtualizacao;

	@OneToMany(mappedBy = "beneficiario", cascade = CascadeType.DETACH)
	@JsonProperty("documentos")
	@Valid
	private List<Documento> documentos;
	
	public Beneficiario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Beneficiario(
			@NotBlank(message = "Nome inválido: nome vazio") @NotNull(message = "Nome inválido: nome nulo") String nome,
			@NotBlank(message = "Telefone inválido: telefone vazio") @NotNull(message = "Telefone inválido: telefone nulo") @Pattern(regexp = "\\([1-9]\\d\\)\\s9?\\d{4}-\\d{4}", message = "Número de telefone inválido") String telefone,
			@NotBlank(message = "Data de nascimento inválida: data vazia") @NotNull(message = "Data de nascimento inválida: data nula") LocalDate dataNascimento,
			@NotBlank(message = "Data de inclusão de beneficiário inválida: data vazia") @NotNull(message = "Data de inclusão de beneficiário inválida: data nula") LocalDate dataInclusao,
			@NotBlank(message = "Data de atualização de beneficiário inválida: data vazia") @NotNull(message = "Data de atualização de beneficiário inválida: data nula") LocalDate dataAtualizacao,
			@Valid List<Documento> documentos) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.dataInclusao = dataInclusao;
		this.dataAtualizacao = dataAtualizacao;
		this.documentos = documentos;
		for (Documento documento : documentos) {
	        documento.setBeneficiario(this);
	    }
	}



	/**
	 * Get id
	 * @return id
	 **/
	@Schema(description = "")

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Beneficiario nome(String nome) {
		this.nome = nome;
		return this;
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

	public Beneficiario telefone(String telefone) {
		this.telefone = telefone;
		return this;
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

	public Beneficiario dataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
		return this;
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

	public Beneficiario dataInclusao(LocalDate dataInclusao) {
		this.dataInclusao = dataInclusao;
		return this;
	}

	/**
	 * Get dataInclusao
	 * @return dataInclusao
	 **/
	@Schema(description = "")

	@Valid
	public LocalDate getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(LocalDate dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public Beneficiario dataAtualizacao(LocalDate dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
		return this;
	}

	/**
	 * Get dataAtualizacao
	 * @return dataAtualizacao
	 **/
	@Schema(description = "")

	@Valid
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
	public List<Documento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}
	
	public void addDocumento(Documento documento) {
		documento.setBeneficiario(this);
		this.documentos.add(documento);
	}


	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Beneficiario beneficiario = (Beneficiario) o;
		return Objects.equals(this.id, beneficiario.id) &&
				Objects.equals(this.nome, beneficiario.nome) &&
				Objects.equals(this.telefone, beneficiario.telefone) &&
				Objects.equals(this.dataNascimento, beneficiario.dataNascimento) &&
				Objects.equals(this.dataInclusao, beneficiario.dataInclusao) &&
				Objects.equals(this.dataAtualizacao, beneficiario.dataAtualizacao) &&
				Objects.equals(this.documentos, beneficiario.documentos);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome, telefone, dataNascimento, dataInclusao, dataAtualizacao, documentos);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Beneficiario {\n");

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
