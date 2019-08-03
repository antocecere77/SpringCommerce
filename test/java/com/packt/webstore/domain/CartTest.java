package com.packt.webstore.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CartTest {

	private Cart cart;

	@Before
	public void setup() {
		cart = new Cart("1");
		cart.setCartItems(new ArrayList<CartItem>());
	}

	@Test
	public void cart_total_price_should_be_equal_to_product_unit_price_in_case_of_single_quantity() {
		// Arrange
		Product iphone = new Product("P1234", "iPhone 5s", new BigDecimal(500));
		List<CartItem> items = new ArrayList<CartItem>();

		CartItem item = new CartItem("1");
		item.setProduct(iphone);
		items.add(item);
		cart.setCartItems(items);

		// Act
		BigDecimal totalPrice = cart.getGrandTotal();
		// Assert
		Assert.assertEquals(iphone.getUnitPrice(), totalPrice);
		
	}

	@Test
	public void cart_total_without_items_should_be_zero() {
		BigDecimal totalPrice = cart.getGrandTotal();
		Assert.assertEquals(BigDecimal.ZERO, totalPrice);
	}

}
