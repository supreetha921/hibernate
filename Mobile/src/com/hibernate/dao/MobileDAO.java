package com.hibernate.dao;

import com.hibernate.hibernateapp.entity.MobileEntity;

public interface MobileDAO {
	//void saveMobileEntity();
	void  getMobileEntity();
	void updateMobileEntity();
	void deleteMobileEntity();
	void getAllMobileEntity();
	void getMobileBrandById();
	void getMobileEntityById();
	void deleteById();
	void updateById();
	void maxPriceOfMobile();
	void totalMobileBrand();
	void orderByMobileName();
	void totalPrice();
	void avgPrice();
	void updateMobilePriceByMobileBrand();
	void saveMobileEntity(MobileEntity mobileEntity);
	void getMobileEntityById(int mobileId);
	void getMobileEntityByMobileBrand(String mobileBrand);
	void updateMobilePriceById(int mobileId);
	void updateMobilePriceByMobileBrand(String mobileBrand);
	void updateMobilePriceByMobileRom(String mobileRom);
	void deleteMobileEntityById(int mobileId);
	void deleteMobileEntityByBrand(String mobileBrand);

}
