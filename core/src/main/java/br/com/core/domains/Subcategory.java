package br.com.core.domains;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection="subcategory")
public class Subcategory extends ObjectBase implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String name;
	// @ManyToOne
	@JsonIgnore
	// @JoinColumn(name="category_id")
	private Category category;
	
	public Subcategory(String name, Category category) {
		super();
		this.name = name;
		this.category = category;
	}

	public Subcategory() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
}
