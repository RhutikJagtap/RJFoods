package com.rjfoods.model;

import java.util.HashMap;
import java.util.Map;

public class CartMap {
	Map<Integer, CartItem> cartMap;

	public CartMap() {
		cartMap = new HashMap<>();
	}

	// mehod to add item in cart
	public void addCartItem(CartItem cartItem) {
//		check alredy item is in CartMap or not
//		if containsKey return true then it means item is already in cart
		if (cartMap.containsKey(cartItem.getItemId())) {

			CartItem c = cartMap.get(cartItem.getItemId());
			int quantity1 = c.getQuantity();

			int quantity2 = cartItem.getQuantity();

			int totalQuantity = quantity1 + quantity2;

			// item quantity is changing
			cartItem.setQuantity(totalQuantity);

			cartMap.put(cartItem.getItemId(), cartItem);

		} else {
			cartMap.put(cartItem.getItemId(), cartItem);
		}
	}

	// method to update cartItem
	public void updateCartItem(int itemId, int quantity) {
		CartItem cartItem = cartMap.get(itemId);

		cartItem.setQuantity(quantity);
	}

	// method to delete cartItem
	public void deleteCartItem(int itemId) {
		cartMap.remove(itemId);
	}

	// method to get All cart Items
	public Map<Integer, CartItem> getAllCartItem() {
		return cartMap;
	}
	
	public int countCartItems() {
		return cartMap.size();
	}

	public void incrementQuantity(int itemId) {
		// Check if the cart contains the item
		if (cartMap.containsKey(itemId)) {
			// Retrieve the cart item
			CartItem cartItem = cartMap.get(itemId);

			// Increment the quantity by 1
			int currentQuantity = cartItem.getQuantity();
			cartItem.setQuantity(currentQuantity + 1);

			// Update the cartMap with the new quantity
			cartMap.put(itemId, cartItem);
		}
	}

	public void decrementQuantity(int itemId) {
		// Check if the cart contains the item
		if (cartMap.containsKey(itemId)) {
			// Retrieve the cart item
			CartItem cartItem = cartMap.get(itemId);

			// Increment the quantity by 1
			int currentQuantity = cartItem.getQuantity();
			cartItem.setQuantity(currentQuantity - 1);

			// Update the cartMap with the new quantity
			cartMap.put(itemId, cartItem);
		}

	}
}
