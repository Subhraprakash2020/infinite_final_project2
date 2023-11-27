package com.java.demo;

public class InsurancePlans {

	private int plan_id;
	private String insurance_id;
	private double premium_amount;
	private double coverage_amount;
	private String benefits;
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
	public String getBenefits() {
		return benefits;
	}
	public void setBenefits(String benefits) {
		this.benefits = benefits;
	}
	@Override
	public String toString() {
		return "InsurancePlans [plan_id=" + plan_id + ", insurance_id=" + insurance_id + ", premium_amount="
				+ premium_amount + ", coverage_amount=" + coverage_amount + ", benefits=" + benefits + "]";
	}
	public InsurancePlans(int plan_id, String insurance_id, double premium_amount, double coverage_amount,
			String benefits) {
		super();
		this.plan_id = plan_id;
		this.insurance_id = insurance_id;
		this.premium_amount = premium_amount;
		this.coverage_amount = coverage_amount;
		this.benefits = benefits;
	}
	public InsurancePlans() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
