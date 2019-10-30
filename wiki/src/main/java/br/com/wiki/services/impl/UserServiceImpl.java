package br.com.wiki.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.core.domains.Address;
import br.com.core.domains.Client;
import br.com.core.domains.User;
import br.com.core.repositories.UserRepository;
import br.com.wiki.exceptions.UnprocessableEntityException;
import br.com.wiki.services.AddressService;
import br.com.wiki.services.ClientService;
import br.com.wiki.services.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ClientService clientService;

	@Autowired
	private AddressService addressService;

	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	@Transactional(readOnly=false)
	public User save(User user) {
		checkIfUserExists(user.getUsername());
	
		List<Address> listAddress = new ArrayList<>();
		Client client = user.getClient();
		
		addressService.save(user, listAddress);
		clientService.save(user, listAddress, client);
		
		user.setClient(client);
		
		User newUser = userRepository.save(user);
		return newUser;
	}




	
	public void checkIfUserExists(String username) {
		Optional<User> user = userRepository.findByUsername(username);
		
		if(user.isPresent()) {
			throw new UnprocessableEntityException("Já existe um usuário com esse login.");
		}
	}
	

}
