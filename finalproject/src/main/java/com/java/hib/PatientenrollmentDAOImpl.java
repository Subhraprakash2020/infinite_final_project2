package com.java.hib;

import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PatientenrollmentDAOImpl implements PatientenrollmentDAO{
	
	SessionFactory sf;
	Session session;
	
	
	@Override
	public List<Patientenrollment> showPatientenrollment() {
		// TODO Auto-generated method stub
		sf = SessionHelper.getConnection();
		session=sf.openSession();
		Criteria cr = session.createCriteria(Patientenrollment.class);
		List<Patientenrollment> enrollmentList=cr.list();
		return enrollmentList;
	}
//	@Override
//	public String searchPatientrenrollment(String uhid) {
//		System.out.println("From controller : "+uhid);
//		// TODO Auto-generated method stub
//		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext()
//				.getSessionMap();
//		sf = SessionHelper.getConnection();
//		session = sf.openSession();
//		Query query = session.createQuery("from Patientenrollment where uhid="+uhid);
//		List<Patientenrollment> patientList = query.list();
//		Patientenrollment patient = patientList.get(0);
//		sessionMap.put("editPatient", patient);
//		return"UpdatePatientEnrollment.jsp?faces-redirect=true";
//	}
	public String searchPatientrenrollment(String uhid) {
		// TODO Auto-generated method stub
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap();
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Query query = session.createQuery("from Patientenrollment where uhid="+uhid);
		List<Patientenrollment> patientList = query.list();
		Patientenrollment patient = patientList.get(0);
		sessionMap.put("editPatient",patient);
		return"UpdatePatientEnrollment.jsp?faces-redirect=true";
	}
//	@Override
//	public String updatePatientenrollment(Patientenrollment PatientenrollmentUpdate) {
//		// TODO Auto-generated method stub
////		System.out.println("x: "+PatientenrollmentUpdate);
////		sf = SessionHelper.getConnection();
////		session = sf.openSession();
////		Transaction trans = session.beginTransaction();
////		session.update(PatientenrollmentUpdate);
////		trans.commit();
////		return "ShowPatientEnrollment.jsp?faces-redirect=true";
//		System.out.println("Inside updatepatientEnrollment");
//		sf = SessionHelper.getConnection();
//		session = sf.openSession();
//		Transaction trans = session.beginTransaction();
//		session.update(PatientenrollmentUpdate);
//		trans.commit();
//		return "ShowPatientEnrollment.jsp?faces-redirect=true";
//	}
	
	public String updatePatientenrollment(Patientenrollment patientEnroll) {
		// TODO Auto-generated method stub
//		System.out.println("x: "+ProviderDetailsUpdate);
		System.out.println("Inside updatepatientenrollment");
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Transaction trans = session.beginTransaction();
		session.update(patientEnroll);
		trans.commit();
		return "ShowPatientEnrollment.jsp?faces-redirect=true";
	}
	
	
	

}
