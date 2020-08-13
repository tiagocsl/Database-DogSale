package com.dde.comeco.domain.enums;

public enum PaymentType {
	
	CARD(1, "Cartão de Crédito"),
	BANKSLIP(2, "Boleto Bancário");
		
	private int cod;
	private String description;
	
	private PaymentType(int cod, String description) {
		this.cod = cod;
		this.description = description;
		}
	
	public int getCod() {
		return cod;
	}
	
	public String getdescription() {
		return description;
	}
	
	public static PaymentType toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (PaymentType x : PaymentType.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
		
	}
	
	
}

