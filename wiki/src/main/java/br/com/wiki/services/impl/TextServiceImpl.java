package br.com.wiki.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.core.domains.Text;
import br.com.core.repositories.TextRepository;
import br.com.wiki.dtos.TextDTO;
import br.com.wiki.services.TextService;



@Service
public class TextServiceImpl implements TextService {

	@Autowired
	private TextRepository textRepository;
	
	@Override
	public Text save(TextDTO textDto) {
		Text text = TextDTO.fromEntity(textDto);
		return textRepository.save(text);
	}

}
