package com.nt.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;
	
	static {
		try {

			//configuration object
			Configuration cfg=new Configuration();
			cfg.addFile("/com/nt/entity/Product.hbm.xml");
			//build session factory object
			factory=cfg.buildSessionFactory();
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}//static
	
	public static SessionFactory getSessionFactory(){
		if(factory!=null)
			return factory;
		else
			throw new RuntimeException("Invalid SessionFactory object creation");
	}//getSessionFactory
	
	public static Session getSession() {
		Session ses=null;
		if(factory!=null)
			ses=factory.openSession();
		return ses;
	}
	
	public static void closeSession(Session ses) {
		if(ses!=null)
			ses.close();
	}
	public static void closeSessionFactoy() {
		if(factory!=null)
			factory.close();
	}
	
}
