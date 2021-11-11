package com.hibernate.hibernateapp;
import com.hibernate.dao.MobileDAO;
import com.hibernate.dao.MobileImpl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.hibernateapp.entity.MobileEntity;
public class MobileTester {

	 public static void main(String[] args) throws IOException {

		 
		 MobileDAO dao = new MobileImpl();
		//dao.saveMobileEntity();
		 //dao.getMobileEntity();
		 //dao.updateMobileEntity();
		 //dao.deleteMobileEntity();
		 //dao.getAllMobileEntity();
		 //dao.getMobileBrandById();
		 //dao.getMobileEntityById();
		 //dao.updateById();
		 //dao.deleteById();
		 //dao.maxPriceOfMobile();
		 //dao.totalMobileBrand();
		 //dao.orderByMobileName();
		 //dao.totalPrice();
		 dao.avgPrice();
	 }
}