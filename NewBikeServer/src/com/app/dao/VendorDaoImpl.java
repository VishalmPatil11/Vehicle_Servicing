package com.app.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.MasterService;
import com.app.pojos.Mechanic;
import com.app.pojos.Offer;
import com.app.pojos.Service_Taken_Vendor;
import com.app.pojos.User;
import com.app.pojos.Vendor;



@Repository
@Transactional
public class VendorDaoImpl implements IVendorDao {


	@Autowired
	private SessionFactory sf;
	
	@Override
	public String createVendorAccount(Vendor v) {
		sf.getCurrentSession().save(v);
		return "You Have Been Successfully Registered!!" + v.getVen_first_name();
		}

	
	
	@Override
	public Vendor loginVendorAccount(String ven_email,String ven_password) {
		System.out.println("DAO Vendor email and password " + ven_email + " " + ven_password);
		String jpql ="SELECT v FROM Vendor v where v.ven_email=:email and v.ven_password=:password";
	  Vendor vendor =  sf.getCurrentSession()
		  	.createQuery(jpql,Vendor.class)
		  	.setParameter("email",ven_email)
		  	.setParameter("password",ven_password)
		  	.getSingleResult();
	  
	  vendor.getVen_mechanic().size();
	  vendor.getVen_feedback().size();
	  vendor.getVen_offer().size();
	  vendor.getVen_order().size();
	  vendor.getVen_services().size();
	 
	  return vendor;
	}



	@Override
	public String addOffer(Offer offer) {
		sf.getCurrentSession().save(offer);
		return "You Have Been Successfully Created Offer For Your Shop!!" + offer.getOfr_name();		
	}



	@Override
	public String deleteOffer(int ofr) {
	
		System.out.println("In Server Offer About to Delete");
		Offer offer = (Offer) sf.getCurrentSession().get(Offer.class,ofr);
		
		System.out.println("\n\n\ndelete kra yaar hi Offer"+offer+"\n\n\n\n");

		String status ="";
		
		try {
			if(offer!=null){
			sf.getCurrentSession().delete(offer);
			status ="Offer Deleted Successfully!!";
			System.out.println("delete kra yaar hi Offer"+status);
			}else{
				status="Offer Not Deleted. Something Went Wrong";
				System.out.println("delete nahi hot aahe hi Offer"+status);		
			}
		} catch (HibernateException e) {
			status="Offer Not Deleted. Something Went Wrong. Aani Exception";
			System.out.println("delete nahi hot aahe yaar hi offer"+status);
		}
		return status;

	}




	@Override
	public Vendor getVendorAccount(int ven_id) {
		Vendor vendor = sf.getCurrentSession().get(Vendor.class,ven_id);
		vendor.getVen_mechanic().size();
		vendor.getVen_offer().size();
		vendor.getVen_order().size();
		vendor.getVen_services().size();	
		vendor.getVen_feedback().size();
		
		return vendor;
	}



	@Override
	public String addMechanic(Mechanic mechanic) {
		sf.getCurrentSession().save(mechanic);
		return "Mechanic's Details Added Successfully!!" + mechanic.getMech_first_name();		
	}



	@Override
	public String deleteMechanic(int mech) {
		System.out.println("In Server Mechanical Details About to Delete");
		Mechanic mechanic = (Mechanic) sf.getCurrentSession().get(Mechanic.class,mech);
		
		System.out.println("\n\n\ndelete the mechanic"+mechanic+"\n\n\n\n");

		String status ="";
		
		try {
			if(mechanic!=null){
			sf.getCurrentSession().delete(mechanic);
			status ="Mechanics Details Deleted Successfully!!";
			System.out.println("delete the mechanic"+status);
			}else{
				status="Mechanic's Details Are Not Deleted. Something Went Wrong";
				System.out.println("Not Deleting the Mechanic"+status);		
			}
		} catch (HibernateException e) {
			status="Mechanic Not Deleted. Something Went Wrong. Aani Exception";
			System.out.println("Not Deleted the Mechanic"+status);
		}
		return status;
		
	}



	@Override
	public List<MasterService> showMasterServices() {
		List<MasterService> services = null;
		String jpql = "Select ser FROM MasterService ser";		
		services = sf.getCurrentSession().createQuery(jpql,MasterService.class).getResultList();
		System.out.println("\n\n\n\nlist of master Services ==> "+services+"\n\n\n");
		return services;
	}

	@Override
	public List<Service_Taken_Vendor> showVendorServices() {
		List<Service_Taken_Vendor> services = null;
		String jpql = "Select ser FROM Service_Taken_Vendor ser";		
		services = sf.getCurrentSession().createQuery(jpql,Service_Taken_Vendor.class).getResultList();
		System.out.println("\n\n\n\nlist of vendor services ==> "+services+"\n\n\n");
		return services;	
		}
	
	
	@Override
	public String addVendorServices(Service_Taken_Vendor stv_services) {
		sf.getCurrentSession().save(stv_services);
		return "Services Added To Your Account Successfully...";
	}



	



}
