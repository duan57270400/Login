package com.test.vo;

/**
 * TaxTable entity. @author MyEclipse Persistence Tools
 */

public class TaxTable implements java.io.Serializable {

	// Fields

	private String basicInfoNum;      //基本信息编号,主键
	private String grossIncome;       //收入总额
	private String nonTaxableIncome;  //不征税收入
	private String exemptIncome;      //免税收入
	private String taxableIncome;     //应税收入额 
	private String taxAuthorityPay;   //税务机关应纳所得税
	private String reviewComments;    //审核意见

	// Constructors

	/** default constructor */
	public TaxTable() {
	}

	/** minimal constructor */
	public TaxTable(String basicInfoNum) {
		this.basicInfoNum = basicInfoNum;
	}

	/** full constructor */
	public TaxTable(String basicInfoNum, String grossIncome,
			String nonTaxableIncome, String exemptIncome, String taxableIncome,
			String taxAuthorityPay, String reviewComments) {
		this.basicInfoNum = basicInfoNum;
		this.grossIncome = grossIncome;
		this.nonTaxableIncome = nonTaxableIncome;
		this.exemptIncome = exemptIncome;
		this.taxableIncome = taxableIncome;
		this.taxAuthorityPay = taxAuthorityPay;
		this.reviewComments = reviewComments;
	}

	// Property accessors

	public String getBasicInfoNum() {
		return this.basicInfoNum;
	}

	public void setBasicInfoNum(String basicInfoNum) {
		this.basicInfoNum = basicInfoNum;
	}

	public String getGrossIncome() {
		return this.grossIncome;
	}

	public void setGrossIncome(String grossIncome) {
		this.grossIncome = grossIncome;
	}

	public String getNonTaxableIncome() {
		return this.nonTaxableIncome;
	}

	public void setNonTaxableIncome(String nonTaxableIncome) {
		this.nonTaxableIncome = nonTaxableIncome;
	}

	public String getExemptIncome() {
		return this.exemptIncome;
	}

	public void setExemptIncome(String exemptIncome) {
		this.exemptIncome = exemptIncome;
	}

	public String getTaxableIncome() {
		return this.taxableIncome;
	}

	public void setTaxableIncome(String taxableIncome) {
		this.taxableIncome = taxableIncome;
	}

	public String getTaxAuthorityPay() {
		return this.taxAuthorityPay;
	}

	public void setTaxAuthorityPay(String taxAuthorityPay) {
		this.taxAuthorityPay = taxAuthorityPay;
	}

	public String getReviewComments() {
		return this.reviewComments;
	}

	public void setReviewComments(String reviewComments) {
		this.reviewComments = reviewComments;
	}

}