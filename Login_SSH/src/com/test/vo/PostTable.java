package com.test.vo;

/**
 * PostTable entity. @author MyEclipse Persistence Tools
 */

public class PostTable implements java.io.Serializable {

	// Fields

	private String postId;      //��λ���,����
	private Integer collectivePost;  //�Ƿ��Ǽ����,0�� 1��
	private String basicInfoNum;    //���̺�
	private String postName;        //��λ����
	private String serviceNum;      //˳��� 1 2 3 4 5

	// Constructors

	/** default constructor */
	public PostTable() {
	}

	/** minimal constructor */
	public PostTable(String postId) {
		this.postId = postId;
	}

	/** full constructor */
	public PostTable(String postId, Integer collectivePost,
			String basicInfoNum, String postName, String serviceNum) {
		this.postId = postId;
		this.collectivePost = collectivePost;
		this.basicInfoNum = basicInfoNum;
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

	public Integer getCollectivePost() {
		return this.collectivePost;
	}

	public void setCollectivePost(Integer collectivePost) {
		this.collectivePost = collectivePost;
	}

	public String getBasicInfoNum() {
		return this.basicInfoNum;
	}

	public void setBasicInfoNum(String basicInfoNum) {
		this.basicInfoNum = basicInfoNum;
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