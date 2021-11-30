package com.xworkz.cctv;

public class Cctv {

private	String brand;
private	String cameraSize;
private	double price;
private String color;

public Cctv() {
	 System.out.println(this.getClass().getSimpleName()+ "object created");
	}

public Cctv(String brand, String cameraSize, double price, String color) {
	super();
	this.brand = brand;
	this.cameraSize = cameraSize;
	this.price = price;
	this.color = color;
}
public Cctv(String brand, String cameraSize) {
	super();
	this.brand = brand;
	this.cameraSize = cameraSize;
}


	public String getBrand() {
	return brand;
}



public void setBrand(String brand) {
	this.brand = brand;
}



public String getCameraSize() {
	return cameraSize;
}



public void setCameraSize(String cameraSize) {
	this.cameraSize = cameraSize;
}



public double getPrice() {
	return price;
}



public void setPrice(double price) {
	this.price = price;
}



public String getColor() {
	return color;
}



public void setColor(String color) {
	this.color = color;
}



	



	@Override
	public String toString() {
		return "cctv [brand=" + brand + ", cameraSize=" + cameraSize + ", price=" + price + ", color=" + color + "]";
	}

	public void record() {
		System.out.println("Invoked record()");
		
	}

	public void autoDelete() {
		System.out.println("Invoked autoDelete()");
	}




	



	

}
