package com.dde.comeco.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.dde.comeco.domain.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Integer status;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date payday;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "order_id")
	private PurchaseOrder orders;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "BankSlip_id")
	private BankSlipPayment bkpayment;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Card_id")
	private CardPayment cpayment;

	public Payment() {
	}

	public Payment(Integer id, PaymentStatus status, Date payday, PurchaseOrder orders, CardPayment cpayment,
			BankSlipPayment bkpayment) {
		super();
		this.id = id;
		this.status = (status == null) ? 1 : status.getCod();
		this.payday = payday;
		this.orders = orders;
		this.cpayment = cpayment;
		this.bkpayment = bkpayment;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PaymentStatus getStatus() {
		return PaymentStatus.toEnum(status);
	}

	public void setStatus(PaymentStatus status) {
		this.status = (status == null) ? 1 : status.getCod();
	}

	@JsonInclude(Include.NON_NULL)
	public Date getPayday() {
		return payday;
	}

	public void setPayday(Date payday) {
		this.payday = payday;
	}

	public PurchaseOrder getOrders() {
		return orders;
	}

	public void setOrder(PurchaseOrder orders) {
		this.orders = orders;

	}

	@JsonInclude(Include.NON_NULL)
	public BankSlipPayment getBkpayment() {
		return bkpayment;
	}

	public void setBkpayment(BankSlipPayment bkpayment) {
		this.bkpayment = bkpayment;
	}

	@JsonInclude(Include.NON_NULL)
	public CardPayment getCpayment() {
		return cpayment;
	}

	public void setCpayment(CardPayment cpayment) {
		this.cpayment = cpayment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bkpayment == null) ? 0 : bkpayment.hashCode());
		result = prime * result + ((cpayment == null) ? 0 : cpayment.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((orders == null) ? 0 : orders.hashCode());
		result = prime * result + ((payday == null) ? 0 : payday.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Payment other = (Payment) obj;
		if (bkpayment == null) {
			if (other.bkpayment != null)
				return false;
		} else if (!bkpayment.equals(other.bkpayment))
			return false;
		if (cpayment == null) {
			if (other.cpayment != null)
				return false;
		} else if (!cpayment.equals(other.cpayment))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (orders == null) {
			if (other.orders != null)
				return false;
		} else if (!orders.equals(other.orders))
			return false;
		if (payday == null) {
			if (other.payday != null)
				return false;
		} else if (!payday.equals(other.payday))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}



}