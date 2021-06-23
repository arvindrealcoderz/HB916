package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.BookEntity;

public class BookSaveTest {
	public static void main(String[] args) {
		//Activate HB framwork
		Configuration cfg=new Configuration();
		//specify name and location of the specify cfg file name
		cfg.configure("/com/nt/cfg/hibernate.cfg.xml");
		//create sessionfactory Object
		SessionFactory factory=cfg.buildSessionFactory();
		//create session objcte
		Session session=factory.openSession();
		try {
			//load get object
		//	BookEntity entity= session.get(BookEntity.class, 21);
			
			BookEntity entity= session.load(BookEntity.class, 22);
			
			System.out.println(entity==null?"Book not found ":"Book found ");
			if(entity!=null)
				System.out.println(entity.getBookId()+"\t"+entity.getBookName()+"\t"+entity.getBookType()+"\t"+entity.getBookType()+"\t"+entity.getBookPrice());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		
		}
		
		
	}
	

}
