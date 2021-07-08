package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nt.entity.Product;
import com.nt.util.HibernateUtil;

public class LoadObjectTest {
	
	public static void main(String[] args) {
		try (SessionFactory SessionFactory= HibernateUtil.getsessioSessionFactory();
			Session ses=HibernateUtil.getseSession();
			){
			Product p= ses.load(Product.class, 101);
			if(p!=null)
				System.out.println("recored found");
			else	
				System.out.println("not recored found");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
