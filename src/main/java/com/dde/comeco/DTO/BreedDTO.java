package com.dde.comeco.DTO;

import java.io.Serializable;

import com.dde.comeco.domain.Breed;

public class BreedDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private Double price;

	
	public BreedDTO() {
	}
	
	
	public BreedDTO(Breed obj) {
		id = obj.getId();
		name = obj.getName();
		price = obj.getPrice();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	
}


