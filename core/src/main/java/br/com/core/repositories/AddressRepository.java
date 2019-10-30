package br.com.core.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.core.domains.Address;


@Repository
public interface AddressRepository extends MongoRepository<Address, String>{

}
