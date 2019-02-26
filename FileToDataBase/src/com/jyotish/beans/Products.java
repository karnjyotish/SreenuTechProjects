package com.jyotish.beans;

import java.util.Date;

public class Products {
	
	private String cardNumber;
	private int pid;
	private String name;
	private String desc;
	private String isStock;
	private double price;
	private Date expdate;
	private float discount;
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String isStock() {
		return isStock;
	}
	public void setStock(String isStock) {
		this.isStock = isStock;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Date getExpdate() {
		return expdate;
	}
	public void setExpdate(Date expdate) {
		this.expdate = expdate;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "Products [cardNumber=" + cardNumber + ", pid=" + pid + ", name=" + name + ", desc=" + desc
				+ ", isStock=" + isStock + ", price=" + price + ", expdate=" + expdate + ", discount=" + discount + "]";
	}
	

}
