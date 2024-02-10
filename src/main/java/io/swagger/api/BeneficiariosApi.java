/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.52).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Beneficiario;
import io.swagger.model.BeneficiariosBody;
import io.swagger.model.BeneficiariosDocumentos;
import io.swagger.model.Documento;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-02-08T13:56:34.956717658Z[GMT]")
@Validated
public interface BeneficiariosApi {

    @Operation(summary = "Remover um beneficiário", description = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "Beneficiário removido com sucesso"),
        
        @ApiResponse(responseCode = "404", description = "Beneficiário não encontrado") })
    @DeleteMapping(value = "/beneficiarios/{beneficiarioId}")
    ResponseEntity<Void> beneficiarioIdDelete(@Parameter(in = ParameterIn.PATH, description = "ID do beneficiário", required=true, schema=@Schema()) @PathVariable("beneficiarioId") Integer beneficiarioId
);


    @Operation(summary = "Listar todos os documentos de um beneficiário", description = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Lista de documentos do beneficiário", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Documento.class)))),
        
        @ApiResponse(responseCode = "404", description = "Beneficiário não encontrado") })
    @GetMapping(value = "/beneficiarios/{beneficiarioId}/documentos",
        produces = { "application/json" })
    ResponseEntity<List<BeneficiariosDocumentos>> beneficiarioIdDocumentosGet(@Parameter(in = ParameterIn.PATH, description = "ID do beneficiário", required=true, schema=@Schema()) @PathVariable("beneficiarioId") Integer beneficiarioId
);


    @Operation(summary = "Atualizar os dados cadastrais de um beneficiário", description = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Beneficiário atualizado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Beneficiario.class))),
        
        @ApiResponse(responseCode = "400", description = "Erro nos dados fornecidos"),
        
        @ApiResponse(responseCode = "404", description = "Beneficiário não encontrado") })
    @PutMapping(value = "/beneficiarios/{beneficiarioId}",
        produces = { "application/json" }, 
        consumes = { "application/json" })
    ResponseEntity<Beneficiario> beneficiarioIdPut(@Parameter(in = ParameterIn.PATH, description = "ID do beneficiário", required=true, schema=@Schema()) @PathVariable("beneficiarioId") Integer beneficiarioId
, @Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Beneficiario body
);


    @Operation(summary = "Listar todos os beneficiários cadastrados", description = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Lista de beneficiários", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Beneficiario.class)))),
        
        @ApiResponse(responseCode = "404", description = "Nenhum beneficiário encontrado") })
    @GetMapping(value = "/beneficiarios",
        produces = { "application/json" })
    ResponseEntity<List<BeneficiariosBody>> beneficiariosGet();


    @Operation(summary = "Cadastrar um beneficiário junto com seus documentos", description = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Beneficiário cadastrado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Beneficiario.class))),
        
        @ApiResponse(responseCode = "400", description = "Erro nos dados fornecidos") })
    @PostMapping(value = "/beneficiarios",
        produces = { "application/json" }, 
        consumes = { "application/json" })
    ResponseEntity<Beneficiario> beneficiarioPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Beneficiario body
);

}

