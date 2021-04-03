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

	public List<ToolDTO> findAll(String tag) {
		if (tag == null) {
			return repository.findAll().stream().map(ToolDTO::new).collect(Collectors.toList());
		} else {
			return buscaTag(tag);

		}

	}

	public ToolDTO save(ToolDTO tooldto) {
		Tool tool = new Tool(tooldto);
		tool = repository.save(tool);
		return new ToolDTO(tool);

	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	private List<ToolDTO> buscaTag(String tag) {

		return repository.findAll().stream().filter(x -> {
			for (String t : x.getTags()) {
				if (t.equals(tag)) {
					return true;
				}
			}
			return false;
		}).map(ToolDTO::new).collect(Collectors.toList());

	}

}