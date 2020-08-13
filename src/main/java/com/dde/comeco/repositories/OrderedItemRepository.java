package com.dde.comeco.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dde.comeco.domain.OrderedItem;

@Repository
public interface OrderedItemRepository extends JpaRepository<OrderedItem, Integer> {
		

}
