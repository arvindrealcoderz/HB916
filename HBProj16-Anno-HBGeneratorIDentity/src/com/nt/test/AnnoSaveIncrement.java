package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.util.HibernateUtil;

public class AnnoSaveIncrement {

	public static void main(String[] args) {
		try {
			//get sessionfactory
			SessionFactory factory=HibernateUtil.getSessionFactory();
			//get session
			Session session=HibernateUtil.getSession();
			Transaction tx=null;
			tx=session.beginTransaction();
			
			Product product=new Product();
			product.setPname("arvind verma");
			product.setPrice(9000.0);
			product.setQty(5.0);
			product.setStatus("failure");
			session.save(product);
			//System.out.println("save object "+vakl);
			tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
		
		}
		
	
	}
}
