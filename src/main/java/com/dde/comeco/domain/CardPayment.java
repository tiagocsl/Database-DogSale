package com.dde.comeco.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.dde.comeco.domain.enums.CardStatus;

@Entity
public class CardPayment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer cstatus;

	private Integer numberOfInstallments;

	@OneToOne(mappedBy = "cpayment")
	private Payment payment;

	public CardPayment() {

	}

	public CardPayment(Integer id, CardStatus cstatus, Integer numberOfInstallments) {
		super();
		this.id = id;
		this.cstatus = (cstatus == null) ? null : cstatus.getCod();
		this.numberOfInstallments = numberOfInstallments;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CardStatus getCtatus() {
		return CardStatus.toEnum(cstatus);
	}

	public void setCstatus(CardStatus cstatus) {
		this.cstatus = cstatus.getCod();
	}

	public Integer getNumberOfInstallments() {
		return numberOfInstallments;
	}

	public void setNumberOfInstallments(Integer numberOfInstallments) {
		this.numberOfInstallments = numberOfInstallments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cstatus == null) ? 0 : cstatus.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numberOfInstallments == null) ? 0 : numberOfInstallments.hashCode());
		result = prime * result + ((payment == null) ? 0 : payment.hashCode());
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
		CardPayment other = (CardPayment) obj;
		if (cstatus == null) {
			if (other.cstatus != null)
				return false;
		} else if (!cstatus.equals(other.cstatus))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numberOfInstallments == null) {
			if (other.numberOfInstallments != null)
				return false;
		} else if (!numberOfInstallments.equals(other.numberOfInstallments))
			return false;
		if (payment == null) {
			if (other.payment != null)
				return false;
		} else if (!payment.equals(other.payment))
			return false;
		return true;
	}

	public void addAll(List<CardPayment> asList) {
		// TODO Auto-generated method stub

	}

}