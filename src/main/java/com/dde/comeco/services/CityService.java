package com.dde.comeco.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dde.comeco.domain.City;
import com.dde.comeco.repositories.CityRepository;

@Service
public class CityService {
	
	@Autowired
	private CityRepository CityReposit;

	public List<City> findByEstado(Integer stateId) {
		return repo.findCities(stateId);
	}
}
