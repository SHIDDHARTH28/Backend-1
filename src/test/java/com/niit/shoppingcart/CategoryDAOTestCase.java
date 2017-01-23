package com.niit.shoppingcart;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

public class CategoryDAOTestCase {

	
	public static void main(String[] args) {
		
			
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
			
			context.scan("com.niit.shoppingcart");
			context.refresh();
				
			
		   CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		   
		   Category category = 	(Category) context.getBean("category");
		   
		   category.setCatid("C002");
		   category.setCatname("mobiles");
		   category.setCatdesc("CGDesc120");
		 
		   
		   categoryDAO.save(category);
		   
		   
		   System.out.println("er6");
		   
		   
		   
		
			
			
			
		}

}

