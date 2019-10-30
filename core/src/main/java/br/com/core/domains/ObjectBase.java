package br.com.core.domains;

import org.springframework.data.annotation.Id;

public abstract class ObjectBase {

	@Id
	protected String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
