package br.com.wiki.services;

import java.util.List;

import br.com.core.domains.User;

public interface UserService {

	List<User> findAll();
	User save(User user);

}
