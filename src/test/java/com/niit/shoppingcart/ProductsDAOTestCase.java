package com.niit.shoppingcart;

import org.junit.BeforeClass;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.shoppingcart.dao.ProductsDAO;
import com.niit.shoppingcart.model.Products;

import junit.framework.Assert;

public class ProductsDAOTestCase {

	
	@Autowired
	static ProductsDAO ProductsDAO;
	
	@Autowired
	static Products  products;
	
	@Autowired
	static AnnotationConfigApplicationContext context;
	@BeforeClass  //we can write @BeforeClasses only for the static methods
	public static void init()
	{
		
		context = new  AnnotationConfigApplicationContext();
		
		context.scan("com.niit.shoppingcart");
		
		context.refresh();
		
		
		products = (Products) context.getBean("products");
		
		ProductsDAO = (ProductsDAO) context.getBean("productsDAOImpl");
		 
	}
	
	
	
	@Test
	public void saveTestCase()
	{
		
		//you have create /insert new row in db
		//provide values for category
		
	
		products.setPid("C001");
		products.setName("Electronics");
		products.setPrice(10000);
		products.setCategory("Smart phone");
		products.setSupplier("DS Telecommunication");
		products.setStock("500");
		products.setDescription("Mobiles");
		
		
	 Assert.assertEquals("saveTestCase", true, 	ProductsDAO.save(products));
		
	}
	
	
	
	
}
