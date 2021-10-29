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
            	 //step1 bootstrap the hibernate
			 Configuration confg = new Configuration();
			 confg.addAnnotatedClass(MobileEntity.class);
			 //step2
			 confg.configure("hibernate.cfg.xml");
			 
			 sessionFactory = confg.buildSessionFactory();
			  session = sessionFactory.openSession();
			 
			 MobileEntity mobile = new MobileEntity(5,"iphone 12",67000.0,"128GB","violet",12.0,true,"ios");
			trans = session.beginTransaction();
			 session.save(mobile);
			 trans.commit();
			 
			 session.close();
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
		  MobileEntity mobile = session.get(MobileEntity.class, 2);
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

	

		
		  
		  @Override
		  public void updateMobileEntity() {
		  System.out.println("Invoked updateMobileEntity()"); 
		  SessionFactory sessionFactory = null; 
		  Session session = null;
		  Transaction transaction = null;
		  try { Configuration confg =new Configuration();
		  confg.addAnnotatedClass(MobileEntity.class);
		  confg.configure("hibernate.cfg.xml");
		  
		  sessionFactory = confg.buildSessionFactory(); 
		  session =sessionFactory.openSession();
		  MobileEntity mobile = session.get(MobileEntity.class, 4); 
		  System.out.println("mobileEntity"+ mobile); 
		  mobile.setMobileBrand("iphone11");
		  mobile.setOstype("ios");
		  mobile.setColor("purple");
		 transaction=  session.beginTransaction();
		  session.update(mobile);
		  transaction.commit();
		  System.out.println("updated");
		  
		  } catch(HibernateException e) {
		  System.out.println("inside catch block");
		  System.out.println("transaction rolled back"); 
		  }finally {
			  if(session!= null)
		  { 
				  session.close(); 
				  System.out.println("session is closed");
		  }
		  if(sessionFactory != null) 
		  { sessionFactory.close();
		  System.out.println("sessionFactory is closed");
		  }
		  else {
		  System.out.println("sessionFactory is not closed");
		  }
		  
	    } 
      } 
   
		  
		 
  @Override
   public void deleteMobileEntity() {
   System.out.println("Invoked updateMobileEntity()"); 
   SessionFactory sessionFactory = null; 
   Session session = null;
   Transaction transaction = null;
   try { 
	   Configuration confg =new Configuration();
       confg.addAnnotatedClass(MobileEntity.class);
       confg.configure("hibernate.cfg.xml");

       sessionFactory = confg.buildSessionFactory(); 
       session =sessionFactory.openSession();
	MobileEntity mobile = session.get(MobileEntity.class, 3); 
	System.out.println("mobileEntity"+ mobile); 
	
	transaction=  session.beginTransaction();
	session.delete(mobile);
	transaction.commit();
	System.out.println("delete");
	
	} catch(HibernateException e) {
	System.out.println("inside catch block");
	System.out.println("transaction rolled back"); 
	}finally {
		  if(session!= null)
	{ 
			  session.close(); 
			  System.out.println("session is closed");
	}
	if(sessionFactory != null) 
	{ sessionFactory.close();
	System.out.println("sessionFactory is closed");
	}
	else {
	System.out.println("sessionFactory is not closed");
	}
	
  } 

 } 

}
	
	
	
			  
			 
