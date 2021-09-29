package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IVendorDao;
import com.app.pojos.Mechanic;
import com.app.pojos.Offer;
import com.app.pojos.Service_Taken_Vendor;
import com.app.pojos.Vendor;
import com.app.pojos.MasterService;

@Service
public class VendorServiceImpl implements IVendorService {

	@Autowired
	public IVendorDao dao;
	
	@Override
	public Vendor loginVendorAccount(String ven_email, String ven_password) {
	 return	dao.loginVendorAccount(ven_email,ven_password);
	}

	@Override
	public String createVendorAccount(Vendor v) {
		return dao.createVendorAccount(v);
	}

	@Override
	public String addOffer(Offer offer) {		
		return dao.addOffer(offer);
	}

	@Override
	public String deleteOffer(int ofr) {		
		return dao.deleteOffer(ofr);
	}

	@Override
	public Vendor getVendorAccount(int ven_id) {
		return dao.getVendorAccount(ven_id);
	}

	@Override
	public String addMechanic(Mechanic mechanic) {
	return	dao.addMechanic(mechanic);
	}

	@Override
	public String deleteMechanic(int mech) {
		return dao.deleteMechanic(mech);
	}

	@Override
	public List<MasterService> showMasterServices() {
		System.out.println("\n\n\n\nlist of master service in service layer => "+dao.showMasterServices()+"\n\n\n\n\n\n");
		return dao.showMasterServices();
	}
	
	
	@Override
	public List<Service_Taken_Vendor> showVendorServices() {
		System.out.println("\n\n\n\nlist of vendor services in service layer => "+dao.showMasterServices()+"\n\n\n\n\n\n");
		return dao.showVendorServices();	
	}

	
	@Override
	public String addVendorServices(Service_Taken_Vendor stv_services) {
		return dao.addVendorServices(stv_services);
	}






}
