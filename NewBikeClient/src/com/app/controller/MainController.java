package com.app.controller;

import javax.servlet.http.HttpSession;

import org.hibernate.query.criteria.internal.expression.function.UpperFunction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.app.pojos.User;
import com.app.pojos.Vendor;


@Controller
@RequestMapping("/")
public class MainController {
	
	//FOR USER REST URL
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
	
	
	//FOR VENDOR REST URL
	//FOR VENDOR REST URL
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
	

	
		
	@PostMapping("/checklogin")
	public String processUserLoginForms(@RequestParam String email,@RequestParam String password,@RequestParam String role,RestTemplate template,RedirectAttributes flashMap,HttpSession session) {
	//	String url = "http://localhost:7070/NewBikeServer/userdata/login";
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
			flashMap.addFlashAttribute("status","User Not Found, Please Try Again");
		}
		return "redirect:/user/login";
	 }
	 else if(role.equals("vendor")) {

			Vendor v = new Vendor(email, password);
		System.out.println("In process login vendor account form "+ loginVendorURL + " " + v.getVen_email() +v.getVen_password());
		try {				
			Vendor vendor = template.postForObject(loginVendorURL, v, Vendor.class);
			String msg = "";
			
			if(vendor!=null) {	
				
			if(v.getVen_email().equals(vendor.getVen_email()) && (v.getVen_password().equals(vendor.getVen_password()))) {
				msg = "Welcome ";
				flashMap.addFlashAttribute("status", msg+vendor.getVen_first_name());
				System.out.println("\n\n\n\n\nVendor Data Hi walaa data" +vendor+"\n\\n\n");
				session.setAttribute("session_vendor", vendor);
				return "redirect:/vendor/profile";
			}
			}
		} catch (RestClientException e) {
			flashMap.addFlashAttribute("status","Vendor Not Found, Please Try Again...");
		}
		return "redirect:/vendor/login";
	 }
		return "redirect:/";
	 }

		

		@GetMapping("/profile")
		public String showUserProfile() {
			System.out.println(" Client USER Profile ");
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
				String msg = template.postForObject(registerURL, u, String.class);
				flashMap.addFlashAttribute("status", msg);
			} catch (RestClientException e) {
				flashMap.addFlashAttribute("status", e.getMessage());
			}
			return "redirect:/user/register";
		}

		
		

	
		
		
}
