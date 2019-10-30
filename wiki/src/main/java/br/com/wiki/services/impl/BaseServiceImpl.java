package br.com.wiki.services.impl;

import java.net.URI;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.wiki.services.BaseService;


@Service
public class BaseServiceImpl implements BaseService {

	public URI returnUri(String id) {
		return ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(id).toUri();
	}
}
