package com.app.dao;

import java.util.List;

import com.app.pojos.Offer;
import com.app.pojos.User;
import com.app.pojos.Vehicle;
import com.app.pojos.Vendor;

public interface IUserDao {

	
	public User loginUserAccount(String u_email,String u_password);

	public User createUserAccount(User u);

	public String createUserAccountAddVehicle(Vehicle vehicle);

	public User getUserAccount(int u_id);

	public String deleteUserVehicle(int v_id);
	
	public 	List<Vendor> getAllVendorShops();

	public 	List<Vendor> getTodaysOfferOnShops();
	
	public List<Vendor> getAllVendorShopsBySearch(String search);

	public List<Vendor> getVisitVendorShopsBySearch(int ven_id);

	List<Offer> getTodaysOffers();
}
