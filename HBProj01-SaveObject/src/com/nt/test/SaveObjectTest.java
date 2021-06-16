package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class SaveObjectTest {
	public static void main(String[] args) {
		//activate HB framwork
		Configuration cfg=new Configuration();
		//specify hibernate cfg file name and location
		cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//create HB cfg Session factory Object
		SessionFactory factory=cfg.buildSessionFactory();
		//create session object
		Session ses=factory.openSession();
		//prepare entity class object
		Product p=new Product();
		p.setPid(101);
		p.setPname("table");
		p.setPrice(6000.0);
		p.setQty(10.02);
		//save Object
		Transaction tx=null;
		boolean flag=false;
		try {
			//begin tx
			tx=ses.beginTransaction();
			ses.save(p);
			flag=true;
		}catch (HibernateException he) {
			he.printStackTrace();
			flag=false;
		}catch (Exception e) {
			flag=false;
		}finally {
			//perform Tx management
			if(flag) {
				tx.commit();
				System.out.println("Object is Save");
			}else {
				tx.rollback();
				System.out.println("Object is not save ");
			}
			
			//close HB Object
			ses.close();
			factory.close();
		}
		
		
	}

}
