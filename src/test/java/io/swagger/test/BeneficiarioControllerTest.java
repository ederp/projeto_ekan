package io.swagger.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.jayway.jsonpath.JsonPath;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BeneficiarioControllerTest {

	@Autowired
    private MockMvc mockMvc;
	
	private int beneficiarioId;
	
	@BeforeEach
    public void setup() throws Exception {
        // Adicione o beneficiário antes de cada teste
        String requestBody = "{\n" +
                "  \"nome\": \"José da Silva\",\n" +
                "  \"telefone\": \"(34) 99248-4600\",\n" +
                "  \"dataNascimento\": \"1988-01-01\",\n" +
                "  \"dataInclusao\": \"2023-12-12\",\n" +
                "  \"dataAtualizacao\": \"2023-11-04\",\n" +
                "  \"documentos\": [\n" +
                "    {\n" +
                "      \"tipoDocumento\": \"RG\",\n" +
                "      \"descricao\": \"RG\",\n" +
                "      \"dataInclusao\": \"2022-03-04\",\n" +
                "      \"dataAtualizacao\": \"2022-01-21\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/beneficiarios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nome").value("José da Silva"))
                .andReturn();

        // Extrai o ID do beneficiário adicionado antes de cada teste
        String content = result.getResponse().getContentAsString();
        beneficiarioId = JsonPath.parse(content).read("$.id", Integer.class);
    }
	
	@Test
    public void testAddBeneficiario() throws Exception {
        String requestBody = "{\n" +
                "  \"nome\": \"José da Silva\",\n" +
                "  \"telefone\": \"(34) 99248-4600\",\n" +
                "  \"dataNascimento\": \"1988-01-01\",\n" +
                "  \"dataInclusao\": \"2023-12-12\",\n" +
                "  \"dataAtualizacao\": \"2023-11-04\",\n" +
                "  \"documentos\": [\n" +
                "    {\n" +
                "      \"tipoDocumento\": \"RG\",\n" +
                "      \"descricao\": \"RG\",\n" +
                "      \"dataInclusao\": \"2022-03-04\",\n" +
                "      \"dataAtualizacao\": \"2022-01-21\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/beneficiarios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.nome").value("José da Silva"));
    }
	
	@Test
    public void testGetAllBeneficiarios() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/beneficiarios")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray());
    }
	
	@Test
    public void testGetDocumentosByBeneficiarioIdExistente() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/beneficiarios/" + beneficiarioId + "/documentos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").exists());
    }
	
	@Test
    public void testGetDocumentosByBeneficiarioIdInexistente() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/beneficiarios/2/documentos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
	
	@Test
	public void testUpdateBeneficiarioComSucesso() throws Exception {
	    // Execute o método setup para adicionar um beneficiário inicial
	    setup();

	    // JSON de atualização
	    String updateRequestBody = "{\n" +
	            "  \"nome\": \"Novo Nome\",\n" +
	            "  \"telefone\": \"(34) 99248-1234\",\n" +
	            "  \"dataNascimento\": \"1990-05-20\",\n" +
	            "  \"dataInclusao\": \"2023-12-12\",\n" +
	            "  \"dataAtualizacao\": \"2023-11-05\",\n" +
	            "  \"documentos\": [\n" +
	            "    {\n" +
	            "      \"tipoDocumento\": \"CPF\",\n" +
	            "      \"descricao\": \"Novo CPF\",\n" +
	            "      \"dataInclusao\": \"2022-03-05\",\n" +
	            "      \"dataAtualizacao\": \"2022-01-22\"\n" +
	            "    }\n" +
	            "  ]\n" +
	            "}";

	    mockMvc.perform(MockMvcRequestBuilders.put("/beneficiarios/{id}", beneficiarioId)
	            .contentType(MediaType.APPLICATION_JSON)
	            .content(updateRequestBody))
	            .andExpect(MockMvcResultMatchers.status().isOk())
	            .andExpect(MockMvcResultMatchers.jsonPath("$.nome").value("Novo Nome"))
	            .andExpect(MockMvcResultMatchers.jsonPath("$.telefone").value("(34) 99248-1234"))
	            .andExpect(MockMvcResultMatchers.jsonPath("$.documentos[0].tipoDocumento").value("CPF"))
	            .andExpect(MockMvcResultMatchers.jsonPath("$.documentos[0].descricao").value("Novo CPF"));
	}
	
	@Test
	public void testUpdateBeneficiarioInexistente() throws Exception {
	    // JSON de atualização
	    String updateRequestBody = "{\n" +
	            "  \"nome\": \"Novo Nome\",\n" +
	            "  \"telefone\": \"(34) 99248-1234\",\n" +
	            "  \"dataNascimento\": \"1990-05-20\",\n" +
	            "  \"dataInclusao\": \"2023-12-12\",\n" +
	            "  \"dataAtualizacao\": \"2023-11-05\",\n" +
	            "  \"documentos\": [\n" +
	            "    {\n" +
	            "      \"tipoDocumento\": \"CPF\",\n" +
	            "      \"descricao\": \"Novo CPF\",\n" +
	            "      \"dataInclusao\": \"2022-03-05\",\n" +
	            "      \"dataAtualizacao\": \"2022-01-22\"\n" +
	            "    }\n" +
	            "  ]\n" +
	            "}";

	    mockMvc.perform(MockMvcRequestBuilders.put("/beneficiarios/{id}", 9999)
	            .contentType(MediaType.APPLICATION_JSON)
	            .content(updateRequestBody))
	            .andExpect(MockMvcResultMatchers.status().isNotFound());
	}

	@Test
	public void testDeleteBeneficiarioExistente() throws Exception {
	    // Certifique-se de que beneficiarioId seja um ID existente no seu contexto
	    mockMvc.perform(MockMvcRequestBuilders.delete("/beneficiarios/{id}", beneficiarioId))
	            .andExpect(MockMvcResultMatchers.status().isNoContent());
	}

	@Test
	public void testDeleteBeneficiarioInexistente() throws Exception {
	    // Use um ID que não exista no seu contexto
	    mockMvc.perform(MockMvcRequestBuilders.delete("/beneficiarios/{id}", 9999))
	            .andExpect(MockMvcResultMatchers.status().isNotFound());
	}


}
