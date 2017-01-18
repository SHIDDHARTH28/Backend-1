package com.niit.shoppingcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "product")
@Component
public class Products {

	

	@Id
	private String  pid;
	private String name;
	private double price;
	private String stock;
	private String description;
	
	
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String string) {
		this.supplier = string;
	}
	public String getCatid() {
		return catid;
	}
	public void setCatid(String catid) {
		this.catid = catid;
	}
	

	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}

	private String catid;
	
	
	private String sid;
	
	@ManyToOne
    @JoinColumn(name="catid", nullable = false, updatable = false, insertable = false)
   	private String category;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String string) {
		this.category = string;
	}
	
	@ManyToOne
    @JoinColumn(name="sid",nullable = false, updatable = false, insertable = false)
	private String supplier;
	public String getId() {
		return pid;
	}
	public void setId(String pid) {
		this.pid = pid;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setPid(String string) {
		// TODO Auto-generated method stub
		this.pid = pid;
	}
	public void setStock(String stock) {
		// TODO Auto-generated method stub
		this.stock=stock;
	}
	
	
	

}
