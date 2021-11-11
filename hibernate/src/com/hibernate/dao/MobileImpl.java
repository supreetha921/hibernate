package com.hibernate.dao;



import java.io.File;


import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import com.xworkz.singlesessionfactory.*;





import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
//import com.mysql.cj.Query;

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
			 
		
			 
			 // MobileEntity mobile = new MobileEntity("oneplus 8",80000.0,"128GB","Blue",48.0,true,"Android");
			trans = session.beginTransaction();
			//session.save(mobile);
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
		 // MobileEntity mobile = session.load(MobileEntity.class, 10);
		  MobileEntity mobile = session.get(MobileEntity.class, 10);
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
		  mobile.setColor("yellow");
		 transaction=  session.beginTransaction();
		  //session.update(mobile);
		  session.persist(mobile);
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
	session.remove(mobile);
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

@Override
public void getAllMobileEntity() {
	System.out.println("Invoked getAllMobileEntity()");
	SessionFactory sessionFactory = null;
	Session session = null;
	try {
	sessionFactory= SessionFactoryProvider.getSessionFactory();
	session= sessionFactory.openSession();
	String hqlQuery = "from MobileEntity";
	//String hqlQuery = " from MobileEntity where mobileId=2";
	
	
	Query query = session.createQuery(hqlQuery);
	//Object object = query.uniqueResult();
	//String mobileBrand =(String) object;
	//System.out.println(mobileBrand);
	List listOfMobileEntity =query.list();
	System.out.println(listOfMobileEntity);
	}
	catch(HibernateException e) {
	}
	finally {
		if(session!= null) {
			session.close();
			System.out.println("session is closed");
		}else {
			System.out.println("session is not closed");
		}
	}
	
	
	
	
}

@Override
public void getMobileBrandById() {
	
	
	System.out.println("Invoked getMobileBrandById)");
	SessionFactory sessionFactory = null;
	Session session = null;
	try {
	sessionFactory= SessionFactoryProvider.getSessionFactory();
	session= sessionFactory.openSession();
	
	String hqlQuery = " select mobileBrand from MobileEntity where mobileId=2";
	
	
	Query query = session.createQuery(hqlQuery);
	Object object = query.uniqueResult();
	String mobileBrand =(String) object;
	System.out.println(mobileBrand);
	
	
	}
	catch(HibernateException e) {
	}
	finally {
		if(session!= null) {
			session.close();
			System.out.println("session is closed");
		}else {
			System.out.println("session is not closed");
		}
	}
	
	
	
	
}

@Override
public void getMobileEntityById() {
	
	
	System.out.println("Invoked getMobileBrandById()");
	SessionFactory sessionFactory = null;
	Session session = null;
	try {
	sessionFactory= SessionFactoryProvider.getSessionFactory();
	session= sessionFactory.openSession();
	
	String hqlQuery = "from MobileEntity where mobileId=4";
	
	
	Query query = session.createQuery(hqlQuery);
	Object object = query.uniqueResult();
	
	System.out.println("MobileEntity"+object);
	
	
	}
	catch(HibernateException e) {
	}
	finally {
		if(session!= null) {
			session.close();
			System.out.println("session is closed");
		}else {
			System.out.println("session is not closed");
		}
	}
	
	
	
	
}
public void updateById() {
	
	
	System.out.println("Invoked updateById()");
	SessionFactory sessionFactory = null;
	Session session = null;
	try {
	sessionFactory= SessionFactoryProvider.getSessionFactory();
	session= sessionFactory.openSession();
	session.beginTransaction();
	String hqlQuery = "update MobileEntity set mobilePrice=85000 where mobileId=6";
	
	
	Query query = session.createQuery(hqlQuery);
	int update = query.executeUpdate();
	session.getTransaction().commit();
	System.out.println(update);
	
	
	}
	catch(HibernateException e) {
		System.out.println("inside catch block");
		session.getTransaction().rollback();
		System.out.println("transaction has been rolled back");
	}
	finally {
		if(session!= null) {
			session.close();
			System.out.println("session is closed");
		}else {
			System.out.println("session is not closed");
		}
	}
	
	
	
	
}

@Override
public void deleteById() {
	
	System.out.println("Invoked deleteById()");
	SessionFactory sessionFactory = null;
	Session session = null;
	try {
	sessionFactory= SessionFactoryProvider.getSessionFactory();
	session= sessionFactory.openSession();
	session.beginTransaction();
	String hqlQuery = "delete from MobileEntity where mobileId=6";
	
	
	Query query = session.createQuery(hqlQuery);
	int delete = query.executeUpdate();
	session.getTransaction().commit();
	System.out.println(delete);
	
	
	}
	catch(HibernateException e) {
		System.out.println("inside catch block");
		session.getTransaction().rollback();
		System.out.println("transaction has been rolled back");
	}
	finally {
		if(session!= null) {
			session.close();
			System.out.println("session is closed");
		}else {
			System.out.println("session is not closed");
		}
	}
	
	
	
	
}

@Override
public void maxPriceOfMobile() {
	System.out.println("Invoked maxPriceOfMobile()");
	SessionFactory sessionFactory = null;
	Session session = null;
	try {
	sessionFactory= SessionFactoryProvider.getSessionFactory();
	session= sessionFactory.openSession();
	
	String hqlQuery = "select MAX(mobilePrice)from MobileEntity"; 
	
	
	Query query = session.createQuery(hqlQuery);
	Object object = query.uniqueResult();
	
	System.out.println("MobileEntity"+object);
	
	
	}
	catch(HibernateException e) {
	}
	finally {
		if(session!= null) {
			session.close();
			System.out.println("session is closed");
		}else {
			System.out.println("session is not closed");
		}
	}
	
	
	
	
}

	

@Override
public void totalMobileBrand() {
	System.out.println("Invoked totalMobileBrand()");
	SessionFactory sessionFactory = null;
	Session session = null;
	try {
	sessionFactory= SessionFactoryProvider.getSessionFactory();
	session= sessionFactory.openSession();
	
	String hqlQuery = "select count(mobileBrand) from MobileEntity"; 
	
	
	Query query = session.createQuery(hqlQuery);
	Object object = query.uniqueResult();
	
	System.out.println(object);
	
	
	}
	catch(HibernateException e) {
	}
	finally {
		if(session!= null) {
			session.close();
			System.out.println("session is closed");
		}else {
			System.out.println("session is not closed");
		}
	}
	
	
	
	
}

@Override
public void orderByMobileName() {
	
		System.out.println("Invoked orderByMobileName()");
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
		sessionFactory= SessionFactoryProvider.getSessionFactory();
		session= sessionFactory.openSession();
		
		String hqlQuery = "Select mobilePrice from MobileEntity order by mobilePrice"; 
		
		
		Query query = session.createQuery(hqlQuery);
		Object object = query.uniqueResult();
		
		System.out.println(object);
		
		
		}
		catch(HibernateException e) {
		}
		finally {
			if(session!= null) {
				session.close();
				System.out.println("session is closed");
			}else {
				System.out.println("session is not closed");
			}
		}
		
		
		
		
	}

@Override
public void totalPrice() {
	System.out.println("Invoked totalPrice()");
	SessionFactory sessionFactory = null;
	Session session = null;
	try {
	sessionFactory= SessionFactoryProvider.getSessionFactory();
	session= sessionFactory.openSession();
	
	String hqlQuery = "select SUM(mobilePrice) AS TOTAL FROM MobileEntity "; 
	
	
	Query query = session.createQuery(hqlQuery);
	Object object = query.uniqueResult();
	
	System.out.println(object);
	
	
	}
	catch(HibernateException e) {
	}
	finally {
		if(session!= null) {
			session.close();
			System.out.println("session is closed");
		}else {
			System.out.println("session is not closed");
		}
	}
	
	
	
	
}


@Override
public void avgPrice() {
	System.out.println("Invoked totalPrice()");
	SessionFactory sessionFactory = null;
	Session session = null;
	try {
	sessionFactory= SessionFactoryProvider.getSessionFactory();
	session= sessionFactory.openSession();
	
	String hqlQuery = "select AVG(mobilePrice) AS TOTAL FROM MobileEntity "; 
	
	
	Query query = session.createQuery(hqlQuery);
	Object object = query.uniqueResult();
	
	System.out.println(object);
	
	
	}
	catch(HibernateException e) {
	}
	finally {
		if(session!= null) {
			session.close();
			System.out.println("session is closed");
		}else {
			System.out.println("session is not closed");
		}
	}
	
	
	
	
}



}
	

	
	
	
	
	
	//SELECT TASTE,COUNT(NAME)FROM choclates GROUP BY TASTE;
	

//String hqlQuery = "select count(brand)from MobileEntity()"; 

	//String hqlQuery = "select MAX(mobilePrice)from MobileEntity"; 
//SELECT  PRICE FROM choclates order by PRICE DESC;
//SELECT BRAND,SUM(PRICE) AS TOTAL FROM choclates GROUP BY BRAND;
//SELECT BRAND,SUM(PRICE) AS TOTAL FROM choclates GROUP BY BRAND;

	
	
	
			  
			 
