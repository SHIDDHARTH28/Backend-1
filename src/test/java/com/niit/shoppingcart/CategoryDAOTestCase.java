package com.niit.shoppingcart;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;

import com.niit.shoppingcart.model.Category;


import junit.framework.Assert;

public class CategoryDAOTestCase {


	@Autowired
	static CategoryDAO CategoryDAO;
	
	@Autowired
	static Category  category;
	
	@Autowired
	static AnnotationConfigApplicationContext context;
	
	
	@BeforeClass  //we can write @BeforeClasses only for the static methods
	public static void init()
	{
		
		context = new  AnnotationConfigApplicationContext();
		
		context.scan("com.niit.shoppingcart");
		
		context.refresh();
		
		
		category = (Category) context.getBean("category");
		
		CategoryDAO = (CategoryDAO) context.getBean("categoryDAOImpl");
		 
	}
	
	@Test
	public void saveTestCase()
	{
		
		//you have create /insert new row in db
		//provide values for category
		
	
		category.setCatid("C001");
		category.setCatname("Electronics");
		category.setCatdesc("Mobiles");
		
		
	 Assert.assertEquals("saveTestCase", true, 	CategoryDAO.save(category));
		
	}
	
	
	
	
	
	
	
}
