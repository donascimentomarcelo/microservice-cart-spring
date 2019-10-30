package br.com.wiki.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.core.domains.Subcategory;
import br.com.wiki.dtos.SubcategoryDTO;
import br.com.wiki.services.BaseService;
import br.com.wiki.services.SubcategoryService;

@RestController
@RequestMapping("/api/subcategories")
public class SubcategoryResource {
	
	@Autowired
	private SubcategoryService subcategoryService;
	
	@Autowired
	private BaseService baseService;

	@GetMapping
	public ResponseEntity<List<Subcategory>> list() {
		List<Subcategory> list = subcategoryService.all();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Void> create(@RequestBody SubcategoryDTO subcategoryDTO) {
		Subcategory subcategory = subcategoryService.associateWithCategory(subcategoryDTO);
		subcategory = subcategoryService.create(subcategory);
		URI uri = baseService.returnUri(subcategory.getId());
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody SubcategoryDTO subcategoryDTO, @PathVariable String id) {
		Subcategory subcategory = subcategoryService.associateWithCategory(subcategoryDTO);
		subcategoryService.update(subcategory, id);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		Subcategory subcategory = subcategoryService.find(id);
		subcategoryService.delete(subcategory);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Subcategory> find(@PathVariable String id) {
		Subcategory subcategory = subcategoryService.find(id);
		return ResponseEntity.ok(subcategory);
	}
	
	@GetMapping("/paginate")
	public ResponseEntity<Page<Subcategory>> paginate(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC")String direction){
		Page<Subcategory> subcategories = subcategoryService.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(subcategories);
	}
}
