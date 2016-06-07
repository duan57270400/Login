package com.test.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.test.services.LoginService;
import com.test.vo.TaxTable;

public class TaxAction  extends ActionSupport {
	
	private LoginService loginService1;
	private TaxTable taxTable;
	private String post_id;    //��λ��ת��ĸ�λ���
	private String user_num;   //ִ���û��ı��
	private String[] CollectiveUserNum;
	private String CollectivePostId;
	private String Chief_comments;   //�ɳ����



	public String getChief_comments() {
		return Chief_comments;
	}


	public void setChief_comments(String chief_comments) {
		Chief_comments = chief_comments;
	}


	public String[] getCollectiveUserNum() {
		return CollectiveUserNum;
	}


	public void setCollectiveUserNum(String[] collectiveUserNum) {
		CollectiveUserNum = collectiveUserNum;
	}
	
	public String getCollectivePostId() {
		return CollectivePostId;
	}


	public void setCollectivePostId(String collectivePostId) {
		CollectivePostId = collectivePostId;
	}


	public String getUser_num() {
		return user_num;
	}


	public void setUser_num(String user_num) {
		this.user_num = user_num;
	}


	public String getPost_id() {
		return post_id;
	}


	public void setPost_id(String post_id) {
		this.post_id = post_id;
	}


	public TaxTable getTaxTable() {
		return taxTable;
	}


	public void setTaxTable(TaxTable taxTable) {
		this.taxTable = taxTable;
	}


	public void setLoginService1(LoginService loginService1) {
		this.loginService1 = loginService1;
	}


	public String execute(){  //Ĭ�ϵ�ִ�з���

		return SUCCESS;
	}
	public String collectiveOperate()  //����ڲ���
	{		
		return loginService1.collectiveOperate(user_num, post_id);
	}
	public String updateComment()     //���¼���������Ĵ������
	{
		return loginService1.updateComment(user_num,post_id,comment);
	}
	
	public String windowsFirst()   //��һ������,¼�����ݼ�ѡ����һ����Ա
	{
		
		return loginService1.windowsFirst(post_id, user_num);
	}
	
	public String ChiefReception()  //�ɳ����¸�λ��ת��¼�뼯�����Ϣ
	{		
		return loginService1.ChiefReception(basic_info_num, user_num, Chief_comments, CollectivePostId, CollectiveUserNum,post_id);
	}
	
	public String businessReception()  //ҵ��Աҵ�����
	{
			
		return loginService1.businessReception(post_id, user_num);
	}
	
	public String windowReception()  //���ڽӴ���ҵ��,Part1
	{
		return loginService1.windowReception(taxTable,post_id,user_num,next_user_num,nextPost_id);
	}
	
	public String selectNextUser()  //���ڽӴ�Part2
	{
		
		return loginService1.selectNextUser(first_basic_num,nextPost_id,next_user_num);
	}
	
	private String first_basic_num;  //��һ���õ��Ļ�����Ϣ���
	private String nextPost_id;      //��һ��ĸ�λ���
	private String next_user_num;    //��һ���Ҫִ�е��û����



	public String getFirst_basic_num() {
		return first_basic_num;
	}


	public void setFirst_basic_num(String first_basic_num) {
		this.first_basic_num = first_basic_num;
	}


	public String getNextPost_id() {
		return nextPost_id;
	}


	public void setNextPost_id(String nextPost_id) {
		this.nextPost_id = nextPost_id;
	}


	public String getNext_user_num() {
		return next_user_num;
	}


	public void setNext_user_num(String next_user_num) {
		this.next_user_num = next_user_num;
	}
	public String chiefOperate()  //�ɳ�����
	{			
		return  loginService1.chiefOperate(user_num,post_id);
	}
	
	public String businessBrowse()   //�鿴�������˰����Ϣ
	{
		
		return loginService1.businessBrowse(basic_info_num,post_id,user_num);
	}
	
	public String businessUpdate()  //���µڶ�����Ϣ������˰����ת���Ϊ1
	{
		
		return loginService1.businessUpdate(basic_info_num, post_id2, user_num,taxAuthorityPay,reviewComments,next_user_num);
	}
	
	private String post_id2;       //�ڶ���ĸ�λ���
	private String basic_info_num; //��λ��ת��Ļ�����Ϣ���
	private String taxAuthorityPay;
	private String reviewComments;
	private String comment;    //����ڵ��޸����
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}


	public String getTaxAuthorityPay() {
		return taxAuthorityPay;
	}


	public void setTaxAuthorityPay(String taxAuthorityPay) {
		this.taxAuthorityPay = taxAuthorityPay;
	}


	public String getReviewComments() {
		return reviewComments;
	}


	public void setReviewComments(String reviewComments) {
		this.reviewComments = reviewComments;
	}


	public String getPost_id2() {
		return post_id2;
	}


	public void setPost_id2(String post_id2) {
		this.post_id2 = post_id2;
	}


	public String getBasic_info_num() {
		return basic_info_num;
	}


	public void setBasic_info_num(String basic_info_num) {
		this.basic_info_num = basic_info_num;
	}
	
	
	
	
}
