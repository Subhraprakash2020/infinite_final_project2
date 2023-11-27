package com.java.hib;

import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ProviderController {
	
	SessionFactory sf;
	Session session;
 
	private ProviderDetailsDAOImpl daoImpl;
	private ProviderDetails providerDetails;
 
	public ProviderDetails getProviderDetails() {
		return providerDetails;
	}
	public void setProviderDetails(ProviderDetails providerDetails) {
		this.providerDetails = providerDetails;
	}

	public ProviderDetailsDAOImpl getDaoImpl() {
		return daoImpl;
	}
	public void setDaoImpl(ProviderDetailsDAOImpl daoImpl) {
		this.daoImpl = daoImpl;
	}
 
	public String searchProviderDetails(String providerid) {
		System.out.println("From controller : "+providerid);
		return daoImpl.searchProviderDetails(providerid);
	}
	public String updateProviderDetails(ProviderDetails provider) {
		System.out.println(provider);
		System.out.println(daoImpl);
		System.out.println("addProviderValid is Hittingggggggggg");
		System.out.println(updateValid(provider));
		if (updateValid(provider)) {
			return daoImpl.updateProviderDetails(provider);
		}
		return "";
 
	}
 
	
 
	public boolean updateValid(ProviderDetails provider) {
		FacesContext context = FacesContext.getCurrentInstance();
		String firstName = "^[A-Za-z\\s]+$";
		String lastName = "^[A-Za-z\\s]+$";
		String userName = "^[^\\s]{8,10}$";
//		String phoneno = "^(\\+91|91|0)?[6789]\\d{9}$";
		String email = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		System.out.println("list from cont : "+provider);
		
 
		if (!Pattern.matches(userName, provider.getUsername())) {
		    context.addMessage("form:userName", new FacesMessage("Provider Username Contains min 8 characters"));
			System.out.println("UserName Failed...");
			return false;
		}
		if (!Pattern.matches(firstName, provider.getFirstname())) {
			context.addMessage("form:firstName", new FacesMessage("Invalid FirstName. Only letters are allowed."));
			System.out.println("FirstName Failed...");
			return false;
		}
		if (!Pattern.matches(lastName, provider.getLastname())) {
			context.addMessage("form:lastName", new FacesMessage("Invalid LastName. Only letters are allowed."));
			System.out.println("LastName Failed...");
			return false;
		}
//		if (!Pattern.matches(phoneno, provider.getPhoneno())) {
//			context.addMessage("form:phoneno", new FacesMessage("Invalid Phone Number."));
//			System.out.println("PhoneNo Failed...");
//			return false;
//		}
		if (!Pattern.matches(email, provider.getEmail())) {
			context.addMessage("form:email", new FacesMessage("Invalid Email."));
			System.out.println("Email Failed...");
			return false;
		}
		return true;
	}
}
	


