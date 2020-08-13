package com.dde.comeco.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dde.comeco.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
	
	

}
