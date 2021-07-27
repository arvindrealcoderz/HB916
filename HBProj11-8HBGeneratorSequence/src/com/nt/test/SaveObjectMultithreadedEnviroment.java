package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Product;
import com.nt.runner.MyRunner;
import com.nt.util.HibernateUtil;

public class SaveObjectMultithreadedEnviroment {

	public static void main(String[] args) {
		MyRunner mr1=new MyRunner();
		MyRunner mr2=new MyRunner();
		MyRunner mr3=new MyRunner();
		Thread th1=new Thread(mr1,"thread1");
		Thread th2=new Thread(mr2,"thread2");
		Thread th3=new Thread(mr3,"thread3");
		th1.start();
		th2.start();
		th3.start();
		
	
	}
}
