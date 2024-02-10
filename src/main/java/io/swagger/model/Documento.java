package io.swagger.model;

import java.time.LocalDate;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Documento
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-02-08T13:56:34.956717658Z[GMT]")

@Entity
@Table(name = "documentos")
public class Documento   {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Integer id;

	@Column(name = "tipo_documento")
	@JsonProperty("tipoDocumento")
	@NotBlank(message = "Tipo de documento inválido: tipo vazio")
	@NotNull(message = "Tipo de documento inválido: tipo nulo")
	private String tipoDocumento;

	@Column(name = "descricao")
	@JsonProperty("descricao")
	@NotBlank(message = "Descrição inválida: descrição vazia")
	@NotNull(message = "Descrição inválida: descrição nula")
	private String descricao;

	@Column(name = "data_inclusao")
	@JsonProperty("dataInclusao")
    @NotNull(message = "Data de inclusão inválida: data nula")
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dataInclusao;

	@Column(name = "data_atualizacao")
	@JsonProperty("dataAtualizacao")
    @NotNull(message = "Data de atualização de documento inválida: data nula")
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dataAtualizacao;
	
	@ManyToOne
    @JoinColumn(name = "beneficiario_id", nullable = false)
	@JsonIgnore
    private Beneficiario beneficiario;
		
	public Documento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Documento(
			@NotBlank(message = "Tipo de documento inválido: tipo vazio") @NotNull(message = "Tipo de documento inválido: tipo nulo") String tipoDocumento,
			@NotBlank(message = "Descrição inválida: descrição vazia") @NotNull(message = "Descrição inválida: descrição nula") String descricao,
			@NotNull(message = "Data de inclusão inválida: data nula") LocalDate dataInclusao,
			@NotNull(message = "Data de atualização de documento inválida: data nula") LocalDate dataAtualizacao,
			Beneficiario beneficiario) {
		super();
		this.tipoDocumento = tipoDocumento;
		this.descricao = descricao;
		this.dataInclusao = dataInclusao;
		this.dataAtualizacao = dataAtualizacao;
		this.beneficiario = beneficiario;
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

	public Documento tipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
		return this;
	}

	/**
	 * Get tipoDocumento
	 * @return tipoDocumento
	 **/
	@Schema(description = "")

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Documento descricao(String descricao) {
		this.descricao = descricao;
		return this;
	}

	/**
	 * Get descricao
	 * @return descricao
	 **/
	@Schema(description = "")

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Documento dataInclusao(LocalDate dataInclusao) {
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

	public Documento dataAtualizacao(LocalDate dataAtualizacao) {
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

	public void setBeneficiario(Beneficiario beneficiario) {
		this.beneficiario = beneficiario;
	}

	public Beneficiario getBeneficiario() {
		return beneficiario;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Documento documento = (Documento) o;
		return Objects.equals(this.id, documento.id) &&
				Objects.equals(this.tipoDocumento, documento.tipoDocumento) &&
				Objects.equals(this.descricao, documento.descricao) &&
				Objects.equals(this.dataInclusao, documento.dataInclusao) &&
				Objects.equals(this.dataAtualizacao, documento.dataAtualizacao) &&
				Objects.equals(this.beneficiario, documento.beneficiario);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, tipoDocumento, descricao, dataInclusao, dataAtualizacao, beneficiario);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Documento {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    tipoDocumento: ").append(toIndentedString(tipoDocumento)).append("\n");
		sb.append("    descricao: ").append(toIndentedString(descricao)).append("\n");
		sb.append("    dataInclusao: ").append(toIndentedString(dataInclusao)).append("\n");
		sb.append("    dataAtualizacao: ").append(toIndentedString(dataAtualizacao)).append("\n");
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
