package com.java.manager;

import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;


public class PatientDAOImpl implements PatientDAO{

	SessionFactory sf;
	Session session;
	
private String localCode;
	
	public String getLocalCode() {
		return localCode;
	}
	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}
	
	public void employLocalCodeChanged(ValueChangeEvent e) {
		this.localCode = e.getNewValue().toString();
	}
	
	@Override
	public List<Patient_Enrollment> showPatient() {
		
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria cr = session.createCriteria(Patient_Enrollment.class);
		return cr.list();
	}
	@Override
	public List<Patient_Enrollment> searchPatient(String searchType, String searchValue) {
		// TODO Auto-generated method stub
		return null;
	}
	
// UhId---------------------------------------------------------------------------------

	public List<String> getUhId(){
		sf = SessionHelper.getConnection();
		session = sf.openSession();
		Criteria cr = session.createCriteria(Patient_Enrollment.class);
		Projection projection = Projections.distinct(Projections.property("uhId"));
		cr.setProjection(projection);
		List<String> list = cr.list();	
		return list;
	}
	

	public List<Patient_Enrollment> getPatientListByUhId(String uhId){
		SessionFactory sf = SessionHelper.getConnection();
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Patient_Enrollment.class);
		cr.add(Restrictions.eq("uhId",uhId));
		List<Patient_Enrollment> patientList = cr.list();
		return patientList;
	}
//-------------------------------------------------------------------------------------------

// FirstName---------------------------------------------------------------------------------

	/*
	 * public String getFirstName(String firstName){ sf =
	 * SessionHelper.getConnection(); session = sf.openSession(); Criteria cr =
	 * session.createCriteria(Patient_Enrollment.class); Projection projection =
	 * Projections.distinct(Projections.property("firstName"));
	 * cr.setProjection(projection); System.out.println("firstName: "+firstName);
	 * List<String> patientlist = cr.list(); return
	 * "PatientShow.jsp?faces-redirect=true"; }
	 */
	
	
//	public String getFirstName(Patient_Enrollment patientEnr) {
//		
//		sf = SessionHelper.getConnection();
//		session = sf.openSession();
//		
//		
//		Transaction tr = session.beginTransaction();
//		Criteria cr = session.createCriteria(Patient_Enrollment.class);
//		cr.add(Restrictions.eq("firstName", patientEnr.getFirstName()));
//		List<Patient_Enrollment> patientList = cr.list();
//		return patientList;
//		
//		
//		
//		
////		patientList = session.createCriteria(Patient_Enrollment.class).add(Restrictions.eq("firstName",firstName)).list();
////		String hql = "FROM patient_enrollment b WHERE b.name = :firstName";
////        Query<Patient_Enrollment> query = session.createQuery(hql, Patient_Enrollment.class);
////        query.set
//		
//
//		
//		
//	}
//		

		public List<Patient_Enrollment> getFirstNameList(String firstName){
			Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			SessionFactory sf = SessionHelper.getConnection();
			Session session = sf.openSession();
			Criteria cr = session.createCriteria(Patient_Enrollment.class);
			
			cr.add(Restrictions.eq("firstName",firstName));
			
			System.out.println("firstName: "+firstName);
			List<Patient_Enrollment> patientList = cr.list();
			sessionMap.put("patientList",patientList);
			System.out.println(patientList);
			return patientList;
		}
//--------------------------------------------------------------------------------------
		
// UserName---------------------------------------------------------------------------------

				public List<String> getUserName(){
					sf = SessionHelper.getConnection();
					session = sf.openSession();
					Criteria cr = session.createCriteria(Patient_Enrollment.class);
					Projection projection = Projections.distinct(Projections.property("userName"));
					cr.setProjection(projection);
					List<String> list = cr.list();	
					return list;
				}
				

				public List<Patient_Enrollment> getUserNameList(String userName){
					SessionFactory sf = SessionHelper.getConnection();
					Session session = sf.openSession();
					Criteria cr = session.createCriteria(Patient_Enrollment.class);
					cr.add(Restrictions.eq("userName",userName));
					List<Patient_Enrollment> patientList = cr.list();
					return patientList;
				}
//--------------------------------------------------------------------------------------
}
