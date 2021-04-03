package br.com.vuttr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vuttr.domain.Tool;

public interface ToolRepository extends JpaRepository<Tool, Long>{
	
}
