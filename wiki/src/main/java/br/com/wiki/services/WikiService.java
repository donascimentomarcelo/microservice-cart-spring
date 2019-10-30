package br.com.wiki.services;

import java.util.List;

import br.com.core.domains.Wiki;
import br.com.wiki.dtos.WikiDTO;

public interface WikiService {

	List<Wiki> list();
	Wiki save(WikiDTO wikiDto);

}
