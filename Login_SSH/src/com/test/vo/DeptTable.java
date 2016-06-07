package com.test.vo;

/**
 * DeptTable entity. @author MyEclipse Persistence Tools
 */

public class DeptTable implements java.io.Serializable {

	// Fields

	private String deptId;
	private String deptName;
	private String deptTel;

	// Constructors

	/** default constructor */
	public DeptTable() {
	}

	/** minimal constructor */
	public DeptTable(String deptId) {
		this.deptId = deptId;
	}

	/** full constructor */
	public DeptTable(String deptId, String deptName, String deptTel) {
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptTel = deptTel;
	}

	// Property accessors

	public String getDeptId() {
		return this.deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptTel() {
		return this.deptTel;
	}

	public void setDeptTel(String deptTel) {
		this.deptTel = deptTel;
	}

}