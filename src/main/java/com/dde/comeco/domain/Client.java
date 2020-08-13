package com.dde.comeco.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.dde.comeco.domain.enums.ClientType;
import com.dde.comeco.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	@Column(unique = true)
	private String email;

	private String CpfOrCnpj;

	private Integer type;
	
	@JsonIgnore
	private String password;

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private List<Address> address = new ArrayList<>();

	@ElementCollection
	@CollectionTable(name = "TELLPHONE")
	private Set<String> tellphones = new HashSet<>();

	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="PERFIS")
	private Set<Integer> perfis = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "client")
	private List<PurchaseOrder> orders = new ArrayList<>();

	public Client() {
		addPerfil(Perfil.CLIENTE);
	}

	public Client(Integer id, String name, String email, String cpfOrCnpj, ClientType type, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.CpfOrCnpj = cpfOrCnpj;
		this.type = (type == null) ? null : type.getCod();
		this.password = password;
		addPerfil(Perfil.CLIENTE);
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfOrCnpj() {
		return CpfOrCnpj;
	}

	public void setCpfOrCnpj(String CpfOrCnpj) {
		this.CpfOrCnpj = CpfOrCnpj;
	}

	public ClientType getType() {
		return ClientType.toEnum(type);
	}

	public void setType(ClientType type) {
		this.type = type.getCod();
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCod());
	}
	
	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public Set<String> getTellPhones() {
		return tellphones;
	}

	public void setTellPhones(Set<String> tellphones) {
		this.tellphones = tellphones;
	}

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
		Client other = (Client) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public List<PurchaseOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<PurchaseOrder> orders) {
		this.orders = orders;
	}

}