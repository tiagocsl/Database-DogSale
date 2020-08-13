package com.dde.comeco.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.dde.comeco.domain.Payment;


@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
	
	
}
