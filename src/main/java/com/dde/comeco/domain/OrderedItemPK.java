//package com.dde.comeco.domain;
//
//import java.io.Serializable;
//
//import javax.persistence.Embeddable;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//
//
//@Embeddable
//public class OrderedItemPK implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//	@ManyToOne
//	@JoinColumn(name = "Purchase_Order_id")
//	private PurchaseOrder orsitens;
//
//	/*@ManyToOne
//	@JoinColumn(name = "Breed")
//	private Breed breed;*/
//
//		
//	public PurchaseOrder getOrsitens() {
//		return orsitens;
//	}
//
//	public void setOrsitens(PurchaseOrder orsitens) {
//		this.orsitens = orsitens;
//	}
//
//	public Breed getBreed() {
//		return breed;
//	}
//
//	public void setBreed(Breed breed) {
//		this.breed = breed;
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((orsitens == null) ? 0 : orsitens.hashCode());
//		result = prime * result + ((breed == null) ? 0 : breed.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		OrderedItemPK other = (OrderedItemPK) obj;
//		if (orsitens == null) {
//			if (other.orsitens != null)
//				return false;
//		} else if (!orsitens.equals(other.orsitens))
//			return false;
//		if (breed == null) {
//			if (other.breed != null)
//				return false;
//		} else if (!breed.equals(other.breed))
//			return false;
//		return true;
//	}
//
//
//
//}