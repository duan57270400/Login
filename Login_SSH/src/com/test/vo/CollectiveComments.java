package com.test.vo;

import java.util.Date;

/**
 * CollectiveComments entity. @author MyEclipse Persistence Tools
 */

public class CollectiveComments implements java.io.Serializable {

	// Fields

	private Integer id;
	private String basicInfoNum;
	private String postId;
	private String userNum;
	private String comment;
	private Date completeTime;
	private Integer status;

	// Constructors

	/** default constructor */
	public CollectiveComments() {
	}

	/** full constructor */
	public CollectiveComments(String basicInfoNum, String postId,
			String userNum, String comment, Date completeTime, Integer status) {
		this.basicInfoNum = basicInfoNum;
		this.postId = postId;
		this.userNum = userNum;
		this.comment = comment;
		this.completeTime = completeTime;
		this.status = status;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBasicInfoNum() {
		return this.basicInfoNum;
	}

	public void setBasicInfoNum(String basicInfoNum) {
		this.basicInfoNum = basicInfoNum;
	}

	public String getPostId() {
		return this.postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getUserNum() {
		return this.userNum;
	}

	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCompleteTime() {
		return this.completeTime;
	}

	public void setCompleteTime(Date completeTime) {
		this.completeTime = completeTime;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}