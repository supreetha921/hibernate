package com.hibernate.hibernateapp.entity;

import java.io.File;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Table(name="mobile_details")
@Entity//if we don't use,hibernate will not consider as entity
	public class MobileEntity {
		
	@Id	//metadata
		@Column(name= "mobile_id")
	@GeneratedValue(generator="abc")
	@GenericGenerator(name="abc",strategy="increment")
	 private int mobileId;

	@Column//just mention column name
	
	(name="mobile_brand")
	private String mobileBrand;

	@Column(name="mobile_price")
	private double mobilePrice;

	

	@Column(name="mobile_rom")
	private String rom;

	@Column(name="mobile_color")
	private String color;

	@Column(name="mobile_camera")
	private double cameraInPicel;

	@Column(name="mobile_fingerprint")
	private boolean isFingerPrintAvailable;

	@Column(name="mobile_ostype")
	private String ostype;

	public MobileEntity() {
		System.out.println("default constructor invoked");
	}
	
	



	public MobileEntity(String mobileBrand, double mobilePrice, String rom, String color, double cameraInPicel, boolean isFingerPrintAvailable, String ostype) {
		super();
		//this.mobileId = mobileId;
		this.mobileBrand = mobileBrand;
		this.mobilePrice = mobilePrice;
		this.rom = rom;
		this.color = color;
		this.cameraInPicel = cameraInPicel;
		this.isFingerPrintAvailable = isFingerPrintAvailable;
		this.ostype = ostype;
	}

	public int getMobileId() {
		return mobileId;
	}

	public void setMobileId(int mobileId) {
		this.mobileId = mobileId;
	}

	public String getMobileBrand() {
		return mobileBrand;
	}

	public void setMobileBrand(String mobileBrand) {
		this.mobileBrand = mobileBrand;
	}

	public double getMobilePrice() {
		return mobilePrice;
	}

	public void setMobilePrice(double mobilePrice) {
		this.mobilePrice = mobilePrice;
	}

	public String getRom() {
		return rom;
	}

	public void setRom(String rom) {
		this.rom = rom;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getCameraInPicel() {
		return cameraInPicel;
	}

	public void setCameraInPicel(double cameraInPicel) {
		this.cameraInPicel = cameraInPicel;
	}

	public boolean isFingerPrintAvailable() {
		return isFingerPrintAvailable;
	}

	public void setFingerPrintAvailable(boolean isFingerPrintAvailable) {
		this.isFingerPrintAvailable = isFingerPrintAvailable;
	}

	public String getOstype() {
		return ostype;
	}

	public void setOstype(String ostype) {
		this.ostype = ostype;
	}


	@Override
	public String toString() {
		return "MobileEntity [mobileId=" + mobileId + ", mobileBrand=" + mobileBrand + ", mobilePrice=" + mobilePrice
				+ ", rom=" + rom + ", color=" + color + ", cameraInPicel=" + cameraInPicel + ", isFingerPrintAvailable="
				+ isFingerPrintAvailable + ", ostype=" + ostype + "]";
	}

		
		
	}

