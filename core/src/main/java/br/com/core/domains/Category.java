package br.com.core.domains;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="category")
public class Category extends ObjectBase implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	// @OneToMany(mappedBy="category")
	@DBRef(lazy=true)
	private List<Subcategory> subcategories = new ArrayList<>();
	
	public Category(String name) {
		super();
		this.name = name;
	}
	
	public Category() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Subcategory> getSubcategories() {
		return subcategories;
	}
	public void setSubcategories(List<Subcategory> subcategories) {
		this.subcategories = subcategories;
	}
}
