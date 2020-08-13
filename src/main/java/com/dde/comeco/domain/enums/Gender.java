package com.dde.comeco.domain.enums;

public enum Gender {

	MALE(0, "Male"), FEMALE(1, "Female");

	private int cod;
	private String description;

	private Gender(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}

	public String getdescription() {
		return description;
	}

	public static Gender toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (Gender x : Gender.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);

	}

}
