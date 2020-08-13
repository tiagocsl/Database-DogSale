package com.dde.comeco.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dde.comeco.domain.Clazz;

@Repository
public interface ClazzRepository extends JpaRepository<Clazz, Integer> {
	
	public List<Clazz> findAllByName(String name);

}
