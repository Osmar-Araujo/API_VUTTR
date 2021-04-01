package br.com.vuttr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vuttr.domain.Tool;
import br.com.vuttr.domain.dto.ToolDTO;

public interface ToolRepository extends JpaRepository<Tool, Long>{

	Iterable<ToolDTO> findByTags(String tags);
	
}
