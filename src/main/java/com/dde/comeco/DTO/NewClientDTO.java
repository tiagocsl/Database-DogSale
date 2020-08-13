package com.dde.comeco.DTO;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.dde.comeco.services.validation.InsertClient;

@InsertClient
public class NewClientDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 8, max = 120, message = "O tamanho deve ser entre 8 e 120 caracteres")
	private String name;

	@NotEmpty(message = "Preenchimento obrigatório")
	@Email(message = "Email inválido")
	private String email;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String CpfOrCnpj;

	private Integer type;

	@NotEmpty(message="Preenchimento obrigatório")
	private String password;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String street;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String number;

	private String complement;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String neighborhood;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String zipcode;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String tellphone1;

	private String tellphone2;

	private String tellphone3;

	private Integer CityID;

	public NewClientDTO() {
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

	public void setCpfOrCnpj(String cpfOrCnpj) {
		CpfOrCnpj = cpfOrCnpj;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getTellphone1() {
		return tellphone1;
	}

	public void setTellphone1(String tellphone1) {
		this.tellphone1 = tellphone1;
	}

	public String getTellphone2() {
		return tellphone2;
	}

	public void setTellphone2(String tellphone2) {
		this.tellphone2 = tellphone2;
	}

	public String getTellphone3() {
		return tellphone3;
	}

	public void setTellphone3(String tellphone3) {
		this.tellphone3 = tellphone3;
	}

	public Integer getCityID() {
		return CityID;
	}

	public void setCityID(Integer cityID) {
		CityID = cityID;
	}

}