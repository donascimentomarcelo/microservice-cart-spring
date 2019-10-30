package br.com.core.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.core.domains.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

	Optional<User> findByUsername(String username);

}
