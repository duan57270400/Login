package com.test.vo;

/**
 * PostTable entity. @author MyEclipse Persistence Tools
 */

public class PostTable implements java.io.Serializable {

	// Fields

	private String postId;
	private String postName;
	private String serviceNum;

	// Constructors

	/** default constructor */
	public PostTable() {
	}

	/** minimal constructor */
	public PostTable(String postId) {
		this.postId = postId;
	}

	/** full constructor */
	public PostTable(String postId, String postName, String serviceNum) {
		this.postId = postId;
		this.postName = postName;
		this.serviceNum = serviceNum;
	}

	// Property accessors

	public String getPostId() {
		return this.postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getPostName() {
		return this.postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getServiceNum() {
		return this.serviceNum;
	}

	public void setServiceNum(String serviceNum) {
		this.serviceNum = serviceNum;
	}

}