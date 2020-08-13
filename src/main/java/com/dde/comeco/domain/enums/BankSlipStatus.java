package com.dde.comeco.domain.enums;

public enum BankSlipStatus {

	PENDENTE(1, "Pendente"), EXPIRADO(2, "Expirado"), PAGO(3, "Pago");

	private int cod;
	private String description;

	private BankSlipStatus(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}

	public String getdescription() {
		return description;
	}

	public static BankSlipStatus toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (BankSlipStatus x : BankSlipStatus.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);

	}

}
