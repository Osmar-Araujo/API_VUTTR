package br.com.vuttr.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vuttr.domain.Tool;
import br.com.vuttr.domain.dto.ToolDTO;
import br.com.vuttr.repository.ToolRepository;

@Service
public class ToolServices {
	
	@Autowired
	ToolRepository repository;
	
	public List<ToolDTO> findAll(){
		List<Tool> listarTools = repository.findAll();
				
		return listarTools.stream().map(x -> new ToolDTO(x)).collect(Collectors.toList());
	}
	
	public ToolDTO save(ToolDTO tooldto) {
		Tool tool = new Tool(tooldto); 
		tool = repository.save(tool);
		return new ToolDTO(tool);
		 
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}

