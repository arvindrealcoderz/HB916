package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.util.HibernateUtil;

public class LoadObjectUsingGetMethodsTest {

	public static void main(String[] args) {
		
		try (SessionFactory factory=HibernateUtil.getSessionFactory();
				Session ses=HibernateUtil.getSession();){
			//load object sess.get(-,-)
			Transaction tx=null;
			try(factory;ses){
				tx=ses.beginTransaction();
				Product pro=new Product();
				//pro.setPid(1);
				pro.setPname("Arvind");
				pro.setQty(3.3);
				pro.setPrice(5000.0);
				int id= (int) ses.save(pro);
				tx.commit();
				System.out.println(id+"=====");
				
			}//try
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
