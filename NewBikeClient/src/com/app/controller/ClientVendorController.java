package com.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.MasterService;
import com.app.pojos.Mechanic;
import com.app.pojos.Offer;
import com.app.pojos.Service_Taken_Vendor;
import com.app.pojos.User;
import com.app.pojos.Vendor;

@Controller
@RequestMapping("/vendor")
public class ClientVendorController {

	// FOR USER REST URL
	@Value("#{abc.REST_GET_URL}")
	private String getURL;
	@Value("#{abc.REST_POST_URL}")
	private String registerURL;
	@Value("#{abc.REST_PUT_URL}")
	private String putURL;
	@Value("#{abc.REST_DELETE_URL}")
	private String deleteURL;
	@Value("#{abc.REST_POST_LOGIN_URL}")
	private String loginURL;

	// FOR VENDOR REST URL
	@Value("#{abc.GET_VENDOR}")
	private String getVendorURL;
	@Value("#{abc.VENDOR_LOGIN}")
	private String getLoginVendorURL;
	@Value("#{abc.REST_VENDOR_POST_URL}")
	private String registerVendorURL;
	@Value("#{abc.REST_VENDOR_PUT_URL}")
	private String putVendorURL;
	@Value("#{abc.REST_VENDOR_DELETE_URL}")
	private String deleteVendorURL;
	@Value("#{abc.REST_VENDOR_POST_LOGIN_URL}")
	private String loginVendorURL;
	@Value("#{abc.ADD_OFFER}")
	private String addOfferURL;
	@Value("#{abc.DELETE_OFFER}")
	private String deleteVendorOfferURL;
	@Value("#{abc.ADD_MECHANIC}")
	private String addMechanicURL;
	@Value("#{abc.DELETE_MECHANIC}")
	private String deleteVendorMechanicURL;
	@Value("#{abc.SHOW_MASTERSERVICES}")
	private String showMasterServicesURL;
	
	@Value("#{abc.ADD_MASTERSERVICES}")
	private String addMasterServicesURL;

	@Value("#{abc.ADD_VENDORSERVICES}")
	private String addVendorServicesURL;

	@Value("#{abc.SHOW_VENDORSERVICES}")
	private String showVendorServicesURL;
	
	@Autowired
	HttpSession session;

	@PostMapping("/checklogin")
	public String processVendorLoginForms(@RequestParam String email, @RequestParam String password,
			@RequestParam String role, RestTemplate template, RedirectAttributes flashMap) {
//		String url = "http://localhost:7070/NewBikeServer/vendordata/login";
		System.out.println("\n\n\n\n\n\n\n" + role + "\n\n\n\n\n\n\n\n\n");

		if (role.equals("user")) {

			User u = new User(email, password);
			System.out.println(
					"In process login user account form " + loginURL + " " + u.getU_email() + u.getU_password());
			try {
				User user = template.postForObject(loginURL, u, User.class);
				String msg = "";

				if (user != null) {
					if (u.getU_email().equals(user.getU_email()) && (u.getU_password().equals(user.getU_password()))) {
						msg = "Welcome ";
						flashMap.addFlashAttribute("status", msg + user.getU_first_name());
						System.out.println("\n\n\n\n\nUser Data Hi walaa data" + user + "\n\\n\n");
						session.setAttribute("session_user", user);
						return "redirect:/user/profile";
					}
				}
			} catch (RestClientException e) {
				flashMap.addFlashAttribute("status", "User Not Found!!Please Check You Credentials Once.");
			}
			return "redirect:/user/login";
		} else if (role.equals("vendor")) {

			Vendor u = new Vendor(email, password);
			System.out.println("In process login vendor account form " + loginVendorURL + " " + u.getVen_email()
					+ u.getVen_password());
			try {
				Vendor user = template.postForObject(loginVendorURL, u, Vendor.class);
				String msg = "";

				if (user != null) {
					if (u.getVen_email().equals(user.getVen_email())
							&& (u.getVen_password().equals(user.getVen_password()))) {
						msg = "Welcome ";
						flashMap.addFlashAttribute("status", msg + user.getVen_first_name());
						System.out.println("\n\n\n\n\nUser Data Hi walaa data" + user + "\n\\n\n");
						session.setAttribute("session_vendor", user);
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

	@GetMapping("/logout")
	public String showUserLogoutForm() {
		System.out.println("In show logout / homepage form ");
		session.invalidate();
		return "/vendor/login";
	}

	@GetMapping("/login")
	public String showUserLoginForm() {
		System.out.println("In show Vendor login / homepage form ");
		return "/vendor/login";
	}

	@PostMapping("/login")
	public String processUserLoginForm(@RequestParam String email, @RequestParam String password, RestTemplate template,
			RedirectAttributes flashMap) {
		// String url = "http://localhost:7070/NewBikeServer/vendordata/login";

		Vendor u = new Vendor(email, password);
		System.out.println("In process login vendor account form " + loginVendorURL + " " + u.getVen_email()
				+ u.getVen_password());
		try {
			Vendor user = template.postForObject(loginVendorURL, u, Vendor.class);
			String msg = "";

			if (user != null) {
				if (u.getVen_email().equals(user.getVen_email())
						&& (u.getVen_password().equals(user.getVen_password()))) {
					msg = "Welcome ";
					flashMap.addFlashAttribute("status", msg + user.getVen_first_name());
					System.out.println("\n\n\n\n\n Vendor Data Hi walaa data" + user + "\n\\n\n");
					session.setAttribute("session_vendor", user);
					return "redirect:/vendor/profile";
				}
			}
		} catch (RestClientException e) {
			flashMap.addFlashAttribute("status", "Vendor With These Credential is Not Found!!");
		}
		return "redirect:/vendor/login";
	}

	@GetMapping("/profile")
	public String showUserProfile() {
		System.out.println(" Client Vendor Profile ");
		return "/vendor/profile";
	}

	@GetMapping("/register")
	public String showVendorRegisterForm(Vendor u) {
		System.out.println("Register account form of Vendor " + u);
		return "/vendor/register";
	}

	@PostMapping("/register")
	public String processCreateForm(Vendor u, RestTemplate template, RedirectAttributes flashMap) {
		System.out.println("In process create Vendor account form " + registerVendorURL + " " + u);
		try {
			// Invoke REST API to create new user account
			String msg = template.postForObject(registerVendorURL, u, String.class);
			flashMap.addFlashAttribute("status", msg + " Please Login As A Vendor");

		} catch (RestClientException e) {
			flashMap.addFlashAttribute("status", "Error In Register Vendor. Please Check You Details Once!");

		}
		return "redirect:/vendor/register";
	}

	/*
	 * @GetMapping("/registerServices") public String
	 * showVendorRegisterServiceForm(Service service) {
	 * System.out.println("Register account form of Vendor " + service); return
	 * "/vendor/registerServices"; }
	 */

	@GetMapping("/addoffer")
	public String showAddOfferForm(Offer offer) {
		System.out.println("In show add offer form ");
		return "/vendor/addoffer";
	}

	@PostMapping("/addoffer")
	public String processAddOfferForm(Offer offer, RestTemplate template, RedirectAttributes flashMap) {
		System.out.println("In process add offer Vendor account form client " + addOfferURL + " " + offer);
		try {
			Vendor ven = (Vendor) session.getAttribute("session_vendor");
			offer.setOfr_vendor(ven);
			// Invoke REST API to create new offer for vendor account
			String msg = template.postForObject(addOfferURL, offer, String.class);
			flashMap.addFlashAttribute("status", msg);
			Vendor vendor = template.getForObject(getVendorURL, Vendor.class, ven.getVen_id());

			// Updated Session Values
			session.setAttribute("session_vendor", vendor);

		} catch (RestClientException e) {
			flashMap.addFlashAttribute("status", "Error In Adding Offer. Please Check You Details Once!");

		}
		return "redirect:/vendor/profile";
	}

	@GetMapping("/deleteoffer")
	public String showVendorProfileAfterDeleteOffer(@RequestParam int ofr_id, RestTemplate template,
			RedirectAttributes flashMap) {
		System.out.println(" \n\n\n\n\n\nClient USER Vehicle Delete Method\n\n\n\n\n\n\n ");
		System.out.println("\n\n\n\nIn process delete vehicle user form to delete Vehicle " + deleteVendorOfferURL + " "
				+ ofr_id + "\n\n\n\n\n");

		try {

			template.delete(deleteVendorOfferURL, ofr_id);
			// template.postForObject(deleteUserVehicleURL,String.class, String.class,v_id);

			// Updated Session Values
			Vendor v = (Vendor) session.getAttribute("session_vendor");
			Vendor vendor = template.getForObject(getVendorURL, Vendor.class, v.getVen_id());
			session.setAttribute("session_vendor", vendor);

			flashMap.addFlashAttribute("status", "Offer Deleted Successfully!!");

		} catch (RestClientException e) {
			flashMap.addFlashAttribute("status",
					e.getMessage() + "Sorry, This Offer is Not Registered, Please Check Your Details Once.");
			return "redirect:/vendor/profile";
		}
		return "redirect:/vendor/profile";
	}

	@GetMapping("/addmechanic")
	public String showAddMechanicForm(Mechanic mechanic) {
		System.out.println("In show add mechanic form ");
		return "/vendor/addmechanic";
	}

	@PostMapping("/addmechanic")
	public String processAddMechanicForm(Mechanic mechanic, RestTemplate template, RedirectAttributes flashMap) {
		System.out.println("In process add Mechanic to Vendor account form client " + addMechanicURL + " " + mechanic);
		try {

			Vendor ven = (Vendor) session.getAttribute("session_vendor");
			mechanic.setMech_vendor(ven);
			// Invoke REST API to create new offer for vendor account
			String msg = template.postForObject(addMechanicURL, mechanic, String.class);
			flashMap.addFlashAttribute("status", msg);
			Vendor vendor = template.getForObject(getVendorURL, Vendor.class, ven.getVen_id());

			// Updated Session Values
			session.setAttribute("session_vendor", vendor);

		} catch (RestClientException e) {
			flashMap.addFlashAttribute("status", "Error In Adding Offer. Please Check You Details Once!");

		}
		return "redirect:/vendor/profile";
	}

	@GetMapping("/deletemechanic")
	public String showVendorProfileAfterDeleteMechanic(@RequestParam int mech_id, RestTemplate template,
			RedirectAttributes flashMap) {
		System.out.println(" \n\n\n\n\n\nClient Vendor Delete Mechanic Method\n\n\n\n\n\n\n ");
		System.out.println("\n\n\n\nIn process delete mechanic vendor form to delete mechanic "
				+ deleteVendorMechanicURL + " " + mech_id + "\n\n\n\n\n");
		try {
			template.delete(deleteVendorMechanicURL, mech_id);
			// Updated Session Values
			Vendor v = (Vendor) session.getAttribute("session_vendor");
			Vendor vendor = template.getForObject(getVendorURL, Vendor.class, v.getVen_id());
			session.setAttribute("session_vendor", vendor);

			flashMap.addFlashAttribute("status", "Mechanic's Details Deleted Successfully!!");

		} catch (RestClientException e) {
			flashMap.addFlashAttribute("status", e.getMessage()
					+ "Sorry, This Mechanic's Record is Not Registered With Your Shop, Please Check Your Details Once.");
			return "redirect:/vendor/profile";
		}
		return "redirect:/vendor/profile";
	}

	
	
	
	
	
	
	
	
	
	@GetMapping("/showservices") 
	public String showVendorServiceForm(@ModelAttribute("service_taken_vendor") Service_Taken_Vendor service, RestTemplate template)
	{
	System.out.println("In show add Vendor Services form ");
	List<Service_Taken_Vendor> vendorservices_list = template.getForObject(showVendorServicesURL,List.class); 
	System.out.println("\n\n\n\nlist of vendor services "+vendorservices_list+"\n\n\n");
	session.setAttribute("masterservices_list", vendorservices_list);		  
	return "/vendor/showservices";
	
	  }
	 
	  
	  
	  
	  
	  

@PostMapping("/showservices")
public String addVendorServiceForm(@ModelAttribute("service_taken_vendor")  Service_Taken_Vendor services ,RedirectAttributes flashMap, RestTemplate template) 
	{
	System.out.println("In process add Master Services to Vendor account form client " + addVendorServicesURL + " " + services);
	try {
		Vendor ven = (Vendor) session.getAttribute("session_vendor");
		services.setStv_vendor(ven);
		
		//Invoke REST API to create new service for vendor account 
		String msg = template.postForObject(addVendorServicesURL, services, String.class);
		
		flashMap.addFlashAttribute("status", msg);
		
		Vendor v = (Vendor) session.getAttribute("session_vendor");
		Vendor vendor = template.getForObject(getVendorURL, Vendor.class, v.getVen_id());
		session.setAttribute("session_vendor", vendor);

	} catch (RestClientException e) {
		flashMap.addFlashAttribute("status", "Error In Adding Service. Please Check You Details Once!");
	}
	return "redirect:/vendor/profile";
	
	}
	
@GetMapping("/contact") 
public String showContactForm()
{
System.out.println("In contact form ");

return "/vendor/contact";

  }
@PostMapping("/contact") 
public String showContact()
{
System.out.println("Inprocess of  contact form ");

return "redirect:vendor/contact";

  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*	  @GetMapping("/showservices") 
	  public String showMasterServiceForm(@ModelAttribute("service_taken_vendor") Service_Taken_Vendor service_taken_vendor ,RestTemplate template)
	  {
	  	System.out.println("In show MasterService form");
	  try { 		  
		  //Updated Session Values Vendor v = (Vendor)
	  session.getAttribute("session_vendor"); 
	  
	  
	  List<MasterService> masterservices_list = template.getForObject(showMasterServicesURL,List.class);
	  
	  System.out.println("\n\n\n\nlist"+masterservices_list+"\n\n\n\n\n\n");
	  session.setAttribute("masterservices_list", masterservices_list);
	  
	  
	  } catch (RestClientException e) 
	  {
		  session.setAttribute("masterservices_list",e.getMessage()+"Sorry, No Services Are Registered, Please Check With Admin.");
		  return "redirect:/vendor/showservices";
		  }
	  	return "/vendor/showservices"; 
	  }
	  
	 

	

	
	  
	  @PostMapping("/showservices")
	  public String addMasterServiceForm(@ModelAttribute("service_taken_vendor") Service_Taken_Vendor services ,RedirectAttributes flashMap, RestTemplate template) 
	  {	 
	  try { 
		  System.out.println("In add MasterService form"); 
		  String msg=""; 
	  //Updated Session Values
	 Vendor ven = (Vendor) session.getAttribute("session_vendor");
	 services.setStv_vendor(ven);
	 
	 	System.out.println("\n\n"+services.getStv_price()+"\n\n");
	 msg = template.postForObject(addMasterServicesURL,services,String.class);  	 
	  
	 System.out.println("\n\n\n\nlist"+services.toString()+"\n\n\n\n\n\n");
	  
	  if(msg.equals("error")) 
	  { flashMap.addFlashAttribute("status","Oops Something Went Wrong. Try Again...!!"); }
	  else {
	 flashMap.addFlashAttribute("status", "Hurrey!! Your Services Added Successfully!!");   
	  
	  //Updated Session Values session.setAttribute("session_vendor", vendor); 
		Vendor vendor = template.getForObject(getVendorURL, Vendor.class, ven.getVen_id());
		// Updated Session Values
		session.setAttribute("session_vendor", vendor);
	  }
	  }
	   catch (RestClientException e) { session.setAttribute("masterservices_list",
	  e.getMessage()+"Sorry, No Services Are Registered, Please Check With Admin."
	  ); return "redirect:/vendor/profile"; }
	  
	  return "/vendor/profile"; }
	  
*/	 
}
