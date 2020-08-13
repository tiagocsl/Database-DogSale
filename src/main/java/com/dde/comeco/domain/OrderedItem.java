package com.dde.comeco.domain;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.dde.comeco.domain.enums.Gender;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OrderedItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true)
	private Long id;

	private Double discount;

	private Integer amount;

	private Double price;

	@Column(updatable = false)
	private Integer gender;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Purchase_Order_id")
	@JsonBackReference
	private PurchaseOrder orsitens;

	@ManyToOne
	@JoinColumn(name = "Breed_id")
	private Breed breed;

	public OrderedItem() {
	}

	public OrderedItem(PurchaseOrder orsitens, Breed breed, Gender gender, Double discount, Integer amount, Double price) {			
		super();
		this.orsitens = orsitens;
		this.breed = breed;
		this.gender = (gender == null) ? null : gender.getCod();
		this.discount = discount;
		this.amount = amount;
		this.price = price;
	}


	public double getSubTotal() {
		return (price - discount) * amount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(updatable = false)
	public Gender getGender() {
		return Gender.toEnum(gender);
	}

	@Column(updatable = false)
	public void setBkstatus(Gender gender) {
		if (gender == Gender.toEnum(0)) {
			gender = Gender.MALE;
		}
		if (gender == Gender.toEnum(1)) {
			gender = Gender.FEMALE;
		}
		this.gender = gender.getCod();
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@JsonIgnore
	public PurchaseOrder getOrsitens() {
		return orsitens;
	}

	public void setOrsitens(PurchaseOrder orsitens) {
		this.orsitens = orsitens;
	}

	
	public Breed getBreed() {
		return breed;
	}

	public void setBreed(Breed breed) {
		this.breed = breed;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((breed == null) ? 0 : breed.hashCode());
		result = prime * result + ((discount == null) ? 0 : discount.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		result = prime * result + ((orsitens == null) ? 0 : orsitens.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
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
		OrderedItem other = (OrderedItem) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (breed == null) {
			if (other.breed != null)
				return false;
		} else if (!breed.equals(other.breed))
			return false;
		if (discount == null) {
			if (other.discount != null)
				return false;
		} else if (!discount.equals(other.discount))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
//		if (orsitens == null) {
//			if (other.orsitens != null)
//				return false;
//		} else if (!orsitens.equals(other.orsitens))
//			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		StringBuilder builder = new StringBuilder();
		builder.append(getBreed().getName());
		builder.append(", Gênero: ");
		builder.append(getGender());
		builder.append(", Qte: ");
		builder.append(getAmount());		
		builder.append(", Preço unitário: ");
		builder.append(nf.format(getPrice()));
		builder.append(", Subtotal: ");
		builder.append(nf.format(getSubTotal()));
		builder.append("\n");
		return builder.toString();
	}

}