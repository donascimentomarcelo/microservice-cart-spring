package br.com.wiki.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.core.domains.Wiki;

public class WikiDTO {
	private String title;
	private List<TextDTO> texts = new ArrayList<>();

	public WikiDTO() {
		
	}

	public WikiDTO(Wiki wiki) {
		this.title = wiki.getTitle();
		this.texts = fromTextDTO(wiki);
	}

	private List<TextDTO> fromTextDTO(Wiki wiki) {
		return wiki.getTexts()
				.stream()
				.map(text -> new TextDTO(text))
				.collect(Collectors.toList());
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<TextDTO> getTexts() {
		return texts;
	}
	public void setTexts(List<TextDTO> texts) {
		this.texts = texts;
	}

	public static Wiki fromEntity(WikiDTO wikiDto) {
		return new Wiki(wikiDto.getTitle());
	}
}
