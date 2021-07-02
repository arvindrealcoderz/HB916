package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nt.entity.Bank;
import com.nt.util.HibernateUtil;

public class ClientAppTest {
	
	
	public static void main(String[] args) {
		//get session factory object
		SessionFactory factory=HibernateUtil.getsessionfactory();
		//get session object
		Session ses=HibernateUtil.getSession();
		try {
			//load the object
		    Bank bank=	ses.load(Bank.class, 102);
			if(bank!=null) {
				System.out.println("Bank employee details are \t:: ");
				System.out.println("Account Number ::"+bank.getAccNo()+"\t account holder name ::"+bank.getHolderName()+"\t"
				+"\taccount balance :: "+bank.getBalance());
			}else
				System.out.println("account no does not matched");
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
