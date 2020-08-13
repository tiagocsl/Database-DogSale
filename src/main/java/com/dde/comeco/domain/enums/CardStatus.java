package com.dde.comeco.domain.enums;

public enum CardStatus {

	ATIVO(1, "Ativo"),
	SEMSALDO(2, "Sem Saldo"),
	EXPIRADO(3, "Expirado");
	
	
	private int cod;
	private String description;
	
	private CardStatus(int cod, String description) {
		this.cod = cod;
		this.description = description;
		}
	
	public int getCod() {
		return cod;
	}
	
	public String getdescription() {
		return description;
	}
	
	public static CardStatus toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (CardStatus x : CardStatus.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
		
	}
	
	
}

