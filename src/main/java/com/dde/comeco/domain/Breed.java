package com.dde.comeco.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Breed implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;
	private Double price;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "BREED_CLAZZ", joinColumns = @JoinColumn(name = "breed_id"), inverseJoinColumns = @JoinColumn(name = "clazz_id"))
	private List<Clazz> clazzes = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "breed")
	private Set<OrderedItem> itens = new HashSet<>();

	public Breed() {
	}

	public Breed(Integer id, String name, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	@JsonIgnore
	public List<PurchaseOrder> getOrsitens() {
		List<PurchaseOrder> list = new ArrayList<>();
		for (OrderedItem x : itens) {
			list.add(x.getOrsitens());
		}
		return list;
	}

	////////////////////////////////////// GETTER E SETTERS
	////////////////////////////////////// //////////////////////////////////////

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

	public List<Clazz> getClazzes() {
		return clazzes;
	}

	public void setClazzes(List<Clazz> clazzes) {
		this.clazzes = clazzes;
	}

	public Set<OrderedItem> getItens() {
		return itens;
	}

	public void setItens(Set<OrderedItem> itens) {
		this.itens = itens;
	}

	////////////////////////////////////// HASHCODE EQUALS
	////////////////////////////////////// //////////////////////////////////////

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Breed other = (Breed) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}