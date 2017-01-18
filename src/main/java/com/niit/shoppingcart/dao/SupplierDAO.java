package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Supplier;

public interface SupplierDAO {

	
	
	public List<Supplier> list();
	public Supplier get(String catid);
	 public boolean save(Supplier supplier);
     public boolean update(Supplier supplier);
	
}