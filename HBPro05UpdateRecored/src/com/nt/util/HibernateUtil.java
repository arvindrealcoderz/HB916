package com.nt.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;
	
	
	static {
		try {
			Configuration cfg=new Configuration();
			cfg.configure("/com/nt/cfg/hibernate.cfg.xml");
			factory=cfg.buildSessionFactory();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//static
	
	public static SessionFactory getSessionFactory() {
		if(factory!=null)
			factory.openSession();
		
	}
}
