package com.app.service;

import java.util.List;

import com.app.pojos.Offer;
import com.app.pojos.User;
import com.app.pojos.Vehicle;
import com.app.pojos.Vendor;

public interface IUserService {

	User loginUserAccount(String u_email,String u_password);

	User createUserAccount(User u);

	String createUserAccountAddVehicle(Vehicle vehicle);

	User getUserAccount(int u_id);

	String deleteUserVehicle(int v_id);

	List<Vendor> getAllVendorShops();

	List<Vendor> getAllVendorShopsBySearch(String search);
	
	List<Vendor> getVisitVendorShopsBySearch(int ven_id);
	
	List<Vendor> getTodaysOfferOnShops();

	List<Offer> getTodaysOffers();

}
