package com.pengrui.object;

public class Products {
	private int productsId = 0;
	private String name = "";
	private String description = "";
	private int price = 0;
	private int number = 0;
	private int sellersId = 0;
	private int status = 0;

	public Products() {

	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int sta) {
		if (sta != 0) {
			this.status = sta;
		}else {
			this.status = 0;
		}
	}

	public int getProductsId() {
		return productsId;
	}

	public void setProductsId(int productsId) {
		this.productsId = productsId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getSellersId() {
		return sellersId;
	}

	public void setSellersId(int sellersId) {
		this.sellersId = sellersId;
	}

	@Override
	public String toString() {
		return "Products [productsId=" + productsId + ", name=" + name + ", description=" + description + ", price="
				+ price + ", number=" + number + ", sellersId=" + sellersId + ", status=" + status + "]";
	}

}
