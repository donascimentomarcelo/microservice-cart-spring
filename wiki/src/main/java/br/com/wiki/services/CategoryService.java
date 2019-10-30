package br.com.wiki.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import br.com.core.domains.Category;

public interface CategoryService {

	List<Category> all();
	Category save(Category category);
	void update(Category category, String id);
	Category find(String id);
	void delete(String id);
	Page<Category> findPage(Integer page, Integer linesPerPage, String orderBy, String direction);
	
}
