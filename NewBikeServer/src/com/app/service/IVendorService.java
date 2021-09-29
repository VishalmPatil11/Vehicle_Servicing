package com.app.service;

import com.app.pojos.Mechanic;
import com.app.pojos.Offer;
import com.app.pojos.Service_Taken_Vendor;

import java.util.List;

import com.app.pojos.MasterService;
import com.app.pojos.Vendor;

public interface IVendorService {

	Vendor loginVendorAccount(String ven_email,String ven_password);

	Vendor getVendorAccount(int ven_id);

	String createVendorAccount(Vendor v);

	String addOffer(Offer offer);
	
	String deleteOffer(int ofr);	
	
	String addMechanic(Mechanic mechanic);

	String deleteMechanic(int mech);

	List<MasterService> showMasterServices();
	
	List<Service_Taken_Vendor> showVendorServices();
	
	String addVendorServices(Service_Taken_Vendor stv_services);
	
}
