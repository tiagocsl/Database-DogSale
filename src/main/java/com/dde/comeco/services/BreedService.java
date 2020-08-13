package com.dde.comeco.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.dde.comeco.domain.Breed;
import com.dde.comeco.domain.Clazz;
import com.dde.comeco.repositories.BreedRepository;
import com.dde.comeco.repositories.ClazzRepository;
import com.dde.comeco.services.exceptions.ObjectNotFoundException;



@Service
public class BreedService {

	@Autowired
	private BreedRepository breedReposit;

	@Autowired
	private ClazzRepository clazzRepository;

	public Breed find(Integer id) {
		Optional<Breed> obj = breedReposit.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Breed.class.getName()));
	}

	public Page<Breed> search(String name, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Clazz> clazz = clazzRepository.findAllById(ids);
		return breedReposit.findDistinctByNameContainingAndClazzesIn(name, clazz, pageRequest);	
	}
}