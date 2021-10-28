package com.hibernate.dao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.hibernateapp.entity.MobileEntity;

public class MobileImpl implements MobileDAO{

	@Override
	public void saveMobileEntity() {
		System.out.println("Invoked saveMobileEntity()");
		     SessionFactory sessionFactory = null;
             Transaction trans = null;
             Session session = null;
             try {
			 Configuration confg = new Configuration();
			 confg.addAnnotatedClass(MobileEntity.class);
			 confg.configure("hibernate.cfg.xml");
			 
			 sessionFactory = confg.buildSessionFactory();
			  session = sessionFactory.openSession();
			 session.beginTransaction();
			 MobileEntity mobile = new MobileEntity(2,"oneplus 8",80000.0,"128GB","Blue",48.0,true,"Android");
			trans = session.beginTransaction();
			 session.save(mobile);
			 trans.commit();
			 System.out.println("Done");
			 
		 }catch(HibernateException e) {
			 System.out.println("inside catch block!!!!");
			 trans.rollback();
			 System.out.println("transsaction rolled back");
		 }finally {
			 if(session!= null) {
				 session.close();
				 System.out.println("session is closed");
			 }else
				 System.out.println("session is not closed");
			 
		 
             if(sessionFactory != null) {
            	 sessionFactory.close();
            	 System.out.println("sessionFactory is closed ");
             }else
				 System.out.println("session is not closed");
	

	}

		
	}

	@Override
	public void getMobileEntity() {
	 System.out.println("Invoked getMobileEntity()");
	 SessionFactory sessionFactory = null;
	 
	 Session session = null;
	 try {
		 Configuration confg = new Configuration();
		 confg.addAnnotatedClass(MobileEntity.class);
		 confg.configure("hibernate.cfg.xml");
		 
		 sessionFactory = confg.buildSessionFactory();
		  session = sessionFactory.openSession();
		  MobileEntity mobile = session.get(MobileEntity.class, 1);
		  System.out.println("read is done"+ mobile);
	 }
	 catch(HibernateException e) {
		 System.out.println("inside catch block");
		 System.out.println("transaction rolled back");
	 }finally {
		 if(session!= null) {
			 session.close();
			 System.out.println("session is closed");
		 }
		 if(sessionFactory != null) {
			 sessionFactory.close();
			 System.out.println("sessionFactory is closed");
		 }else {
			 System.out.println("sessionFactory is not closed");
		 }
			 
		 }
	 }
}

