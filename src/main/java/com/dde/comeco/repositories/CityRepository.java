package com.dde.comeco.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dde.comeco.domain.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
	
	public List<City> findAllByName(String name);

}
