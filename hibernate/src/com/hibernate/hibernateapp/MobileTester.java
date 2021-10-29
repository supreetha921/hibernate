package com.hibernate.hibernateapp;
import com.hibernate.dao.MobileDAO;
import com.hibernate.dao.MobileImpl;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.hibernateapp.entity.MobileEntity;
public class MobileTester {

	 public static void main(String[] args) {
		 
		 MobileDAO dao = new MobileImpl();
		// dao.saveMobileEntity();
		// dao.getMobileEntity();
		// dao.updateMobileEntity();
		 dao.deleteMobileEntity();
		 
	 }
}