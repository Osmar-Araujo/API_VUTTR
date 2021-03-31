package br.com.vuttr;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.vuttr.domain.dto.ToolDTO;
import br.com.vuttr.service.ToolServices;

@SpringBootTest
class VuttrApiApplicationTests {
	
	@Autowired
	private ToolServices services;
	
	/*
	 * Teste para verificação do funcionamento da funcionalidade de Cadastro de ferrmantas(Tool)
	 */
	@Test
	public void testeCadstroTool() {
		
		//*****Execução*****
		ToolDTO dto = services.save(this.carregarObjeto());
		ToolDTO dto2 = services.save(this.carregarObjeto());
		ToolDTO dto3 = services.save(this.carregarObjeto());
		
		//***Verificações***
		assertNotNull(dto);
		assertNotNull(dto2);
		assertNotNull(dto3);
		assertTrue(services.findAll().size() == 3);
		assertFalse(services.findAll().size() == 1);
		assertFalse(services.findAll().size() == 4);		
	}
		
	/*
	 * Teste para verificar o funcionamento da funcionalidade de deletar
	 */
	@Test
	public void testeDeletarTool() {
		
		//*****Execução*****
		services.delete(2L);
		
		//***Verificações***
		assertTrue(services.findAll().size() == 2);
		assertFalse(services.findAll().size() == 1);
		assertFalse(services.findAll().size() == 3);		
	}
	
	/*
	 * Teste para verificar a funcionalidade de Listar as Ferramentas(Tools)
	 */
	
	@Test
	public void testeListarTodasTools() {
				
		//*****Verificação*****
		assertFalse(services.findAll().size() == 1);
		assertFalse(services.findAll().size() == 3);
		
	}

	
	
	
	/*
	 * Método criado para carregar objetos para preparação do ambiente de teste 
	 */
	private ToolDTO carregarObjeto() {
		return ToolDTO.builder().title("Notion").link("https://notion.so").description("All in one tool to organize teams and ideas. Write, plan, collaborate, and get organized.").build();
	}
}
