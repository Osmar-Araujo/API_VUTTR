package br.com.vuttr.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.vuttr.domain.dto.ToolDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tool {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	private String link;
	private String description;
	private String tags[];

	
	public Tool(ToolDTO tooldto) {
		this.id = tooldto.getId();
		this.title = tooldto.getTitle();
		this.link = tooldto.getLink();
		this.description = tooldto.getDescription();
		this.tags = tooldto.getTags();
	}
}
