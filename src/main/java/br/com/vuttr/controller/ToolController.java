package br.com.vuttr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.vuttr.domain.dto.ToolDTO;
import br.com.vuttr.service.ToolServices;

@RestController
@RequestMapping("/tools")
public class ToolController {

	@Autowired
	ToolServices services;


	@GetMapping
	public ResponseEntity<List<ToolDTO>> listar(@RequestParam(value = "tag", required = false)  String tag) {
		List<ToolDTO> result = services.findAll(tag);
		if (result.isEmpty() || result == null) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(result);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ToolDTO inserir(@RequestBody ToolDTO tooldto) {
		return services.save(tooldto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {

		services.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	

}