package com.apairl.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.apairl.dao.SlideDAO;
import com.opensymphony.xwork2.ActionSupport;

public class SlideAction extends ActionSupport{

	public SlideDAO slideDAO;
	
	public String src;
	
	public String allRecords(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List slideList = slideDAO.findAll();
		request.setAttribute("slideList", slideList);
		
		return SUCCESS;
	}

	public SlideDAO getSlideDAO() {
		return slideDAO;
	}

	public void setSlideDAO(SlideDAO slideDAO) {
		this.slideDAO = slideDAO;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}
	
}
