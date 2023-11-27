package com.java.demo;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class CustPolicyImpl {
	SessionFactory sf;
	Session session;

	public String redirectToTakePolicy(int plan_id) {
		sf=SessionHelper.getConnection();
		session=sf.openSession();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		Criteria cr =session.createCriteria(InsurancePlans.class);
		cr.add(Restrictions.eq("plan_id", plan_id));
		InsurancePlans custPolicy=(InsurancePlans) cr.uniqueResult();
		sessionMap.put("custPolicy", custPolicy);
		return "Subscribe.jsp?faces-redirect=true";
	}


	public String takePolicy(CustPolicy custpolicy) throws ParseException {
		Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		int planId = (int) sessionMap.get("loggedCustId");
		String insId = (String) sessionMap.get("insuranceId");
		
		custpolicy.setPlan_id(planId);
		custpolicy.setInsurance_id(insId);
		
		String payMode = custpolicy.getPaymode().toString();
//		double premiumAmount = custpolicy.getPremium_amount();
		double coverageAmount = custpolicy.getCoverage_amount();
		
		double initialAmount = calculateInitialAmount(coverageAmount, payMode);
		custpolicy.setInitial_amount(initialAmount);
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = sdf.format(date);
		System.out.println("Current Date is : " + sdf.parse(formattedDate));
		
		custpolicy.setRegistrationDate(sdf.parse(formattedDate));
		
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Transaction trans = session.beginTransaction();
		session.save(custpolicy);
		trans.commit();
		return "Policy added";
	}

	double calculateInitialAmount(double insuranceAmount, String PayMode) {
		if (PayMode.equals("MONTHLY")) {
			return insuranceAmount / 12;
		} else if (PayMode.equals("QUARTERLY")) {
			return insuranceAmount / 4;
		} else if (PayMode.equals("HALFYEARLY")) {
			return insuranceAmount / 2;
		} else {
			return insuranceAmount;
		}
	}
	

//	public String addCustomerPlans(CustPolicy policy, InsurancePlans ins) {
//	    System.out.println("Inside add customer");
//	    sf = SessionHelper.getConnection();
//	    session = sf.openSession();
//	    Transaction trans = session.beginTransaction();
//	    CustPolicy poli = new CustPolicy();
//	    int planid = ins.getPlan_id();
//	    String insId = ins.getInsurance_id();
//	    double premium = ins.getPremium_amount();
//	    double coverageAmount = ins.getCoverage_amount();
//	    String policymode = policy.getPaymode();
//	    String email = policy.getEmail();
//	    Date registrationDate = policy.getRegistrationDate();
//
//	    double initialAmount = 0;
//	    Date endDate = registrationDate; // Initialize end date with registration date
//
//	    if (policymode.equals("MONTHLY")) {
//	        initialAmount = premium / 12;
//	        Calendar calendar = Calendar.getInstance();
//	        calendar.setTime(endDate);
//	        calendar.add(Calendar.MONTH, 1); // Add 1 month for monthly pay mode
//	        endDate = calendar.getTime();
//	    }else if (policymode.equals("QUARTERLY")) {
//	        initialAmount = premium / 3;
//	        Calendar calendar = Calendar.getInstance();
//	        calendar.setTime(endDate);
//	        calendar.add(Calendar.MONTH, 3); // Add 6 months for half-yearly pay mode
//	        endDate = calendar.getTime();
//	    } 
//	    
//	    else if (policymode.equals("HALFYEARLY")) {
//	        initialAmount = premium / 2;
//	        Calendar calendar = Calendar.getInstance();
//	        calendar.setTime(endDate);
//	        calendar.add(Calendar.MONTH, 6); // Add 6 months for half-yearly pay mode
//	        endDate = calendar.getTime();
//	    } else {
//	        // Default case for other pay modes (e.g., "QUARTERLY", "YEARLY")
//	        initialAmount = premium;
//	        Calendar calendar = Calendar.getInstance();
//	        calendar.setTime(endDate);
//	        calendar.add(Calendar.YEAR, 1); // Add 1 year for other pay modes
//	        endDate = calendar.getTime();
//	    }
//	    
//
//	    poli.setPlan_id(planid);
//	    poli.setInsurance_id(insId);
//	    poli.setInitial_amount(initialAmount);
//	    poli.setPaymode(policymode);
//	    poli.setPremium_amount(premium);
//	    poli.setCoverage_amount(coverageAmount);
//	    poli.setRegistrationDate(registrationDate);
//	    poli.setEndDate(endDate);
//	    poli.setStatus("Active");
//	    poli.setEmail(email);
//	    session.save(poli);
//	    session.getTransaction().commit();
//
//	    return "ShowInsurancePlans.jsp?faces-redirect=true";
//	}
	
	
//	public CustPolicy searchByPlanId(int plan_id) {
//		sf = SessionHelper.getConnection();
//		session = sf.openSession();
//		Criteria cr = session.createCriteria(CustPolicy.class);
//		cr.add(Restrictions.eq("plan_id", plan_id));
//		CustPolicy	 custpoli = (CustPolicy) cr.uniqueResult();
//		return custpoli;
//	}
	public String addCustomerPlans(CustPolicy policy, InsurancePlans ins) {
	    int planid = ins.getPlan_id();
	    CustPolicy existingPolicy = searchByPlanId(planid);

	    if (existingPolicy != null) {
	        // A record with the same plan_id exists in the CustPolicy table, redirect to another page
	        return "RenewConfirm.jsp?faces-redirect=true";
	    }

	    // Continue with the rest of your code to add a new record if the plan_id doesn't exist
	    System.out.println("Inside add customer");
	    sf = SessionHelper.getConnection();
	    session = sf.openSession();
	    Transaction trans = session.beginTransaction();
	    CustPolicy poli = new CustPolicy();
	    String insId = ins.getInsurance_id();
	    double premium = ins.getPremium_amount();
	    double coverageAmount = ins.getCoverage_amount();
	    String policymode = policy.getPaymode();
	    String email = policy.getEmail();
	    Date registrationDate = policy.getRegistrationDate();

	    double initialAmount = 0;
	    Date endDate = registrationDate; // Initialize end date with registration date

	    if (policymode.equals("MONTHLY")) {
	        initialAmount = premium / 12;
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTime(endDate);
	        calendar.add(Calendar.MONTH, 1); // Add 1 month for monthly pay mode
	        endDate = calendar.getTime();
	    } else if (policymode.equals("QUARTERLY")) {
	        initialAmount = premium / 3;
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTime(endDate);
	        calendar.add(Calendar.MONTH, 3); // Add 3 months for quarterly pay mode
	        endDate = calendar.getTime();
	    } else if (policymode.equals("HALFYEARLY")) {
	        initialAmount = premium / 2;
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTime(endDate);
	        calendar.add(Calendar.MONTH, 6); // Add 6 months for half-yearly pay mode
	        endDate = calendar.getTime();
	    } else {
	        // Default case for other pay modes (e.g., "YEARLY")
	        initialAmount = premium;
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTime(endDate);
	        calendar.add(Calendar.YEAR, 1); // Add 1 year for other pay modes
	        endDate = calendar.getTime();
	    }

	    poli.setPlan_id(planid);
	    poli.setInsurance_id(insId);
	    poli.setInitial_amount(initialAmount);
	    poli.setPaymode(policymode);
	    poli.setPremium_amount(premium);
	    poli.setCoverage_amount(coverageAmount);
	    poli.setRegistrationDate(registrationDate);
	    poli.setEndDate(endDate);
	    poli.setStatus("Active");
	    poli.setEmail(email);
	    session.save(poli);
	    session.getTransaction().commit();

	    return "ShowInsurancePlans.jsp?faces-redirect=true";
	}

	public CustPolicy searchByPlanId(int plan_id) {
	    sf = SessionHelper.getConnection();
	    session = sf.openSession();
	    Criteria cr = session.createCriteria(CustPolicy.class);
	    cr.add(Restrictions.eq("plan_id", plan_id));
	    CustPolicy custpoli = (CustPolicy) cr.uniqueResult();
	    return custpoli;
	}
	
	public String renewPlan(CustPolicy policy, InsurancePlans ins) {
	    int planid = ins.getPlan_id();
	    CustPolicy existingPolicy = searchByPlanId(planid);

	    if (existingPolicy != null) {
	        // Update the existing record with the new pay mode, initial amount, and extended end date
	        String policymode = policy.getPaymode();
	        Date registrationDate = policy.getRegistrationDate();

	        // Calculate the new end date and initial amount based on the selected pay mode
	        Date endDate = existingPolicy.getEndDate(); // Get the existing end date
	        double premium = ins.getPremium_amount();
	        double initialAmount = 0;
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTime(endDate);

	        if (policymode.equals("MONTHLY")) {
	            calendar.add(Calendar.MONTH, 1); // Add 1 month for monthly pay mode
	            initialAmount = premium / 12;
	        } else if (policymode.equals("QUARTERLY")) {
	            calendar.add(Calendar.MONTH, 3); // Add 3 months for quarterly pay mode
	            initialAmount = premium / 3;
	        } else if (policymode.equals("HALFYEARLY")) {
	            calendar.add(Calendar.MONTH, 6); // Add 6 months for half-yearly pay mode
	            initialAmount = premium / 2;
	        } else {
	            // Default case for other pay modes (e.g., "YEARLY")
	            calendar.add(Calendar.YEAR, 1); // Add 1 year for other pay modes
	            initialAmount = premium;
	        }

	        endDate = calendar.getTime();

	        // Update the existing policy with the new pay mode, initial amount, and end date
	        existingPolicy.setPaymode(policymode);
	        existingPolicy.setInitial_amount(initialAmount);
	        existingPolicy.setEndDate(endDate);

	        // Save the updated policy to the database
	        sf = SessionHelper.getConnection();
	        session = sf.openSession();
	        session.beginTransaction();
	        session.update(existingPolicy);
	        session.getTransaction().commit();
	    }

	    // Continue with any additional logic or redirection as needed
	    return "ShowInsurancePlans.jsp?faces-redirect=true";
	}



}

