package com.nt.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory factory;
	
	static {
		try {
			//Load properties file into  java.util.Properties class object
			Properties props=new Properties();
			InputStream is=new FileInputStream("src/com/nt/commons/info.properties");
			props.load(is);
			
			
			//Active hibernate 
			Configuration cfg=new Configuration();
			cfg.setProperties(props);
			cfg.addFile("src/com/nt/entity/Product.hbm.xml");
			//build session factory
			factory=cfg.buildSessionFactory();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}//static
	public static SessionFactory getsessionfactory() {
		if(factory!=null)
			return factory;
		else
			throw new RuntimeException("Invalid session factory");
	}
	//open session
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
	public static void closeSessionfactory() {
		if(factory!=null)
			factory.close();
	}
	
	
}
