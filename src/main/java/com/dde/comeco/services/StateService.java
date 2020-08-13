package com.dde.comeco.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dde.comeco.domain.State;
import com.dde.comeco.repositories.StateRepository;

@Service
public class StateService {
	
	@Autowired
	private StateRepository repo;
	
	public List<State> findAll() {
		return repo.findAllByOrderByNome();
	}
}
