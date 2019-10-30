package br.com.core.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.core.domains.Subcategory;

@Repository
public interface SubcategoryRepository extends MongoRepository<Subcategory, String>{

	// @Query("SELECT bean from Subcategory bean WHERE bean.category.id = :id")
	// List<Subcategory> subcategoriesWhereHasCategoryId(@Param("id") String id);

}