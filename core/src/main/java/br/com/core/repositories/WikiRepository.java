package br.com.core.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.core.domains.Wiki;

public interface WikiRepository extends MongoRepository<Wiki, String>{

}
