package br.com.wiki.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.core.domains.Category;
import br.com.core.domains.Subcategory;
import br.com.core.repositories.CategoryRepository;
import br.com.wiki.exceptions.IntegrityViolationException;
import br.com.wiki.exceptions.ObjectNotFoundException;
import br.com.wiki.exceptions.UnprocessableEntityException;
import br.com.wiki.services.CategoryService;
import br.com.wiki.services.SubcategoryService;



@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository; 
	
	@Autowired
	private SubcategoryService subcategoryService;
	
	@Override
	public List<Category> all() {
		return categoryRepository.findAll();
	}

	@Override
	public Category save(Category category) {
		checkIfCategoryExists(category);
		return categoryRepository.save(category);
	}

	private void checkIfCategoryExists(Category category) {
		Category value = categoryRepository.findByName(category.getName());
		if (value != null) {
			throw new UnprocessableEntityException("Já existe uma categoria com essa descrição.");
		}
	}

	@Override
	public void update(Category category, String id) {
		checkIfCategoryExists(category);
		find(id);
		category.setId(id);
		categoryRepository.save(category);
	}
	
	@Override
	public Category find(String id) {
		Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada."));

		return category;
	}

	@Override
	public void delete(String id) {
		//checkIfHasSubcategory(id);
		Category category = find(id);
		categoryRepository.delete(category);
	}

	private void checkIfHasSubcategory(String id) {
		List<Subcategory> subcategories = subcategoryService.subcategoriesWhereHasCategoryId(id);
		if (subcategories.size() != 0) {
			throw new IntegrityViolationException("Essa categoria possui dependencias.");
		}
	}

	@Override
	public Page<Category> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		//PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		//return categoryRepository.findAll(pageRequest);
		return null;
	}

}
