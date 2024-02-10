package io.swagger.api;

import io.swagger.model.Beneficiario;
import io.swagger.model.BeneficiariosBody;
import io.swagger.model.BeneficiariosDocumentos;
import io.swagger.service.BeneficiarioService;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-02-08T13:56:34.956717658Z[GMT]")
@RestController
public class BeneficiariosApiController implements BeneficiariosApi {

    private static final Logger log = LoggerFactory.getLogger(BeneficiariosApiController.class);
    
    @Autowired
    private BeneficiarioService beneficiarioService;

    public BeneficiariosApiController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponseEntity<Void> beneficiarioIdDelete(@Parameter(in = ParameterIn.PATH, description = "ID do beneficiário", required=true, schema=@Schema()) @PathVariable("beneficiarioId") Integer beneficiarioId
) {
        HttpStatus httpStatus = (this.beneficiarioService.removeById(beneficiarioId)) ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;
        return ResponseEntity.status(httpStatus).build();
    }

    public ResponseEntity<List<BeneficiariosDocumentos>> beneficiarioIdDocumentosGet(@Parameter(in = ParameterIn.PATH, description = "ID do beneficiário", required=true, schema=@Schema()) @PathVariable("beneficiarioId") Integer beneficiarioId
) {
        List<BeneficiariosDocumentos> listaDocumentos = this.beneficiarioService
        		.findDocumentosBeneficiarioById(beneficiarioId);
        HttpStatus httpStatus = (listaDocumentos.isEmpty()) ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        return ResponseEntity.status(httpStatus).body(listaDocumentos);
    }

    public ResponseEntity<Beneficiario> beneficiarioIdPut(@Parameter(in = ParameterIn.PATH, description = "ID do beneficiário", required=true, schema=@Schema()) @PathVariable("beneficiarioId") Integer beneficiarioId
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Beneficiario body
) {
        Beneficiario beneficiario = this.beneficiarioService.update(beneficiarioId, body);
        HttpStatus httpStatus = (beneficiario == null) ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        return ResponseEntity.status(httpStatus).body(beneficiario);
    }

    public ResponseEntity<List<BeneficiariosBody>> beneficiariosGet() {
    	List<BeneficiariosBody> listaBeneficiarios = this.beneficiarioService.findAll();
    	HttpStatus httpStatus = (listaBeneficiarios.isEmpty()) ? HttpStatus.NOT_FOUND : HttpStatus.OK; 
        return ResponseEntity.status(httpStatus).body(listaBeneficiarios);
    }

    public ResponseEntity<BeneficiariosBody> beneficiarioPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody Beneficiario body
) {
        return ResponseEntity
        		.status(HttpStatus.CREATED)
        		.body(this.beneficiarioService.create(body));
    }

}
