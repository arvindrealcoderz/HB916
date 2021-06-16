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
		//prepare book object 
		BookEntity book=new BookEntity();
		book.setBookName("Java");
		book.setBookAuthor("James");
		book.setBookPrice(5000.0);
		book.setBookType("Reading");
		
		
		//open the transaction
		Transaction tx=null;
		boolean flag=false;
		try {
			tx=session.beginTransaction();
			Integer id= (Integer) session.save(book);
			flag=true;
		//	session.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(flag) {
				tx.commit();
				System.out.println("Book recored has been save ");
			
			}else {
				tx.rollback();	
				System.out.println("Book recored are not   save ");
				
			}
		}
		
		
	}
	

}
