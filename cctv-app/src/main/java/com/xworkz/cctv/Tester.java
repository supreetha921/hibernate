package com.xworkz.cctv;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tester {
	public static void main(String[] args) {
		String springConfigFile = "spring.xml";
		ApplicationContext springContainer = new ClassPathXmlApplicationContext(springConfigFile);
		System.out.println("springContainer is created" +springContainer);
		
		Cctv cctv = springContainer.getBean(Cctv.class);
		//System.out.println(cctv);
		System.out.println(cctv.getBrand());
		System.out.println(cctv.getColor());
		System.out.println(cctv.getCameraSize());
		System.out.println(cctv.getColor());
		cctv.record();
		cctv.autoDelete();
		
		//Cctv cctv1 = new Cctv();
		//cctv1.setBrand("samsung");
		
		
		
		String string = springContainer.getBean(String.class);
		System.out.println(string);
		
		
		Wallet wallet = springContainer.getBean(Wallet.class);
		Object walletObject = springContainer.getBean("walletID");
		System.out.println("walletobject" + walletObject);
		Wallet w = (Wallet) walletObject;
		System.out.println("walletobject" + w);
		
	}

}
