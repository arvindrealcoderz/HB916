package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Bank;

public class LoadTest {
	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
		cfg.configure("/com/nt/cfg/hibernate.cfg.xml");
		SessionFactory factory= cfg.buildSessionFactory();
		Session session= factory.openSession();
		Bank bank= session.load(Bank.class
				,101
				);
		
		if(bank!=null)
		{System.out.println(" bank recored found");
		System.out.println(" accNo \t:: accHolderName\t:Balance");
		
			System.out.println(bank.getAccNo()+"\t"+bank.getHolderName()+"\t"+bank.getBalance());
		}else
			System.out.println("No bank recored found");
		
		
	}
	

}
