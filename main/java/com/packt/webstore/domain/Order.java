package com.packt.webstore.domain;

import java.io.Serializable;

import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.binding.validation.ValidationContext;

public class Order implements Serializable {
	private static final long serialVersionUID = -3560539622417210365L;
	private Long orderId;
	private Cart cart;
	private Customer customer;
	private ShippingDetail shippingDetail;

	public Order() {
		this.customer = new Customer();
		this.shippingDetail = new ShippingDetail();
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ShippingDetail getShippingDetail() {
		return shippingDetail;
	}

	public void setShippingDetail(ShippingDetail shippingDetail) {
		this.shippingDetail = shippingDetail;
	}

	public void validateCollectCustomerInfo(ValidationContext context) {
		MessageContext messageContex = context.getMessageContext();
		MessageBuilder builder = new MessageBuilder();
		if (customer != null) {
			if (customer.getName().equals("")) {
				messageContex.addMessage(builder.error().source("name").defaultText("Campo nome obbligatorio").build());
			}

			if (customer.getPhoneNumber().equals("")) {
				messageContex.addMessage(builder.error().source("phoneNumber").defaultText("Campo numero di telefono obbligatorio").build());
			}			
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());

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
		Order other = (Order) obj;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}
}