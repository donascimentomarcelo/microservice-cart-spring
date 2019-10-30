package br.com.core.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.core.domains.Text;

public interface TextRepository extends MongoRepository<Text, String>{

}
