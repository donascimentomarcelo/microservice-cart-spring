package br.com.wiki.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.core.domains.Address;
import br.com.core.domains.User;
import br.com.core.repositories.AddressRepository;
import br.com.wiki.services.AddressService;


@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public void save(User user, List<Address> listAddress) {
		for(Address address: user.getClient().getAddress()) {
			listAddress.add(address);
		}
		addressRepository.saveAll(listAddress);
	}
}
