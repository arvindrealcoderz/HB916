package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Student;

public class SaveObjectTest {
	public static void main(String[] args) {
		//create configuration object
		Configuration cfg=new Configuration();
		//configure 
		cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//create sessionfactory object
		SessionFactory factory=cfg.buildSessionFactory();
		//create session object
		Session ses=factory.openSession();
		//create student class object
		Student st=new Student();
		st.setSno(1010);
		Transaction  tx=null;
		boolean flag=false;
		try {
			ses.save(st);
			flag=true;
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		if(flag)
			System.out.println("Student recored save");
		else
			System.out.println("Student recored save");
	}
}
