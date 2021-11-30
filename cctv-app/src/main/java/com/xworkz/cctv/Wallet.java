package com.xworkz.cctv;

public class Wallet {
  private String color;
  private String brand;
  private Material material;
  private double price;
  private Money money;
  private ATMCard atmCard;
  private Photo photo;
  
  public Wallet() {
	  System.out.println(this.getClass().getSimpleName()+ "Bean Created");
  }

public Wallet(String color, String brand, Material material, double price, Money money, ATMCard atmCard,Photo photo) {
	super();
	this.color = color;
	this.brand = brand;
	this.material = material;
	this.price = price;
	this.money = money;
	this.atmCard = atmCard;
	this.photo = photo;
	 System.out.println(this.getClass().getSimpleName()+ "Bean Created");
}
  
//  public static void main(String[] args) {
//	  Material material = new Material();
//	  Money money = new Money();
//	  ATMCard card = new ATMCard();
//	  Photo photo = new Photo();
//	  
//	  Wallet wallet = new Wallet("black","puma",material,1000.00,money,card,photo);
//  }
}
