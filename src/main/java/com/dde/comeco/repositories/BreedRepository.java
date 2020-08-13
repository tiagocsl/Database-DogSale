package com.dde.comeco.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dde.comeco.domain.Breed;
import com.dde.comeco.domain.Clazz;

@Repository
public interface BreedRepository extends JpaRepository<Breed, Integer> {

	public List<Breed> findAllByName(String name);

	@Transactional(readOnly = true)
	Page<Breed> findDistinctByNameContainingAndClazzesIn(String name, List<Clazz> clazzes, Pageable pageRequest);

	/*
	 * Outra forma de utilizar:
	 * 
	 * @Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.clazz cat WHERE obj.name LIKE %:name% AND cat IN :clazz"
	 * ) Page<Breed> search(
	 * 
	 * @Param("name") String name, @Param("clazz") List<Clazz> clazz, Pageable
	 * pageRequest);
	 */

}