package com.niit.shoppingcart.daoimpl;

import java.util.List;

import javax.transaction.Transactional;
import org.hibernate.HibernateException;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.niit.shoppingcart.dao.ProductDAO;

import com.niit.shoppingcart.model.Product;


@Repository("productsDAO")
public class ProductDAOImpl implements ProductDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	public ProductDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
			
	}
	@Transactional
	public List<Product> list() {
		String hql = "from Products";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		return query.list();
	}
	
	@Transactional
	public Product get(String pid) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class, pid);

	}
	
	@Transactional
	public boolean save(Product products) {
		try {
			System.out.println("e1");
			sessionFactory.getCurrentSession().save(products);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	@Transactional
	public boolean update(Product products) {
		try {
			sessionFactory.getCurrentSession().update(products);
		
		
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean delete(Product products) {
		try{
			sessionFactory.getCurrentSession().delete(products);
			
			}
catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean create(Product products) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
