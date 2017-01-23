package com.niit.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Supplier;

public class SupplierDAOTestCase {
	public static void main(String[] args) {
		
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.niit.shoppingcart");
		context.refresh();
			
		
	  SupplierDAO supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
	   
	  Supplier supplier = 	(Supplier) context.getBean("supplier");
	   
	  supplier.setSid("S002");
	  supplier.setName("Pantaloon");
	  supplier.setAddress("bbsr");
	   
	   supplierDAO.save(supplier);
	   
	   
	   
	   
	   
	   
	
		
		
		
	}


}
