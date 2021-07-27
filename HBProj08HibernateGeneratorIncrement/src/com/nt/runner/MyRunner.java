package com.nt.runner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.util.HibernateUtil;

public class MyRunner implements Runnable {

	@Override
	public void run() {
		try {
			if (Thread.currentThread().getName().equalsIgnoreCase("thread1")) {
				Thread.sleep(5000);
			}else if (Thread.currentThread().getName().equalsIgnoreCase("thread2")) {
				Thread.sleep(15000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Transaction tx=null;
		Session ses=HibernateUtil.getSession();
		Product pro=new Product();
		pro.setPname("laptop");
		pro.setPrice(5422.0);
		pro.setQty(3.3);
		try(ses){
			tx=ses.beginTransaction();
			int id=(int) ses.save(pro);
			tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
			if(tx!=null || tx.getStatus()!=null|| tx.getRollbackOnly())
			tx.rollback();
		}

	}

}
