package com.apairl.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.apairl.dao.KabupatenDAO;
import com.apairl.dao.ProvinsiDAO;
import com.apairl.dbo.Kabupaten;
import com.apairl.dbo.Provinsi;
import com.opensymphony.xwork2.ActionSupport;

public class KabupatenAction extends ActionSupport{
	
	private ProvinsiDAO provinsiDAO;
	private KabupatenDAO kabupatenDAO;
	
	private int provinsiId;
	
	public String allRecords(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List kabupatenList = kabupatenDAO.findAll();
		request.setAttribute("kabupatenList", kabupatenList);
		
		return SUCCESS;
	}
	
	public String getRecord(){
		Provinsi provinsi = provinsiDAO.findById(1);
		List<Kabupaten> kabupatenList = kabupatenDAO.findByProperty("provinsi", provinsi);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("kabupatenList", kabupatenList);
		
		return SUCCESS;
		
	}

	public ProvinsiDAO getProvinsiDAO() {
		return provinsiDAO;
	}

	public void setProvinsiDAO(ProvinsiDAO provinsiDAO) {
		this.provinsiDAO = provinsiDAO;
	}

	public KabupatenDAO getKabupatenDAO() {
		return kabupatenDAO;
	}

	public void setKabupatenDAO(KabupatenDAO kabupatenDAO) {
		this.kabupatenDAO = kabupatenDAO;
	}

	public int getProvinsiId() {
		return provinsiId;
	}

	public void setProvinsiId(int provinsiId) {
		this.provinsiId = provinsiId;
	}
	

}
