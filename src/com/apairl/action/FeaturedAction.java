package com.apairl.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.jfree.util.Log;

import com.apairl.dao.FeaturedDAO;
import com.apairl.dao.ProductDAO;
import com.apairl.dbo.Featured;
import com.apairl.dbo.Product;
import com.opensymphony.xwork2.ActionSupport;

public class FeaturedAction extends ActionSupport{

	private FeaturedDAO featuredDAO;	
	private ProductDAO productDAO;
	
	private List<Integer> productIdList;
	
	public String allRecords(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List featuredList = featuredDAO.findAll();
		request.setAttribute("featuredList", featuredList);
		return SUCCESS;
	}
	
	//Admin permission
	
	public String updateRecords(){
		featuredDAO.deleteAllRecords();
		for(Integer productId : productIdList){
			Featured f = new Featured();
			Product product = productDAO.findById(productId);
			f.setProduct(product);
			try{
				featuredDAO.save(f);
			}catch(Exception e){
				Log.error("", e);
			}
		}
		return SUCCESS;
	}

	public FeaturedDAO getFeaturedDAO() {
		return featuredDAO;
	}

	public void setFeaturedDAO(FeaturedDAO featuredDAO) {
		this.featuredDAO = featuredDAO;
	}

	public ProductDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	public List<Integer> getProductIdList() {
		return productIdList;
	}

	public void setProductIdList(List<Integer> productIdList) {
		this.productIdList = productIdList;
	}
	
}
