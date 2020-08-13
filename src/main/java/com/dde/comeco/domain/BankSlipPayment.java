package com.dde.comeco.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.dde.comeco.domain.enums.BankSlipStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class BankSlipPayment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date duedate;

	private Integer bkstatus;

	@OneToOne(mappedBy = "bkpayment")
	private Payment payment;

	public BankSlipPayment() {
	}

	public BankSlipPayment(Integer id, BankSlipStatus bkstatus, Date duedate) {
		super();
		this.id = id;
		this.bkstatus = bkstatus.getCod();
		this.duedate = duedate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDuedate() {
		return duedate;
	}

	public void setDuedate(Date duedate) {
		if (duedate == null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(duedate);
			cal.add(Calendar.DAY_OF_MONTH, 3);
			setDuedate(cal.getTime());
		}
		this.duedate = duedate;
	}

	public BankSlipStatus getBktatus() {
		return BankSlipStatus.toEnum(bkstatus);
	}

	public void setBkstatus(BankSlipStatus bkstatus) {
		if (bkstatus == null) {
			bkstatus = BankSlipStatus.PENDENTE;
		}
		this.bkstatus = bkstatus.getCod();
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bkstatus == null) ? 0 : bkstatus.hashCode());
		result = prime * result + ((duedate == null) ? 0 : duedate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		BankSlipPayment other = (BankSlipPayment) obj;
		if (bkstatus == null) {
			if (other.bkstatus != null)
				return false;
		} else if (!bkstatus.equals(other.bkstatus))
			return false;
		if (duedate == null) {
			if (other.duedate != null)
				return false;
		} else if (!duedate.equals(other.duedate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (payment == null) {
			if (other.payment != null)
				return false;
		} else if (!payment.equals(other.payment))
			return false;
		return true;
	}

	public void addAll(List<BankSlipPayment> asList) {
		// TODO Auto-generated method stub

	}

}
