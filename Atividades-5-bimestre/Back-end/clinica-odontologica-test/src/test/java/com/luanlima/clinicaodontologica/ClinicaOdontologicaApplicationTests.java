package com.luanlima.clinicaodontologica;
import com.luanlima.clinicaodontologica.domain.entity.Service.ImplementsService.ClinicaOdontologicaService;
import com.luanlima.clinicaodontologica.domain.entity.Service.ImplementsService.PacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
class ClinicaOdontologicaApplicationTests {

	@Autowired
	private MockMvc mvc;
	@Autowired
	private ObjectMapper mapper;
	@MockBean
	private PacienteService pacienteService;
	private ClinicaOdontologicaService clinicaOdontologicaService;

	@Test
	void contextLoads() {
		Assertions.assertNotNull(mvc);
	}

	@Test
	public void addPatientTest() throws Exception {
		String json = "{\n" +
				"  \"nome\": \"Teste Paciente\",\n" +
				"  \"dataNascimento\": \"2000-01-01\",\n" +
				"  \"sexo\": \"F\",\n" +
				"  \"contatoId\": 1,\n" +
				"  \"enderecoId\": 2\n" +
				"}";


		this.mvc.perform(MockMvcRequestBuilders.post("/v1/pacientes")
						.contentType(MediaType.APPLICATION_JSON)
						.content(json))
				.andExpect(status().isCreated());
	}

	@Test
	public void getAllPatientTest() throws Exception {
		this.mvc.perform(MockMvcRequestBuilders.get("/v1/pacientes"))
				.andExpect(status().isOk());
	}


	@Test
	public void addClinicTest() throws Exception {
		String json = "{\n" +
				"  \"nome\": \"Clínica Dentária do Dogra\",\n" +
				"  \"cnpj\": \"006543210977\",\n" +
				"  \"razaoSocial\": \"Razão Social da Clínica ABC\",\n" +
				"  \"descricao\": \"Clinica legal\",\n" +
				"  \"endereco\": {\n" +
				"    \"logradouro\": \"Avenida Principal, 456\",\n" +
				"    \"bairro\": \"Bairro Central\",\n" +
				"    \"cidade\": \"Sumaré\",\n" +
				"    \"estado\": \"SP\",\n" +
				"    \"cep\": \"54321-987\"\n" +
				"  },\n" +
				"  \"contato\": {\n" +
				"    \"email\": \"contato@clinicabcd.com\",\n" +
				"    \"telefone\": \"(22) 9876-5432\"\n" +
				"  }\n" +
				"}";


		this.mvc.perform(MockMvcRequestBuilders.post("/v1/clinicas")
						.contentType(MediaType.APPLICATION_JSON)
						.content(json))
				.andExpect(status().isCreated());
	}

	@Test
	public void getAllClinicTest() throws Exception {
		this.mvc.perform(MockMvcRequestBuilders.get("/v1/clinicas"))
				.andExpect(status().isOk());
	}
}


