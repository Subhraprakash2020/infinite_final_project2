package com.java.demo;

import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;


public class InsuranceImpl {

	
	SessionFactory sf;
	Session session;
	
	public List<InsurancePlans> showInsurancePlanDao() {
		Map<String,Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();	
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(InsurancePlans.class);
		List<InsurancePlans>insList=cr.list();
		System.out.println("List : "+insList);
		sessionMap.put("insList", insList);
		return insList;
	}
	
public String getInsurancePlans(String insuranceId) {
		
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Map<String,Object> sessionMap =
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap();	
		Criteria cr = session.createCriteria(InsurancePlans.class);
		cr.add(Restrictions.eq("insurance_id", insuranceId));
		List<InsurancePlans>insList=cr.list();
		System.out.println("List : "+insList);
		sessionMap.put("insList", insList);
 
		return"Subscribe.jsp?faces-redirect=true";		
	}
	
	
}
