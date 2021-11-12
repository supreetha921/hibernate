package com.hibernate.hibernateapp;
import com.hibernate.dao.MobileDAO;
import com.hibernate.dao.MobileImpl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

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
		 
		 MobileEntity mobile = new MobileEntity("Redmi",20000.0,"128GB","Frost White",48.0,true,"Android");
		//dao.saveMobileEntity(mobile);
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
		 //dao.avgPrice();
		//dao.updateMobilePriceByMobileBrand();
		 Scanner scanner = new Scanner(System.in);
//		 System.out.println("Enter Id");
//		 int mobileId= scanner.nextInt();
//		dao.getMobileEntityById(mobileId);
//		System.out.println("Enter mobileBrand");
//		 String mobilebrand= scanner.next();
//		dao.getMobileEntityByMobileBrand(mobilebrand);
//		System.out.println("Enter mobileId");
//		 int mobileId= scanner.nextInt();
//		dao.updateMobilePriceById(mobileId);
//		System.out.println("Enter mobileBrand");
//		 String mobileBrand= scanner.next();
//		dao.updateMobilePriceByMobileBrand(mobileBrand);
//		System.out.println("Enter mobileId");
//		 int mobileId= scanner.nextInt();
//		dao.deleteMobileEntityById(mobileId);
//		 System.out.println("Enter mobileBrand");
//		 String mobileBrand= scanner.next();
//		dao.deleteMobileEntityByBrand(mobileBrand);
		System.out.println("Enter Rom Size");
		 String rom= scanner.next();
		dao.updateMobilePriceByMobileRom(rom);
	 }
}