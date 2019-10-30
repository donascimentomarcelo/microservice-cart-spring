package br.com.wiki.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.core.domains.Text;
import br.com.core.domains.Wiki;
import br.com.core.repositories.WikiRepository;
import br.com.wiki.dtos.WikiDTO;
import br.com.wiki.services.TextService;
import br.com.wiki.services.WikiService;

@Service
public class WikiServiceImpl implements WikiService {

	@Autowired
	private WikiRepository wikiRepository;
	
	@Autowired
	private TextService textService;
	
	@Override
	public List<Wiki> list() {
		return wikiRepository.findAll();
	}

	@Override
	public Wiki save(WikiDTO wikiDto) {
		List<Text> textList = new ArrayList<>();
		associatingTextToList(wikiDto, textList);
		Wiki wiki = WikiDTO.fromEntity(wikiDto);
		wiki.getTexts()
			.addAll(textList);
		return wikiRepository.save(wiki);
	}

	private void associatingTextToList(WikiDTO wikiDto, List<Text> textList) {
		wikiDto.getTexts()
			.stream()
			.forEach(text -> {
				Text newText = textService.save(text);
				textList.add(newText);
			});
	}

}
