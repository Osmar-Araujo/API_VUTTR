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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.vuttr.domain.dto.ToolDTO;
import br.com.vuttr.repository.ToolRepository;
import br.com.vuttr.service.ToolServices;

@RestController
@RequestMapping("/tools")
public class ToolController {
	
	@Autowired
	ToolServices services;
	
	@Autowired
	ToolRepository repository;
	    
	@GetMapping
	public List<ToolDTO> listar(){
		return services.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ToolDTO inserir(@RequestBody ToolDTO tooldto) {
		return services.save(tooldto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id){
		if (!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		services.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
