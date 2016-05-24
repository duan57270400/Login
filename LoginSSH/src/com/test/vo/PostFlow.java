package com.test.vo;

/**
 * PostFlow entity. @author MyEclipse Persistence Tools
 */

public class PostFlow implements java.io.Serializable {

	// Fields

	private Integer idnum;       
	private String basicInfoNum;   //������Ϣ���
	private String postId;         //��λ���
	private String userNum;        //�û����
	private String status;         //��ת״̬

	// Constructors

	/** default constructor */
	public PostFlow() {
	}

	/** minimal constructor */
	public PostFlow(Integer idnum, String basicInfoNum, String postId,
			String userNum) {
		this.idnum = idnum;
		this.basicInfoNum = basicInfoNum;
		this.postId = postId;
		this.userNum = userNum;
	}

	/** full constructor */
	public PostFlow(Integer idnum, String basicInfoNum, String postId,
			String userNum, String status) {
		this.idnum = idnum;
		this.basicInfoNum = basicInfoNum;
		this.postId = postId;
		this.userNum = userNum;
		this.status = status;
	}

	// Property accessors

	public Integer getIdnum() {
		return this.idnum;
	}

	public void setIdnum(Integer idnum) {
		this.idnum = idnum;
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}