

package com.app.controller;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.MasterService;
import com.app.pojos.Mechanic;
import com.app.pojos.Offer;
import com.app.pojos.Service_Taken_Vendor;
import com.app.pojos.User;
import com.app.pojos.Vendor;
import com.app.service.IVendorService;


@RestController
@RequestMapping("/vendordata")
public class ServerVendorController {
	
	@Autowired
	private IVendorService service;

/*	@GetMapping("/{email}/{password}")
	public ResponseEntity<?> getSummary(@PathVariable String email, @PathVariable String password) {
		User a = null;
		try {
			a = dao.getSummary(email, password);
			return new ResponseEntity<User>(a, HttpStatus.OK);
		} catch (NoResultException e) {
			System.out.println("err in get summary " + e);
			return new ResponseEntity<String>("Invalid A/C details", HttpStatus.NOT_FOUND);
		}
	}
*/
	
	
	
	
	@GetMapping("/getvendor/{ven_id}")
	public ResponseEntity<?> getVendorAccount(@PathVariable int ven_id) {
	Vendor a = null;
	try {
		a = service.getVendorAccount(ven_id);
		System.out.println("user in Server Controller GetUsermethod()==> "+a);
		return new ResponseEntity<Vendor>(a, HttpStatus.OK);
	} catch (NoResultException e) {
		System.out.println("err in get summary " + e);
		return new ResponseEntity<String>("Invalid A/C details", HttpStatus.NOT_FOUND);
	}
}
	
	
	
	
	//Login Vendor Account
	@PostMapping("/login")
	public Vendor loginVendorAccount(@RequestBody Vendor v) {
		System.out.println("Rest Server In Post Method -- > Vendor Details: " + v);
		Vendor vendor = service.loginVendorAccount(v.getVen_email(),v.getVen_password());
		//	vendor.getVen_vehicles();
		System.out.println("\n\n\n\n My Vendor"+vendor+"\n\n\n\n\n\n");
		
		return vendor;

	}

	
	
	//Create New Vendor Account
	@PostMapping("/register")
	public String createVendorAccount(@RequestBody Vendor v) {
		System.out.println("Rest Server In Post Method -- > Vendor Details: " + v);
		return service.createVendorAccount(v);
	}
	
	
		//Create New Offer To Vendor Account
		@PostMapping("/addoffer")
		public String addOffer(@RequestBody Offer offer) {
			System.out.println("Rest Server In Post Method -- > Add Offer Details: " + offer);
			return service.addOffer(offer);
		}
	
		
		@DeleteMapping("/deleteoffer/{ofr_id}")
		public String deleteOffer(@PathVariable int ofr_id) {
			String msg = "";
				
			try {
				msg = service.deleteOffer(ofr_id);
				System.out.println("Vendor in Server Controller Delete Vendor Offer method()==> " + msg);
				return msg;
			} catch (Exception e) {
				msg ="Offer Not Deleted exception aa gya";
			}
			return msg;
		}


		
		
		
		//Create New Offer To Vendor Account
				@PostMapping("/addmechanic")
				public String addMechanic(@RequestBody Mechanic mechanic) {
					System.out.println("Rest Server In Post Method -- > Add Mechanic's Details: " + mechanic);
					return service.addMechanic(mechanic);
				}
			
				
				@DeleteMapping("/deletemechanic/{mech_id}")
				public String deleteMechanic(@PathVariable int mech_id) {
					String msg = "";
						
					try {
						msg = service.deleteMechanic(mech_id);
						System.out.println("Vendor in Server Controller Delete Vendor Mechanic's Information method()==> " + msg);
						return msg;
					} catch (Exception e) {
						msg ="Mechanic's Details Not Deleted. Some Exception Occured.";
					}
					return msg;
				}

		
		
				//Get All Services From Master Service Table To Vendor Account
				@GetMapping("/showservices")
				public List<MasterService> showMasterServices() {
					System.out.println("Rest Server In Post Method -- > Show MasterServices Details: " );
					return service.showMasterServices();
				}
				

				//Get All Services From Vendor Service Table To Vendor Account
				@GetMapping("/showvendorservices")
				public List<Service_Taken_Vendor> showVendorServices() {
					System.out.println("Rest Server In Post Method -- > Show VendorServices Details:" );
					return service.showVendorServices();
				}

				
				
				
			//Add New Services To Vendor Account
			@PostMapping("/addvendorservices")
			public String addVendorServices(@RequestBody Service_Taken_Vendor stv_services) {
				System.out.println("\n\n\n\n\nRest Server In Post Method -- > Add Services To Vendor Details: " + stv_services.toString()+"\n\n\n\n\n\n");
				return service.addVendorServices(stv_services);
			}
	
		
/*	// update account
	@PutMapping("/{amount}")
	public ResponseEntity<String> updateAccount(@RequestBody BankAccount a, @PathVariable double amount) {
		System.out.println("rest server put: " + a + " " + amount);
		try {
			// validate a/c
			BankAccount validAc = dao.getSummary(a.getAcctId(), a.getPin());
			// a/c validated
			validAc.setBalance(validAc.getBalance() + amount);
			return new ResponseEntity<>(dao.updateAccount(validAc), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NO_CONTENT);
		}
	}

	// close a/c
	@DeleteMapping("/{id}/{pin}")
	public ResponseEntity<String> closeAccount(@PathVariable int id, @PathVariable int pin) {
		try {

			return new ResponseEntity<String>(dao.closeAccount(id, pin), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NO_CONTENT);
		}
	}
*/
	
	
	
	
	
	
	
	
}





