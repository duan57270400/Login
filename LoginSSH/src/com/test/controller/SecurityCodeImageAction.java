package com.test.controller;

import java.io.ByteArrayInputStream;
import java.security.Security;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;

import com.test.util.SecurityCode;
import com.test.util.SecurityImage;

import com.opensymphony.xwork2.ActionSupport;

@Results({@Result(name = "success", type = "stream", params = {
		"contentType", "image/jpeg",
		"inputName", "imageStream",
		"bufferSize",
		"4096" })})
public class SecurityCodeImageAction  extends ActionSupport  implements SessionAware{
	private static final long serialVersionUID = 1496691731440581303L;
	//ͼƬ��
    private ByteArrayInputStream imageStream;
    //session��
    private Map<String, Object> session2 ;
    
    public ByteArrayInputStream getImageStream() {
        return imageStream;
    }
    public void setImageStream(ByteArrayInputStream imageStream) {
        this.imageStream = imageStream;
    }
    public void setSession(Map<String, Object> session) {
        this.session2 = session;
    }
    //@Action("imagecode")
    public String execute() throws Exception {
        //�������Hardģʽ�����Բ����ִ�Сд
        //String securityCode = SecurityCode.getSecurityCode(4,SecurityCodeLevel.Hard, false).toLowerCase();
        
        //��ȡĬ���ѶȺͳ��ȵ���֤��
        String securityCode = SecurityCode.getSecurityCode();
        imageStream = SecurityImage.getImageAsInputStream(securityCode);
        //����session��
        session2.put("securityCode", securityCode);
        return SUCCESS;
    }
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}