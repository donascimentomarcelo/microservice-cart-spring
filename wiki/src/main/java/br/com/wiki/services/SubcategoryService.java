package br.com.wiki.services;

import java.util.List;

import org.springframework.data.domain.Page;

import br.com.core.domains.Subcategory;
import br.com.wiki.dtos.SubcategoryDTO;

public interface SubcategoryService {

	List<Subcategory> all();
	Subcategory create(Subcategory subcategory);
	Subcategory associateWithCategory(SubcategoryDTO subcategoryDTO);
	void update(Subcategory subcategory, String id);
	Subcategory find(String id);
	void delete(Subcategory subcategory);
	List<Subcategory> subcategoriesWhereHasCategoryId(String id);
	Page<Subcategory> findPage(Integer page, Integer linesPerPage, String orderBy, String direction);

}
