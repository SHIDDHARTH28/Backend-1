package com.niit.shoppingcart.daoimpl;

import java.util.List;

import javax.transaction.Transactional;
import org.hibernate.HibernateException;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.ProductsDAO;

import com.niit.shoppingcart.model.Products;


@Repository
public class ProductsDAOImpl implements ProductsDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	public ProductsDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
			
	}
	@Transactional
	public List<Products> list() {
		String hql = "from Products";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		return query.list();
	}
	
	@Transactional
	public Products get(String pid) {
		return (Products) sessionFactory.getCurrentSession().get(Products.class, pid);

	}
	
	@Transactional
	public boolean save(Products products) {
		try {
			sessionFactory.getCurrentSession().save(products);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	@Transactional
	public boolean update(Products products) {
		try {
			sessionFactory.getCurrentSession().update(products);
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
}
