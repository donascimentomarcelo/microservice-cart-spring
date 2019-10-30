package br.com.wiki.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.core.domains.Category;
import br.com.core.domains.Subcategory;
import br.com.core.repositories.SubcategoryRepository;
import br.com.wiki.dtos.SubcategoryDTO;
import br.com.wiki.exceptions.ObjectNotFoundException;
import br.com.wiki.services.CategoryService;
import br.com.wiki.services.SubcategoryService;

@Service
public class SubcategoryServiceImpl implements SubcategoryService {

	@Autowired
	private SubcategoryRepository subcategoryRepository;
	
	@Autowired
	private CategoryService categoryService;
	
	@Override
	public List<Subcategory> all() {
		return subcategoryRepository.findAll();
	}

	@Override
	public Subcategory create(Subcategory subcategory) {
		return subcategoryRepository.save(subcategory);
	}

	@Override
	public Subcategory associateWithCategory(SubcategoryDTO subcategoryDTO) {
		Category category = categoryService.find(subcategoryDTO.getCategoryId());
		Subcategory subcategory = new Subcategory(subcategoryDTO.getName(), category);
		return subcategory;
	}

	@Override
	public void update(Subcategory subcategory, String id) {
		subcategory.setId(id);
		subcategoryRepository.save(subcategory);
	}

	@Override
	public Subcategory find(String id) {
		return subcategoryRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Subcategoria não encontrada."));
	}

	@Override
	public void delete(Subcategory subcategory) {
		subcategoryRepository.delete(subcategory);
	}

	@Override
	public List<Subcategory> subcategoriesWhereHasCategoryId(String id) {
//		return subcategoryRepository.subcategoriesWhereHasCategoryId(id);
		return null;
	}

	@Override
	public Page<Subcategory> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		//PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		//return subcategoryRepository.findAll(pageRequest);
		return null;
	}

}
