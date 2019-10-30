package br.com.core.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.core.domains.Client;

@Repository
public interface ClientRepository extends MongoRepository<Client, String>{

}
