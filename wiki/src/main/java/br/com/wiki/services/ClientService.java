package br.com.wiki.services;

import java.util.List;

import br.com.core.domains.Address;
import br.com.core.domains.Client;
import br.com.core.domains.User;

public interface ClientService {
	void save(User user, List<Address> listAddress, Client client);
}
