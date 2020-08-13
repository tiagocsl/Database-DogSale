package com.dde.comeco.DTO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.dde.comeco.domain.Breed;
import com.dde.comeco.domain.PurchaseOrder;

public class NewPurchaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Double discount;

	private Integer amount;

	private Double price;

	@Column(updatable = false)
	private Integer gender;

	@ManyToOne
	@JoinColumn(name = "Purchase_Order_id")
	private PurchaseOrder orsitens;

	@ManyToOne
	@JoinColumn(name = "Breed_id")
	private Breed breed;
	
	
}
