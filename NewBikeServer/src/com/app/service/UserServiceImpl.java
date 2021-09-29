package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IUserDao;
import com.app.pojos.Offer;
import com.app.pojos.User;
import com.app.pojos.Vehicle;
import com.app.pojos.Vendor;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	public IUserDao dao;
	
	@Override
	public User loginUserAccount(String u_email, String u_password) {
	User u =	dao.loginUserAccount(u_email,u_password);
		System.out.println("In Service Layer======"+u);
	 //return	dao.loginUserAccount(u_email,u_password);
		return u;
	}

	@Override
	public User createUserAccount(User u) {
		return dao.createUserAccount(u);
	}

	@Override
	public String createUserAccountAddVehicle(Vehicle vehicle) {
		return dao.createUserAccountAddVehicle(vehicle);
		}


	@Override
	public User getUserAccount(int u_id) {
		User user = dao.getUserAccount(u_id);
		return user;
	}

	@Override
	public String deleteUserVehicle(int v_id) {
		String msg = dao.deleteUserVehicle(v_id);
		return msg;
	}

	@Override
	public List<Vendor> getAllVendorShops() {
		return dao.getAllVendorShops();
	}

	@Override
	public List<Vendor> getAllVendorShopsBySearch(String search) {
		return dao.getAllVendorShopsBySearch(search);
	}

	@Override
	public List<Vendor> getTodaysOfferOnShops() {
		return dao.getTodaysOfferOnShops();
	}

	@Override
	public List<Offer> getTodaysOffers() {
		return dao.getTodaysOffers();
	}

	@Override
	public List<Vendor> getVisitVendorShopsBySearch(int ven_id) {
		return dao.getVisitVendorShopsBySearch(ven_id);
	}


}
