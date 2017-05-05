package com.pengrui.functions;

public class Orders {
	private int id = 0;
	private int status = 0;
	private String datetime = "";
	private int customerId = 0;
	private int productId = 0;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", status=" + status + ", datetime=" + datetime + ", customerId=" + customerId
				+ ", productId=" + productId + "]";
	}
	
	
}
