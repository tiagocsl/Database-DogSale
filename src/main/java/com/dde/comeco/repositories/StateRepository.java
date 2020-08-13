package com.dde.comeco.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dde.comeco.domain.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {
	
	public List<State> findAllByName(String name);

}
