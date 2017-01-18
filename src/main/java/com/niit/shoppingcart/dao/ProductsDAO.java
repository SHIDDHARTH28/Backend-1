package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Products;

public interface ProductsDAO {

	public List<Products> list();
	public Products get(String pid);
	 public boolean save(Products products);
     public boolean update(Products products);
	
	
	
}
