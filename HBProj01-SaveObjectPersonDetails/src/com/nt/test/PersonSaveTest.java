package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Person;

public class PersonSaveTest {
	
	public static void main(String[] args) {
		//activate hb framwork
		Configuration cfg=new Configuration();
		//specifuied hibernate cfg file name and location
		cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//create HB sessionFactory Object
		SessionFactory factory=cfg.buildSessionFactory();
		//create session object
		Session session=factory.openSession();
		//prepare entity class object having data..
		Person p=new Person();
		//set data to the person object
		p.setPid(1);
		p.setPname("Arvind");
		p.setPaddr("Hyd");
		p.setPsal(521.0f);
		Transaction tx=null;
		boolean flag=false;
		try {
			System.out.println("PersonSaveTest.main(1)");
			//start the transaction
			tx=session.beginTransaction();
			//save data to the db.
			session.save(p);
			flag=true;
			
		} catch (Exception e) {
			System.out.println("PersonSaveTest.main(2)");
			e.printStackTrace();
		}
		finally {
			System.out.println("PersonSaveTest.main(3)"+flag);
			if(flag==false) {
				tx.rollback();
				System.out.println("Data is not save successfully..");
			}
			else {
				tx.commit();
				System.out.println("Data save successfully..");
			}
		}
		
		
	}

}
