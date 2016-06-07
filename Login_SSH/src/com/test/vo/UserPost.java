package com.test.vo;

/**
 * UserPost entity. @author MyEclipse Persistence Tools
 */

public class UserPost implements java.io.Serializable {

	// Fields

	private Integer num;
	private String userNum;   //ÓÃ»§±àºÅ
	private String postId;    //¸ÚÎ»±àºÅ

	// Constructors

	/** default constructor */
	public UserPost() {
	}

	/** minimal constructor */
	public UserPost(Integer num, String userNum) {
		this.num = num;
		this.userNum = userNum;
	}

	/** full constructor */
	public UserPost(String userNum, String postId) {
		
		this.userNum = userNum;
		this.postId = postId;
	}

	// Property accessors

	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getUserNum() {
		return this.userNum;
	}

	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}

	public String getPostId() {
		return this.postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

}