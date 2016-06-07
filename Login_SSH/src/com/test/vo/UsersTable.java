package com.test.vo;

/**
 * UsersTable entity. @author MyEclipse Persistence Tools
 */

public class UsersTable implements java.io.Serializable {

	// Fields

	private String account;   //账户
	private String password;  //密码
	private String username;  //用户名
	private String gender;    //性别
	private String age;       //年龄
	private String telephone;  //电话号码
	private String office;     //职称
	private String dept;       //部门 
	private String post;       //岗位
	private String userNum;    //用户编号

	// Constructors

	/** default constructor */
	public UsersTable() {
	}

	/** minimal constructor */
	public UsersTable(String account) {
		this.account = account;
	}

	/** full constructor */
	public UsersTable(String account, String password, String username,
			String gender, String age, String telephone, String office,
			String dept, String post) {
		this.account = account;
		this.password = password;
		this.username = username;
		this.gender = gender;
		this.age = age;
		this.telephone = telephone;
		this.office = office;
		this.dept = dept;
		this.post = post;
	
	}

	// Property accessors

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getOffice() {
		return this.office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getDept() {
		return this.dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getPost() {
		return this.post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getUserNum() {
		return this.userNum;
	}

	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}

}