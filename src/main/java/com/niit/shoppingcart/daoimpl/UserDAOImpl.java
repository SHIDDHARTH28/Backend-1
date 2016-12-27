package com.niit.shoppingcart.daoimpl;

import com.niit.shoppingcart.dao.UserDAO;


public class UserDAOImpl implements UserDAO{
	
	public boolean isValidCredentials(String id, String password) {
		// need tot test against db
		// temporary - id: niit ans passord : niit@123
		
		System.out.println("In is ValidCredentials method of ShoppingCartBckEnd Project");
		
		if(id.equals("niit") && password.equals("niit@123"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
