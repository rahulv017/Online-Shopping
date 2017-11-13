package com.online.shopping.Model;

public class ShopppingCart {

	int product_id;
	String product_name;
	int price;
	int quantity;
	String prodduct_desc;
	String username;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getProdduct_desc() {
		return prodduct_desc;
	}
	public void setProdduct_desc(String prodduct_desc) {
		this.prodduct_desc = prodduct_desc;
	}
	

}
