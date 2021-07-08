package com.nt.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private  static SessionFactory factory;
	
	
	static {
		try {
			//Activate Hibernate f/w
			Configuration cfg=new Configuration();
			//programatic approch
			cfg.setProperty("hibernate.connection.driver_class","oracle.jdbc.driver.OracleDriver");
			cfg.setProperty("hibernate.connection.url","jdbc:oracle:thin:@localhost:1521:orcl");
			cfg.setProperty("hibernate.connection.username","scott");
			cfg.setProperty("hibernate.connection.password","Arvind");
			cfg.setProperty("hibernate.show_sql","true");
			cfg.setProperty("hibernate.formate_sql","true");
			cfg.setProperty("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
			cfg.addFile("src/com/nt/entity/product.hbm.xml");
			//build session factory
			factory= cfg.buildSessionFactory();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}//static
	
	//get sessionfactory object
	public static SessionFactory getsessioSessionFactory() {
		if(factory!=null)
			return factory;
		else
			throw new RuntimeException("get session factory object");
	}
	public static Session getseSession() {
		Session ses=null;
		if (factory!=null) 
			ses=factory.openSession();
		return ses;
		
	}
	
	

}
