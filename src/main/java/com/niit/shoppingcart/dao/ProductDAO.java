package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Product;

public interface ProductDAO {

	public List<Product> list();
	public Product get(String pid);
	 public boolean save(Product products);
     public boolean update(Product products);
     public boolean delete(Product products);
	public boolean create(Product products);
	
	
	
}
