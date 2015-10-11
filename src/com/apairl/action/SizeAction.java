package com.apairl.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.apairl.dao.SizeDAO;
import com.opensymphony.xwork2.ActionSupport;

public class SizeAction extends ActionSupport{

	private SizeDAO sizeDAO;
	
	public String allRecords(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List sizeList = sizeDAO.findAll();
		request.setAttribute("sizeList", sizeList);
		return SUCCESS;
	}

	public SizeDAO getSizeDAO() {
		return sizeDAO;
	}

	public void setSizeDAO(SizeDAO sizeDAO) {
		this.sizeDAO = sizeDAO;
	}
	
}
