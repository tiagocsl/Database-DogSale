package com.dde.comeco.repositories;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.dde.comeco.domain.BankSlipPayment;


@Repository
public interface BankSlipRepository extends JpaRepository<BankSlipPayment, Integer> {

	

}
