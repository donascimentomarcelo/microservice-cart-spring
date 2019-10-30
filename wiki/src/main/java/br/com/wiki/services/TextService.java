package br.com.wiki.services;

import br.com.core.domains.Text;
import br.com.wiki.dtos.TextDTO;

public interface TextService {

	Text save(TextDTO text);

}
