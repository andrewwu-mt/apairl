package com.apairl.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.apairl.dao.TopRatedDAO;
import com.apairl.dbo.TopRated;
import com.opensymphony.xwork2.ActionSupport;

public class TopRatedAction extends ActionSupport{
	
	private TopRatedDAO topRatedDAO;
	
	public String allRecords(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List<TopRated> topRatedList = topRatedDAO.findAll();
		
		for(int i=0 ; i<topRatedList.size() ; i++){
			TopRated tr = topRatedList.get(i);
			List<String> onList = new ArrayList<String>();
			List<String> offList = new ArrayList<String>();
			
			for(int k=0 ; k<tr.getRank() ; k++){
				onList.add("");
			}
			
			for(int k=0 ; k< (5-tr.getRank()) ; k++){
				offList.add("");
			}
			
			tr.setOnList(onList);
			tr.setOffList(offList);
		}

		request.setAttribute("topRatedList", topRatedList);
		
		return SUCCESS;
	}

	public TopRatedDAO getTopRatedDAO() {
		return topRatedDAO;
	}

	public void setTopRatedDAO(TopRatedDAO topRatedDAO) {
		this.topRatedDAO = topRatedDAO;
	}

}
