package com.app.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.TemporalType;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Offer;
import com.app.pojos.User;
import com.app.pojos.Vehicle;
import com.app.pojos.Vendor;



@Repository
@Transactional
public class UserDaoImpl implements IUserDao {


	@Autowired
	private SessionFactory sf;
		
	
	@Override
	public User loginUserAccount(String u_email,String u_password) {
		System.out.println("DAO User email and password " + u_email + " " + u_password);
		String jpql ="SELECT u FROM User u where u.u_email =:email and u.u_password =:password";
	  User user =  sf.getCurrentSession()
		  	.createQuery(jpql,User.class)
		  	.setParameter("email",u_email)
		  	.setParameter("password",u_password)
		  	.getSingleResult();
	  System.out.println("User ==="+user);
	 
	  System.out.println("\n\nABCD MAZYA GADYA"+user.getU_vehicles().size()+"\n\n");
	 		
	 		
	  		user.getU_order().size();
	  
	  		System.out.println("\n\n\n\nDAO MAdhe User che Vehicles aahe  ka--------------"+user.getU_vehicles()+"\n\n\n\n");
	  
	  return user;
	}

	@Override
	public User createUserAccount(User u) {
		sf.getCurrentSession().save(u);
		System.out.println( "You Have Been Successfully Registered. " + u.getU_id() +"!! Just Add You Vehicle To Service");
		return u;
	}


	@Override
	public String createUserAccountAddVehicle(Vehicle vehicle) {
	sf.getCurrentSession().saveOrUpdate(vehicle);		
	return "Finnaly Registration Done, " + vehicle.getV_user().getU_first_name() +"!! Book Your Service Now.";
	}

	
	
	@Override
	public User getUserAccount(int u_id) {
		User user =	sf.getCurrentSession().get(User.class, u_id );
		user.getU_order().size();
		user.getU_vehicles().size();
		return user;
	}

	@Override
	public String deleteUserVehicle(int v_id) {
		System.out.println("In Server Vehicle About to Delete");
		Vehicle v = (Vehicle) sf.getCurrentSession().get(Vehicle.class,v_id);
		
		System.out.println("\n\n\ndelete kra yaar hi vehicle"+v+"\n\n\n\n");

		String status ="";
		
		try {
			if(v!=null){
			sf.getCurrentSession().delete(v);
			status ="Vehicle Deleted Successfully!!";
			System.out.println("delete kra yaar hi vehicle"+status);
			}else{
				status="Vehicle Not Deleted. Something Went Wrong";
				System.out.println("delete kra yaar hi vehicle"+status);		
			}
		} catch (HibernateException e) {
			status="Vehicle Not Deleted. Something Went Wrong.";
			System.out.println("delete kra yaar hi vehicle"+status);
		}
		return status;
	}

	@Override
	public List<Vendor> getAllVendorShops() {
	List<Vendor> vendor = null;
	String jpql = "select ven FROM Vendor ven ORDER BY ven.ven_shop_name DESC";
		vendor = (List<Vendor>) sf.getCurrentSession().createQuery(jpql, Vendor.class).getResultList();
		
			
		for (Vendor vendor2 : vendor) {
			System.out.println("\n\n\nVendor Name :"+vendor2.getVen_feedback().size());
			System.out.println("\n\n\nVendor Name :"+vendor2.getVen_mechanic().size());
			System.out.println("\n\n\nVendor Name :"+vendor2.getVen_offer().size());
			System.out.println("\n\n\nVendor Name :"+vendor2.getVen_order().size());			
			System.out.println("\n\n\nVendor Name :"+vendor2.getVen_services().size());			
		}
		
		return vendor;

	}

	@Override
	public List<Vendor> getAllVendorShopsBySearch(String search) {
		List<Vendor> vendor = null;
		String jpql = "Select ven FROM Vendor ven Where ven.ven_shop_name LIKE :search or ven.ven_address LIKE :search ORDER BY ven.ven_shop_name,ven.ven_address";
		vendor =  sf.getCurrentSession().createQuery(jpql, Vendor.class).setParameter("search", "%"+search+"%").getResultList();
		
		for (Vendor vendor2 : vendor) {
			System.out.println("\n\n\nVendor Name :"+vendor2.getVen_feedback().size());
			System.out.println("\n\n\nVendor Name :"+vendor2.getVen_mechanic().size());
			System.out.println("\n\n\nVendor Name :"+vendor2.getVen_offer().size());
			System.out.println("\n\n\nVendor Name :"+vendor2.getVen_order().size());	
			System.out.println("\n\n\nVendor Name :"+vendor2.getVen_services().size());			

		}
		
		return vendor;
	}

	

	
	
	@Override
	public List<Vendor> getTodaysOfferOnShops() {
		List<Vendor> vendor = null;
	
	
		Date validity = new Date();
		
//		String jpql = "select ven FROM Vendor ven ORDER BY ven.ven_shop_name DESC";
		String jpql = "SELECT ven FROM Vendor ven WHERE ven.ven_id in (SELECT ofr_vendor FROM Offer ofr WHERE ofr_validity = :validity ORDER BY ofr.ofr_validity DESC) ";
			vendor = (List<Vendor>) sf.getCurrentSession().createQuery(jpql, Vendor.class).setParameter("validity", validity, TemporalType.DATE).getResultList();
			
			for(Vendor vendor2 : vendor) {
				System.out.println("\n\n\nVendor Name :"+vendor2.getVen_feedback().size());
				System.out.println("\n\n\nVendor Name :"+vendor2.getVen_mechanic().size());
				System.out.println("\n\n\nVendor Name :"+vendor2.getVen_offer().size());
				System.out.println("\n\n\nVendor Name :"+vendor2.getVen_order().size());	
				System.out.println("\n\n\nVendor Name :"+vendor2.getVen_services().size());			
			}
			return vendor;
	}
	
	@Override
	public List<Offer> getTodaysOffers() {
	//	List<Vendor> vendor = null;
		List<Offer> offer = null;
		Date validity = new Date();
		String jpql = "SELECT ofr FROM Offer ofr WHERE ofr_validity >= :validity ORDER BY ofr.ofr_validity DESC limit 1";
		//String jpql = "SELECT ven FROM Vendor ven WHERE ven.ven_id in (SELECT ofr FROM Offer ofr WHERE ofr_validity >= :validity ORDER BY ofr.ofr_validity DESC) ";
		//vendor = (List<Vendor>) sf.getCurrentSession().createQuery(jpql, Vendor.class).setParameter("validity", validity, TemporalType.DATE).getResultList();
		offer = (List<Offer>) sf.getCurrentSession().createQuery(jpql, Offer.class).setParameter("validity", validity, TemporalType.DATE).getResultList();				      
		return offer;
	}
	

	@Override
	public List<Vendor> getVisitVendorShopsBySearch(int ven_id) {
		List<Vendor> vendor = null;
		String jpql = "Select ven FROM Vendor ven Where ven.ven_id =:ven_id ";
		vendor =  sf.getCurrentSession().createQuery(jpql, Vendor.class).setParameter("ven_id", ven_id).getResultList();
		
		for (Vendor vendor2 : vendor) {
			System.out.println("\n\n\nVendor Name :"+vendor2.getVen_feedback().size());
			System.out.println("\n\n\nVendor Name :"+vendor2.getVen_mechanic().size());
			System.out.println("\n\n\nVendor Name :"+vendor2.getVen_offer().size());
			System.out.println("\n\n\nVendor Name :"+vendor2.getVen_order().size());	
			System.out.println("\n\n\nVendor Name :"+vendor2.getVen_services().size());			

		}
		
		return vendor;
	}


	
	
}