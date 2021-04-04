package br.com.vuttr;

import br.com.vuttr.domain.dto.ToolDTO;

	public class VuttrApiApplicationTests {
		
	
	
	/*
	 * Método criado para carregar objetos para preparação do ambiente de teste 
	 */
	private ToolDTO carregarObjeto() {
		String[]tags = { "organization","planning","collaboration","writing","calendar"};
		return ToolDTO.builder().
				title("Notion").
				link("https://notion.so").
				description("All in one tool to organize teams and ideas. Write, plan, collaborate, and get organized.").
				tags(tags).build();
	}
}
