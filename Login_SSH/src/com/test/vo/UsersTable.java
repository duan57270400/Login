package com.test.vo;

/**
 * UsersTable entity. @author MyEclipse Persistence Tools
 */

public class UsersTable implements java.io.Serializable {

	// Fields

	private String account;   //�˻�
	private String password;  //����
	private String username;  //�û���
	private String gender;    //�Ա�
	private String age;       //����
	private String telephone;  //�绰����
	private String office;     //ְ��
	private String dept;       //���� 
	private String post;       //��λ
	private String userNum;    //�û����

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