package br.com.vuttr.domain.dto;

import br.com.vuttr.domain.Tool;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class ToolDTO {
	
	
	private Long id;
	private String title;
	private String link;
	private String description;
	public String tags[];
	
	
    public ToolDTO(Long id, String title, String link, String description, String tags[]) {
    	this.id = id;
    	this.title = title;
    	this.link = link;
    	this.description = description;
    	this.tags = tags;
    	
	}
    
    public ToolDTO(Tool entity) {
    	id = entity.getId();
    	title = entity.getTitle();
    	link = entity.getLink();
    	description = entity.getDescription();
    	tags = entity.getTags();
    }
}
