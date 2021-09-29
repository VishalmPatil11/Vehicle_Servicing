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

import com.app.pojos.Offer;
import com.app.pojos.User;
import com.app.pojos.Vehicle;
import com.app.pojos.Vendor;
import com.app.service.IUserService;

@RestController
@RequestMapping("/userdata")
public class ServerUserController {
	
	@Autowired
	private IUserService service;

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
	

		@GetMapping("/getuser/{u_id}")
		public ResponseEntity<?> getUserAccount(@PathVariable int u_id) {
		User a = null;
		try {
			a = service.getUserAccount(u_id);
			System.out.println("user in Server Controller GetUsermethod()==> "+a);
			return new ResponseEntity<User>(a, HttpStatus.OK);
		} catch (NoResultException e) {
			System.out.println("err in get summary " + e);
			return new ResponseEntity<String>("Invalid A/C details", HttpStatus.NOT_FOUND);
		}
	}

		
		
	/*	@GetMapping("/delete_vehicle/{v_id}")
		public ResponseEntity<?> deleteUserVehicle(@PathVariable int v_id) {
		String msg = "";
		try {
			System.out.println("\n\n\n\n\n\n\n\n\nuser in Server Controller Delete User Vehicle method()==> "+v_id+"\n\n\n\n\n\n\n\n");
			msg = service.deleteUserVehicle(v_id);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (NoResultException e) {
			System.out.println("err in get summary " + e);
			return new ResponseEntity<String>("Vehicle Not Deleted. Some Error Occured!!", HttpStatus.NOT_FOUND);
		}
	}

		*/
		
		@DeleteMapping("/deletevehicle/{v_id}")
		public String deleteUserVehicle(@PathVariable int v_id) {
			String msg = "";
				
			try {
				msg = service.deleteUserVehicle(v_id);
				System.out.println("User in Server Controller Delete User Vehicle method()==> " + msg);
				return msg;
			} catch (Exception e) {
				msg ="Vehicle Not Deleted exception aa gya";
			}
			return msg;
		}


	
	//Login User Account
	@PostMapping("/login")
	public User loginUserAccount(@RequestBody User u) {
		System.out.println("Rest Server In Post Method -- > User Details: " + u);
		User user = service.loginUserAccount(u.getU_email(),u.getU_password());
		user.getU_vehicles().size();
			System.out.println("Mazya Gadya server controller"+user.getU_vehicles());
		System.out.println("\n\n\n\n My User"+user+"\n\n\n\n\n\n");
		
		return user;
		
	}

	
	
	//Create New User Account
	@PostMapping("/register")
	public User createUserAccount(@RequestBody User u) {
		System.out.println("Rest Server In Post Method -- > User Details: " + u);
		return service.createUserAccount(u);
	}

	//Create New Account Add Vehicle Into User Account
	@PostMapping("/registerVehicle")
	public String createUserAccountAddVehicle(@RequestBody Vehicle vehicle) {
		System.out.println("\n\n\n\n\n\n\nRest Server In Post Method -- > User Details With Add Vehicle: " + vehicle+"\n\n\n\n\n\n");
		return service.createUserAccountAddVehicle(vehicle);
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
	
	
	
	@GetMapping("/getallvendorshops")
	public List<Vendor> getAllVendorShops() {
		return service.getAllVendorShops();
	}
	

	@GetMapping("/getallvendorshopssearch/{search}")
	public List<Vendor> getAllVendorShopsBySearch(@PathVariable String search) {
		System.out.println("\n\n\\nSearch = "+search+"\n\n\n");
		return service.getAllVendorShopsBySearch(search);
	}
	
	
	
	@GetMapping("/gettodaysoffershops")
	public List<Vendor> getTodaysOfferOnShops() {
		return service.getTodaysOfferOnShops();
	}
	

	@GetMapping("/gettodaysoffers")
	public List<Offer> getTodaysOffers() {
		return service.getTodaysOffers();
	}
	
	
	@GetMapping("/getvisitvendorshopsearch/{ven_id}")
	public List<Vendor> geVisitVendorShopsBySearch(@PathVariable int ven_id) {
		System.out.println("\n\n\\nVisit Shop Search = "+ven_id+"\n\n\n");
		return service.getVisitVendorShopsBySearch(ven_id);
	}
	
}

