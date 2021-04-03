package br.com.vuttr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.vuttr.domain.dto.ToolDTO;
import br.com.vuttr.service.ToolServices;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/tools")
public class ToolController {

	@Autowired
	ToolServices services;

	@ApiOperation(value = "Listar todas as ferramentas ou buscar por tag")
	@GetMapping
	public ResponseEntity<List<ToolDTO>> findAll(@RequestParam(value = "tag", required = false)  String tag) {
		List<ToolDTO> result = services.findAll(tag);
		if (result.isEmpty() || result == null) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(result);
	}
	
	//***Sugestão para completar as operções de um CRUD***
	@ApiOperation(value = "Alterar uma ferramenta pelo id")
	@PutMapping(value = "{id}")
	public ResponseEntity<ToolDTO> update(@PathVariable(name="id", required = true) Long id, 
			@RequestBody ToolDTO dto){
		dto.setId(id);
		ToolDTO tooldto = services.update(dto, id);
		return tooldto == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(tooldto);
	}
	
	@ApiOperation(value = "Cadasatrar uma ferramenta")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ToolDTO insert(@RequestBody ToolDTO tooldto) {
		return services.save(tooldto);
	}
	
	
	@ApiOperation(value = "Deletar uma ferramenta")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		services.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	

}