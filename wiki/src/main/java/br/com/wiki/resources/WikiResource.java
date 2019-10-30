package br.com.wiki.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.core.domains.Wiki;
import br.com.wiki.dtos.WikiDTO;
import br.com.wiki.services.WikiService;

@RestController
@RequestMapping("/api/wikis")
public class WikiResource {

	@Autowired
	private WikiService wikiService;
	
	@GetMapping
	public ResponseEntity<List<WikiDTO>> list() {
		List<Wiki> list = wikiService.list();
		List<WikiDTO> wikiDTO = list
				.stream()
				.map(wiki -> new WikiDTO(wiki))
				.collect(Collectors.toList());
		return ResponseEntity.ok(wikiDTO);
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody WikiDTO wikiDto) {
		Wiki wiki = wikiService.save(wikiDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(wiki.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
