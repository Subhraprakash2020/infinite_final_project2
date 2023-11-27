package com.java.manager;

import java.util.Date;

public class CustPolicy {
	private int subscription_Id;
	private int plan_id;
	private String insurance_id;
	private double premium_amount;
	private double coverage_amount;
	private String paymode;
	private String email;
	private Date registrationDate;
	private double initial_amount;
	private String status;
	public int getSubscription_Id() {
		return subscription_Id;
	}
	public void setSubscription_Id(int subscription_Id) {
		this.subscription_Id = subscription_Id;
	}
	public int getPlan_id() {
		return plan_id;
	}
	public void setPlan_id(int plan_id) {
		this.plan_id = plan_id;
	}
	public String getInsurance_id() {
		return insurance_id;
	}
	public void setInsurance_id(String insurance_id) {
		this.insurance_id = insurance_id;
	}
	public double getPremium_amount() {
		return premium_amount;
	}
	public void setPremium_amount(double premium_amount) {
		this.premium_amount = premium_amount;
	}
	public double getCoverage_amount() {
		return coverage_amount;
	}
	public void setCoverage_amount(double coverage_amount) {
		this.coverage_amount = coverage_amount;
	}
	public String getPaymode() {
		return paymode;
	}
	public void setPaymode(String paymode) {
		this.paymode = paymode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	public double getInitial_amount() {
		return initial_amount;
	}
	public void setInitial_amount(double initial_amount) {
		this.initial_amount = initial_amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
