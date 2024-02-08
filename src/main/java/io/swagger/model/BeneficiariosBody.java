package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.BeneficiariosDocumentos;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * BeneficiariosBody
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-02-08T13:56:34.956717658Z[GMT]")


public class BeneficiariosBody   {
  @JsonProperty("nome")
  private String nome = null;

  @JsonProperty("telefone")
  private String telefone = null;

  @JsonProperty("dataNascimento")
  private LocalDate dataNascimento = null;

  @JsonProperty("documentos")
  @Valid
  private List<BeneficiariosDocumentos> documentos = null;

  public BeneficiariosBody nome(String nome) {
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

  public BeneficiariosBody telefone(String telefone) {
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

  public BeneficiariosBody dataNascimento(LocalDate dataNascimento) {
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

  public BeneficiariosBody documentos(List<BeneficiariosDocumentos> documentos) {
    this.documentos = documentos;
    return this;
  }

  public BeneficiariosBody addDocumentosItem(BeneficiariosDocumentos documentosItem) {
    if (this.documentos == null) {
      this.documentos = new ArrayList<BeneficiariosDocumentos>();
    }
    this.documentos.add(documentosItem);
    return this;
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
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BeneficiariosBody beneficiariosBody = (BeneficiariosBody) o;
    return Objects.equals(this.nome, beneficiariosBody.nome) &&
        Objects.equals(this.telefone, beneficiariosBody.telefone) &&
        Objects.equals(this.dataNascimento, beneficiariosBody.dataNascimento) &&
        Objects.equals(this.documentos, beneficiariosBody.documentos);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nome, telefone, dataNascimento, documentos);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BeneficiariosBody {\n");
    
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    telefone: ").append(toIndentedString(telefone)).append("\n");
    sb.append("    dataNascimento: ").append(toIndentedString(dataNascimento)).append("\n");
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
