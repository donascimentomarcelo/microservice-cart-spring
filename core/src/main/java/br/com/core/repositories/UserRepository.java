package br.com.core.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.core.domains.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

	User findByUsername(String username);

}
