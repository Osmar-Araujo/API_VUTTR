package br.com.vuttr.domain.dto;

import br.com.vuttr.domain.Tool;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ToolDTO {
	
	
	private Long id;
	private String title;
	private String link;
	private String description;	
	
    public ToolDTO(Long id, String title, String link, String description) {
    	this.id = id;
    	this.title = title;
    	this.link = link;
    	this.description = description;
    	
	}
    
    public ToolDTO(Tool entity) {
    	id = entity.getId();
    	title = entity.getTitle();
    	link = entity.getLink();
    	description = entity.getDescription();
    }
}
