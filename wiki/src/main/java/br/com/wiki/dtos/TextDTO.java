package br.com.wiki.dtos;

import br.com.core.domains.Text;

public class TextDTO {
	
	private String message;

	public TextDTO() {
	
	}
	
	public TextDTO(Text text) {
		this.message = text.getMessage();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static Text fromEntity(TextDTO textDto) {
		Text text = new Text();
		text.setMessage(textDto.getMessage());
		return text;
	}
}
