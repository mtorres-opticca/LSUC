package ca.on.lsuc.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name="orders")
public class Order extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "customer_name")
	private String customerName;
	
	@Column(name = "customer_address")
	private String customerAddress;
	
	@Column(name = "total")
	private Double orderTotal;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public Double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(Double orderTotal) {
		this.orderTotal = orderTotal;
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("id", this.id)
				.append("customerName", this.customerName)
				.append("customerAddress", this.customerAddress)
				.append("orderTotal", this.orderTotal)
				.toString();
	}
}
