package com.niit.shoppingcart;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;

import junit.framework.Assert;

public class UserDAOTestCase {

	
	@Autowired
	static UserDAO userDAO;
	
	@Autowired
	static User  user;
	
	@Autowired
	static AnnotationConfigApplicationContext context;
	
	
	
	@BeforeClass  //we can write @BeforeClasses only for the static methods
	public static void init()
	{
		context = new  AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		user = (User) context.getBean("user");
		
		userDAO = (UserDAO) context.getBean("userDAOImpl");
		 
	}
	
	@Test
	public void getUserTestCase()
	{
		
		user = userDAO.get("niit");
		
		
		//Assert statements
	  Assert.assertNotNull("getUserTestCase", user);
		
	}
	
	
	@Test
	public void validateCredentials()
	{
	user=	userDAO.validate("niit", "niit");
	 Assert.assertNotNull("validateCredentials", user);
	}
	
	
	@Test
	public void inValidateCredentials()
	{
	user=	userDAO.validate("Vibhav", "Vibhav");
	 Assert.assertNull("inValidateCredentials", user);
	 
	 //OR
	// Assert.assertEquals("inValidateCredentials", null , user );
	 
	}
	
	
	
	@Test
	public void getAllUsersTestCase()
	{
	 int size=	userDAO.list().size();
	 Assert.assertEquals(" length check ", 8 , size);
	 
	 
	}
	
	
	@Test
	public void saveTestCase()
	{
		
		//you have create /insert new row in db
		//provide values for user
		
		user.setId("Shiddharth");
		user.setName("Sid");
		user.setContact("989898989");
		user.setMail("shiddharth28.com");
		user.setPassword("");
		user.setRole("ROLE_USER");
		
		
	 Assert.assertEquals("saveTestCase", true, 	userDAO.save(user));
		
	}
	
	
	@Test
	public void updateTestCase()
	{
		
	
		user = userDAO.get("Sai");
		
		user.setMail("Sai@yahoo.com");
		
	 Assert.assertEquals("updateTestCase", true, 	userDAO.update(user));
		
		
	}
		

}

