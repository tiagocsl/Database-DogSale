package com.dde.comeco.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dde.comeco.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
	
	public List<Client> findAllByName(String name);
	
	@Transactional(readOnly=true)
	Client findByEmail(String email);

}
