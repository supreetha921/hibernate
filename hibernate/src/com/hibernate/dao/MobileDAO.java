package com.hibernate.dao;

public interface MobileDAO {
	void saveMobileEntity();
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

}
