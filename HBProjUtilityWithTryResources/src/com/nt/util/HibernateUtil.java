// The java class that contained full of static methods having ability to create and return object
// that class is called utility class.

// insted of placing logic to create session factory object session object 
// and closing the logic in the client application directly is not good.
// placing that logic to one seprate file that is called HibernateUtil class ..


package com.nt.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory factory;
	
	static {
		try {
			//configuration object
			Configuration cfg=new Configuration();
			cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
			//build session factory object
			factory=cfg.buildSessionFactory();
			
		}
		catch (HibernateException e) {
			e.printStackTrace();
			System.err.println("factory object are not created . ");
		}
		catch (Exception e) {
			e.printStackTrace();
			System.err.println("internat problem occured .");
		}
	}//static
	
	//getSessionFactoryObject
	public static SessionFactory getsessionfactory() {
		if(factory!=null)
			return	factory;
		else
			throw new RuntimeException("Invalid session factory obejct creation");
		
	}//session factory
	
	//get session object
	public static Session getSession() {
		Session ses=null;
		//open session object
		if(factory!=null)
			ses= factory.openSession();
		//returning session object
		return ses;
	}
	
	//closing session object
	public static void closesession(Session ses) {
		if(ses!=null)
			ses.close();
	}//close session object
	
	//closing closeSessionFactory
	public static void closeSessionFactory() {
		if(factory!=null)
			factory.close();
	}
	
	

}
