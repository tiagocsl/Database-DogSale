package com.dde.comeco.domain;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.dde.comeco.domain.enums.PaymentType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class PurchaseOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date momment;

	private Integer type;

	@ManyToOne
	@JoinColumn(name = "client_ID")
	private Client client;

	@ManyToOne
	@JoinColumn(name = "deliveryAddress_ID")
	private Address deliveryAddress;

	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "orsitens")
	@JsonManagedReference
	private Set<OrderedItem> itens = new HashSet<>();

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "orders")
	private Payment payment;

	public PurchaseOrder() {
	}

	public PurchaseOrder(Integer id, Date momment, Client client, Address deliveryAddress, PaymentType type) {
		super();
		this.id = id;
		this.momment = momment;
		this.client = client;
		this.deliveryAddress = deliveryAddress;
		this.type = (type == null) ? null : type.getCod();
	}

	public double getTotalValue() {
		double sum = 0.0;
		for (OrderedItem ip : itens) {
			sum = sum + ip.getSubTotal();
		}
		return sum;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getMomment() {
		return momment;
	}

	public void setMomment(Date momment) {
		this.momment = momment;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public PaymentType getType() {
		return PaymentType.toEnum(type);
	}

	public void setType(PaymentType type) {
		this.type = type.getCod();
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Set<OrderedItem> getItens() {
		return itens;
	}

	public void setItens(Set<OrderedItem> itens) {
		this.itens = itens;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((deliveryAddress == null) ? 0 : deliveryAddress.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((momment == null) ? 0 : momment.hashCode());
		result = prime * result + ((payment == null) ? 0 : payment.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		PurchaseOrder other = (PurchaseOrder) obj;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (deliveryAddress == null) {
			if (other.deliveryAddress != null)
				return false;
		} else if (!deliveryAddress.equals(other.deliveryAddress))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (momment == null) {
			if (other.momment != null)
				return false;
		} else if (!momment.equals(other.momment))
			return false;
		if (payment == null) {
			if (other.payment != null)
				return false;
		} else if (!payment.equals(other.payment))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		StringBuilder builder = new StringBuilder();
		builder.append("Pedido número: ");
		builder.append(getId());
		builder.append(", Instante: ");
		builder.append(sdf.format(getMomment()));
		builder.append(", Cliente: ");
		builder.append(getClient().getName());		
		builder.append(", Situação do pagamento: Pendente");
//		builder.append(getPayment().getStatus().getDescricao());
		builder.append("\nDetalhes:\n");
		for (OrderedItem ip : getItens()) {
			builder.append(ip.toString());
		}
		builder.append("Valor total: ");
		builder.append(nf.format(getTotalValue()));
		return builder.toString();
	}

}