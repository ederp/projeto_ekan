package io.swagger.model;

import java.time.LocalDate;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;


/**
 * BeneficiariosDocumentos
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-02-08T13:56:34.956717658Z[GMT]")


public class BeneficiariosDocumentos   {
	@JsonProperty("id")
	private Integer id;
	
	@JsonProperty("tipoDocumento")
	private String tipoDocumento;

	@JsonProperty("descricao")
	private String descricao;

	@JsonProperty("dataInclusao")
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dataInclusao;

	@JsonProperty("dataAtualizacao")
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dataAtualizacao;
	
	public BeneficiariosDocumentos(Integer id, String tipoDocumento, String descricao, LocalDate dataInclusao,
			LocalDate dataAtualizacao) {
		super();
		this.id = id;
		this.tipoDocumento = tipoDocumento;
		this.descricao = descricao;
		this.dataInclusao = dataInclusao;
		this.dataAtualizacao = dataAtualizacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		return Objects.hash(dataAtualizacao, dataInclusao, descricao, id, tipoDocumento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BeneficiariosDocumentos other = (BeneficiariosDocumentos) obj;
		return Objects.equals(dataAtualizacao, other.dataAtualizacao)
				&& Objects.equals(dataInclusao, other.dataInclusao) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(id, other.id) && Objects.equals(tipoDocumento, other.tipoDocumento);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class BeneficiariosDocumentos {\n");

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
