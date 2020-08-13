package com.dde.comeco.DTO;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.dde.comeco.domain.Clazz;

public class ClazzDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 3, max = 35, message = "O tamanho deve ser entre 3 a 35 caracteres")
	private String name;
	
	public ClazzDTO() {
	}

	public ClazzDTO(Clazz obj) {
		id = obj.getId();
		name = obj.getName();
		
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
	
	
	
	
	
}
