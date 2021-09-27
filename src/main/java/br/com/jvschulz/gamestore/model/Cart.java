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
	@GeneratedValue(strategy = GenerationType.TABLE)
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
		this.subTotal = BigDecimal.ZERO;
		for (ItemOrder order : orders) {
			this.subTotal = (order.getTotalPrice().add(subTotal));
		}
	}

	public void shipping(List<ItemOrder> orders) {
		this.shippingFee = BigDecimal.ZERO;
		for (@SuppressWarnings("unused")
		ItemOrder order : orders) {
			this.shippingFee = BigDecimal.valueOf(10).add(shippingFee);
		}
	}

	public void totalValue() {
		if (this.subTotal.compareTo(BigDecimal.valueOf(250)) >= 0 ) {
			this.shippingFee = BigDecimal.ZERO;
			this.totalValue = subTotal;
		} else {
			this.totalValue = subTotal;
			this.totalValue = this.shippingFee.add(totalValue);
		}

	}
	
	public void refresh(List<ItemOrder> orders) {
		shipping(orders);
		subTotal(orders);
		totalValue();
		
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
