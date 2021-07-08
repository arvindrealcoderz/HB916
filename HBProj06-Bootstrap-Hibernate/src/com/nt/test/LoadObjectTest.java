package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nt.entity.Product;
import com.nt.util.HibernateUtil;

public class LoadObjectTest {
	public static void main(String[] args) {
		try(SessionFactory factory=HibernateUtil.getsessionfactory();
				//get session object
				Session ses=HibernateUtil.getSession();
				){
			//load product objcet
			Product p=ses.load(Product.class, 101);
			if(p!=null)
				System.out.println("Recored found");
			else
				System.out.println("Recored found");
			
			
		}
	}
}
