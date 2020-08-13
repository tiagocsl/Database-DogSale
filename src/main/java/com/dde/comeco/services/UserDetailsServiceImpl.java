package com.dde.comeco.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dde.comeco.domain.Client;
import com.dde.comeco.repositories.ClientRepository;
import com.dde.comeco.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private ClientRepository clientReposit;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Client cli = clientReposit.findByEmail(email);
		if (cli == null) {
			throw new UsernameNotFoundException(email);
		}
		return new UserSS(cli.getId(), cli.getEmail(), cli.getPassword(), cli.getPerfis());
	}
}