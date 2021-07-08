package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nt.entity.Product;
import com.nt.util.HibernateUtil;

public class LoadObjectUsingGetMethodsTest {
	public static void main(String[] args) {
		try (SessionFactory factory=HibernateUtil.getSessionFactory();
				Session ses=HibernateUtil.getSession();){
			//load object sess.get(-,-)
			Product product= ses.load(Product.class, 101);
			if(product==null)
				System.out.println("recored not found");
			else
				System.out.println("product  found");
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
}
