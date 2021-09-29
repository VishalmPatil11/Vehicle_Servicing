package com.app.dao;

import java.util.List;

import com.app.pojos.MasterService;
import com.app.pojos.Mechanic;
import com.app.pojos.Offer;
import com.app.pojos.Service_Taken_Vendor;
import com.app.pojos.Vendor;

public interface IVendorDao {

	public String createVendorAccount(Vendor u);
	
	public Vendor loginVendorAccount(String ven_email,String ven_password);

	public Vendor getVendorAccount(int ven_id);
	
	public String addOffer(Offer offer);
	
	public String deleteOffer(int ofr);
	
	public String addMechanic(Mechanic mechanic);

	public String deleteMechanic(int mech);
	
	public List<MasterService> showMasterServices();

	public List<Service_Taken_Vendor> showVendorServices();
	
	public String addVendorServices(Service_Taken_Vendor stv_services);
	
	
}
