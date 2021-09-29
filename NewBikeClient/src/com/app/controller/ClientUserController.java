package com.app.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.app.pojos.User;
import com.app.pojos.Vehicle;
import com.app.pojos.Vendor;

@Controller
@RequestMapping("/user")
public class ClientUserController {
	

	//FOR USER REST URL
	@Value("#{abc.REST_GET_URL}")
	private String getURL;
	
	@Value("#{abc.REST_POST_URL}")
	private String registerURL;
	
	@Value("#{abc.REST_USER_VEHICLE_POST_URL}")
	private String registerUserVehicleURL;
	
	@Value("#{abc.REST_PUT_URL}")
	private String putURL;
	
	@Value("#{abc.REST_DELETE_URL}")
	private String deleteURL;
	
	@Value("#{abc.REST_POST_LOGIN_URL}")
	private String loginURL;

	@Value("#{abc.REST_GET_USER_URL}")
	private String getUserURL;
	
	@Value("#{abc.REST_DELETE_USER_VEHICLE_URL}")
	private String deleteUserVehicleURL;

	
	
	//FOR VENDOR REST URL
	@Value("#{abc.VENDOR_LOGIN}")
	private String getLoginVendorURL;
	
	@Value("#{abc.REST_ALL_VENDOR_GET_URL}")
	private String getAllVendorURL;

	@Value("#{abc.REST_ALL_VENDOR_SEARCH_GET_URL}")
	private String getAllVendorSearchURL;

	@Value("#{abc.REST_VISIT_VENDOR_SEARCH_GET_URL}")
	private String getVisitVendorSearchURL;

	
	@Value("#{abc.REST_VENDOR_POST_URL}")
	private String registerVendorURL;
	
	@Value("#{abc.REST_VENDOR_PUT_URL}")
	private String putVendorURL;
	
	@Value("#{abc.REST_VENDOR_DELETE_URL}")
	private String deleteVendorURL;
	
	@Value("#{abc.REST_VENDOR_POST_LOGIN_URL}")
	private String loginVendorURL;

	@Value("#{abc.GET_TODAYS_VENDOR_OFFER}")
	private String getTodaysVendorOfferURL;

	
	@Autowired
	HttpSession session;




	
	
	
	@PostMapping("/checklogin")
	public String processVendorLoginForms(@RequestParam String email,@RequestParam String password,@RequestParam String role,RestTemplate template,RedirectAttributes flashMap) {
//		String url = "http://localhost:7070/NewBikeServer/vendordata/login";
		System.out.println("\n\n\n\n\n\n\n"+role+"\n\n\n\n\n\n\n\n\n");
		
	 if(role.equals("user")) {
			
			User u = new User(email, password);
		System.out.println("In process login user account form "+ loginURL + " " + u.getU_email()+u.getU_password());
		try {				
			User user = template.postForObject(loginURL, u, User.class);
			String msg = "";
			
			if(user!=null) {						
			if(u.getU_email().equals(user.getU_email()) && (u.getU_password().equals(user.getU_password()))) {
				msg = "Welcome ";
				flashMap.addFlashAttribute("status", msg+user.getU_first_name());
				System.out.println("\n\n\n\n\nUser Data Hi walaa data" +user.getU_vehicles()+"\n\\n\n");
				session.setAttribute("session_user", user);
			//	session.setAttribute("session_user_vehicles",user.getU_vehicles());				
				return "redirect:/user/profile";
			}
			}
		} catch (RestClientException e) {
			flashMap.addFlashAttribute("status","User Not Found!!Please Check You Credentials Once.");
		}
		return "redirect:/user/login";
	 }else if(role.equals("vendor")) {

			Vendor v = new Vendor(email, password);
			System.out.println("In process login vendor account form "+ loginVendorURL + " " + v.getVen_email()+v.getVen_password());
			try {				
				Vendor vendor = template.postForObject(loginVendorURL, v, Vendor.class);
				String msg = "";
				
				if(vendor!=null) {						
				if(v.getVen_email().equals(vendor.getVen_email()) && (v.getVen_password().equals(vendor.getVen_password()))) {
					msg = "Welcome ";
					flashMap.addFlashAttribute("status", msg+vendor.getVen_first_name()+"!");
					System.out.println("\n\n\n\n\nUser Data Hi walaa data" +vendor+"\n\\n\n");
					session.setAttribute("session_vendor", vendor);
					//Add More to Session future Use
					return "redirect:/vendor/profile";
				}
				}
			} catch (RestClientException e) {
				flashMap.addFlashAttribute("status", "Vendor Not Found!!Please Check You Credentials Once.");
			}
			return "redirect:/vendor/login";
		 
	 }
	 return "redirect:/";
	 }

	 

/*	
	@PostMapping("/checklogin")
	public String processVendorLoginForms(@RequestParam String email,@RequestParam String password,@RequestParam String role,RestTemplate template,RedirectAttributes flashMap,HttpSession session) {
//		String url = "http://localhost:7070/NewBikeServer/vendordata/login";
		System.out.println("\n\n\n\n\n\n\n"+role+"\n\n\n\n\n\n\n\n\n");
		
	 if(role.equals("user")) {
			
			User u = new User(email, password);
		System.out.println("In process login user account form "+ loginURL + " " + u.getU_email()+u.getU_password());
		try {				
			User user = template.postForObject(loginURL, u, User.class);
			String msg = "";
			
			if(user!=null) {						
			if(u.getU_email().equals(user.getU_email()) && (u.getU_password().equals(user.getU_password()))) {
				msg = "Welcome ";
				flashMap.addFlashAttribute("status", msg+user.getU_first_name());
				System.out.println("\n\n\n\n\nUser Data Hi walaa data" +user+"\n\\n\n");
				session.setAttribute("session_user", user);
				return "redirect:/user/profile";
			}
			}
		} catch (RestClientException e) {
			flashMap.addFlashAttribute("status", e.getMessage()+"User Not Found");
		}
		return "redirect:/user/login";
	 }else if(role.equals("vendor")) {

			Vendor u = new Vendor(email, password);
			System.out.println("In process login vendor account form "+ loginVendorURL + " " + u.getVen_email()+u.getVen_password());
			try {				
				Vendor user = template.postForObject(loginVendorURL, u, Vendor.class);
				String msg = "";
				
				if(user!=null) {						
				if(u.getVen_email().equals(user.getVen_email()) && (u.getVen_password().equals(user.getVen_password()))) {
					msg = "Welcome ";
					flashMap.addFlashAttribute("status", msg+user.getVen_first_name());
					System.out.println("\n\n\n\n\nUser Data Hi walaa data" +user+"\n\\n\n");
					session.setAttribute("session_vendor", user);
					return "redirect:/vendor/profile";
				}
				}
			} catch (RestClientException e) {
				flashMap.addFlashAttribute("status", e.getMessage()+"Vendor Not Found");
			}
			return "redirect:/vendor/login";
		 
	 }
	 return "redirect:/";
	 }


*/	

	
	
	@GetMapping("/logout")
	public String showUserLogoutForm() {
		System.out.println("In show logout / homepage form ");
		 session.invalidate();
		return "redirect:/user/login";
	}

		
		@GetMapping("/login")
		public String showUserLoginForm() {
			System.out.println("In show login / homepage form ");
			return "/user/login";
		}

		@PostMapping("/login")
		public String processUserLoginForm(@RequestParam String email,@RequestParam String password,RestTemplate template,RedirectAttributes flashMap) {
		//	String url = "http://localhost:7070/NewBikeServer/userdata/login";
		
				User u = new User(email, password);
	//		System.out.println("In process login user account form "+ loginURL + " " + u.getU_email()+u.getU_password());
			try {				
				User user = template.postForObject(loginURL, u, User.class);
				
				String msg = "";
				System.out.println("\n\n\n\n\nUser Data Hiiiii" +user+"\n\\n\n");

				if(user!=null) {						
				if(u.getU_email().equals(user.getU_email()) && (u.getU_password().equals(user.getU_password()))) {
					msg = "Welcome ";
					flashMap.addFlashAttribute("status", msg+user.getU_first_name());
					System.out.println("\n\n\n\n\nUser Data Hi walaa data" +user+"\n\\n\n");
					session.setAttribute("session_user", user);
				//	session.setAttribute("session_user_vehicles",user.getU_vehicles());
					return "redirect:/user/profile";
				}
				}
			} catch (RestClientException e) {
				flashMap.addFlashAttribute("status", e.getMessage()+"User Not Found");
			}
			return "redirect:/user/login";
		}

		
		
		@GetMapping("/profile")
		public String showUserProfile() {
			System.out.println(" \n\n\n\n\n\nClient USER Profile\n\n\n\n\n\n\n ");
			return "/user/profile";
		}		
	

		@GetMapping("/register")
		public String showUserRegisterForm(User u) {
			System.out.println("Register account form of USER " + u);
			return "/user/register";
		}

		
		
		@PostMapping("/register")
		public String processCreateForm(User u, RestTemplate template, RedirectAttributes flashMap) {
			System.out.println("In process create user account form "+ registerURL + " " + u);
			try {
				//Invoke REST API to create new user account
				User user = template.postForObject(registerURL, u, User.class);
				flashMap.addFlashAttribute("status",user);
				session.setAttribute("session_user", user);
			} catch (RestClientException e) {
				flashMap.addFlashAttribute("status","NULL Error, In Register User! Please Check You Details Once.");
				return "redirect:/user/register";
			}
			return "redirect:/user/registerVehicle";
		}
		
		
		@GetMapping("/registerVehicle")
		public String showUserRegisterVehicleForm(Vehicle vehicle) {
			System.out.println("\n\n\n\n\nRegister account form of USER to Add Vehicles " + vehicle +"\n\n\n\n\n");
				return "/user/registerVehicle";
		}

		
		
		@PostMapping("/registerVehicle")
		public String processCreateVehicleForm(Vehicle vehicle, RestTemplate template, RedirectAttributes flashMap) {
			//@RequestParam String v_company_name,@RequestParam String v_model,@RequestParam String v_regNo
			System.out.println("\n\n\n\nIn process create user account form to add Vehicle "+ registerUserVehicleURL + " " + vehicle +"\n\n\n\n\n");
		//	System.out.println("user id register chi "+ u+"\n\n\n\n\n\n\n");	
			try {
				//Invoke REST API to create new user account
	// List<Vehicle> u_vehicles = new ArrayList<Vehicle>();
			
			//System.out.println("User Register"+user+"\n\n\n\n\n\n");
			
			//Vehicle v = new Vehicle(v_company_name, v_model, v_regNo, user);
                           User u = (User) session.getAttribute("session_user");				
                           	
                           
							System.out.println("\n\n\n\n\n\nUser maza"+u+"\n\n\n\n\n\n\n");
                           
                           vehicle.setV_user(u);
                           

                           System.out.println("My vehicles ===>  "+vehicle.getV_company_name());
											
							
							System.out.println("\n\n\n\n\n\nUser maza"+u+"\n\n\n\n\n\n\n");
				//			System.out.println("\n\n\n\n\n\nUser's Vehicles in register Vehicle CLient Side"+u.getU_vehicles()+"\n\n\n\n\n\n\n");
		
				String msg = template.postForObject(registerUserVehicleURL, vehicle, String.class);
				
				flashMap.addFlashAttribute("status",msg);
				
				User user = template.getForObject(getUserURL,User.class,u.getU_id());
				//Updated Session Values
                session.setAttribute("session_user", user);

			} catch (RestClientException e) {
				flashMap.addFlashAttribute("status", e.getMessage()+"Sorry, This Vehicle is Already Registered, Please Check You Details Once.");
				return "redirect:/user/registerVehicle";
			}
			return "redirect:/user/profile";
		}
	
		
		
		
		
		@GetMapping("/deletevehicle")
		public String showUserProfileAfterDeleteVehicle(@RequestParam int v_id, RestTemplate template, RedirectAttributes flashMap) {
			System.out.println(" \n\n\n\n\n\nClient USER Vehicle Delete Method\n\n\n\n\n\n\n ");		
			System.out.println("\n\n\n\nIn process delete vehicle user form to delete Vehicle "+ deleteUserVehicleURL + " " + v_id +"\n\n\n\n\n");

			try {
						
				 template.delete(deleteUserVehicleURL, v_id);
		//	 template.postForObject(deleteUserVehicleURL,String.class, String.class,v_id);
				 
				 
				//Updated Session Values
				 User u = (User) session.getAttribute("session_user");				
		         User user = template.getForObject(getUserURL,User.class,u.getU_id());  
		         session.setAttribute("session_user", user);
		         
				 flashMap.addFlashAttribute("status","Vehicle Deleted Successfully!!");
				
			} catch (RestClientException e) {
				flashMap.addFlashAttribute("status", e.getMessage()+"Sorry, This Vehicle is Not Registered, Please Check Your Details Once.");
				return "redirect:/user/profile";
			}
			return "redirect:/user/profile";
		}
	
		

		
		@SuppressWarnings("unchecked")
		@GetMapping("/vendorshops")
		public String showVendorShopsForm(RestTemplate template, RedirectAttributes flashMap) {
			
				 System.out.println("In show Vendor Shops form  Client");
				 //Updated Session Values
				 List<Vendor> vendor = (List<Vendor>) template.getForObject(getAllVendorURL,List.class);
				 session.setAttribute("session_vendor", vendor);				 
				 return "/user/vendorshops";
		}

		



		
		

		
		@SuppressWarnings("unchecked")
		@GetMapping("/vendorshopssearch")
		public String showVendorShopsForm(@RequestParam String search ,RestTemplate template, RedirectAttributes flashMap) {
			
			 System.out.println("In show Vendor Shops Search form  Client ");
		
				 //Updated Session Values
				 List<Vendor> vendor = (List<Vendor>) template.getForObject(getAllVendorSearchURL,List.class,search);
				 session.setAttribute("session_vendor", vendor);				 
			 
			 return "/user/vendorshopssearch";
		}



		@SuppressWarnings("unchecked")
		@GetMapping("/todaysoffer")
		public String showTodaysOffer(RestTemplate template, ModelMap map) {
				 System.out.println("In show Today's Offer Shops form  Client");
				 //Updated Session Values
				 List<Vendor> vendor = (List<Vendor>) template.getForObject(getTodaysVendorOfferURL,List.class);
				 
				 session.setAttribute("session_vendor",vendor);				 
				 return "/user/todaysoffer";
		}
		
		
		

		@SuppressWarnings("unchecked")
		@GetMapping("/visitvendorshop")
		public String showVisitVendorShopsForm(@RequestParam int ven_id ,RestTemplate template, RedirectAttributes flashMap) {
			System.out.println("In Visit Vendor Shops Visit Query form Client ");
				 //Updated Session Values
				 List<Vendor> vendor = (List<Vendor>) template.getForObject(getVisitVendorSearchURL,List.class,ven_id);
				 session.setAttribute("session_vendor", vendor);
				 return "/user/visitvendorshop";
			}
		
		

		@SuppressWarnings("unchecked")
		@GetMapping("/bookservice")
		public String showServiceForm(@RequestParam int ven_id ,RestTemplate template, RedirectAttributes flashMap) {
		
			System.out.println(" In show Book Service form Client ");
		
				 //Updated Session Values
				 List<Vendor> vendor = (List<Vendor>) template.getForObject(getVisitVendorSearchURL,List.class,ven_id);
				 session.setAttribute("session_vendor", vendor);				 
			return "/user/bookservice";
			
		}

@GetMapping("/about") 
public String showContactForm()
{
System.out.println("In contact form ");

return "/user/about";

  }
@PostMapping("/about") 
public String showContact()
{
System.out.println("Inprocess of  contact form ");

return "redirect:user/about";

  }
	

		
				
}
