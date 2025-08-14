package com.spring.ajax_ict05.dto;

public class ProductDTO {

	private String product_id;
	private String product_name;
	private int product_price;
	
	
	public ProductDTO() {
		super();
	}
	
	public ProductDTO(String product_id, String product_name, int product_price) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_price = product_price;
	}
	
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}
	
	@Override
	public String toString() {
		return "ProductDTO [product_id=" + product_id + ", product_name=" + product_name + ", product_price="
				+ product_price + "]";
	}
	
}
