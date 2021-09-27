package br.com.jvschulz.gamestore.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private BigDecimal subTotal;
	private BigDecimal shippingFee;
	private BigDecimal totalValue;
	
	@OneToMany(mappedBy = "cart")
	private List<ItemOrder> orderList;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public BigDecimal getShippingFee() {
		return shippingFee;
	}

	public void setShippingFee(BigDecimal shippingFee) {
		this.shippingFee = shippingFee;
	}

	public BigDecimal getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(BigDecimal totalValue) {
		this.totalValue = totalValue;
	}

	public List<ItemOrder> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<ItemOrder> orderList) {
		this.orderList = orderList;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public void subTotal(List<ItemOrder> orders) {
		for(ItemOrder order:orders) {
		this.subTotal.add(order.getTotalPrice());
		}
	}
	
	public void shipping(List<ItemOrder> orders) {
		
		for(@SuppressWarnings("unused") ItemOrder order:orders) {
			this.shippingFee.add(BigDecimal.valueOf(10));
		}
	}
	
	public void totalValue() {
			this.shippingFee.subtract(shippingFee);
			if(this.subTotal.compareTo(BigDecimal.valueOf(250))==1 || this.subTotal.compareTo(BigDecimal.valueOf(250))==0) {
			this.totalValue.add(subTotal);
		}
		else {
			this.totalValue.add(subTotal);
			this.totalValue.add(shippingFee);
		}
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		return id == other.id;
	}
	
	
}
