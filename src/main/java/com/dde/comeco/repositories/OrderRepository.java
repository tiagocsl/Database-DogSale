package com.dde.comeco.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dde.comeco.domain.Client;
import com.dde.comeco.domain.PurchaseOrder;

@Repository
public interface OrderRepository extends JpaRepository<PurchaseOrder, Integer> {
		
	@Transactional(readOnly=true)
	Page<PurchaseOrder> findByClient(Client client, Pageable pageRequest);

}
