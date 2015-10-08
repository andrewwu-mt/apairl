package com.apairl.action;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.jfree.util.Log;

import com.apairl.dao.ProductDAO;
import com.apairl.dao.ProductUrlDAO;
import com.apairl.dbo.Product;
import com.apairl.dbo.ProductUrl;
import com.opensymphony.xwork2.ActionSupport;

public class ProductUrlAction extends ActionSupport{

	private ProductUrlDAO productUrlDAO;
	private ProductDAO productDAO;
	
	private Integer productId;
	private Integer productUrlId;

	//upload file
	private File[] fileUpload;
	private String[] fileUploadContentType;
	private String[] fileUploadFileName;
	
	public String getRecordsByProductId(){
		List productUrlList = productUrlDAO.findByProperty("product.productId", productId);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("productUrlList", productUrlList);
		request.setAttribute("productId", productId);
		
		return SUCCESS;
	}
	
	public void saveUrl(String path){
		try{
			for(int i=0 ; i<fileUpload.length ; i++){
				File file = new File(path, fileUploadFileName[i]);
		        if(fileUploadFileName[i].contains(".jpg") || fileUploadFileName[i].contains(".jpeg")){
		        	FileUtils.copyFile(fileUpload[i], file);
		        }
			}
		} catch(Exception e){
			Log.error("", e);
		}
	}
	
	public String saveRecord(){
		try{
			if(fileUploadFileName != null){
				HttpServletRequest request = ServletActionContext.getRequest();
				request.setAttribute("productId", productId);
				Product product = productDAO.findById(productId);
				String workingDir = System.getProperty( "catalina.base" );
				String path = workingDir + "\\webapps\\apairl\\img\\product\\";
				saveUrl(path);
				
				for(int i=0 ; i<fileUploadFileName.length ; i++){
					ProductUrl productUrl = new ProductUrl();
					productUrl.setProduct(product);
					productUrl.setUrlPath(path + fileUploadFileName[i]);
					productUrlDAO.save(productUrl);
				}
				return "successsave";
			} else {
				return "saveerror";
			}
		}catch(Exception e){
			e.printStackTrace();
			return "saveerror";
		}
	}
	
	public String deleteRecord(){
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("productId", productId);
		
		try{
			ProductUrl pu = productUrlDAO.findById(productUrlId);
			productUrlDAO.delete(pu);
		}catch(Exception e){
			return "deleteerror";
		}
		return "successdelete";
	}

	public ProductUrlDAO getProductUrlDAO() {
		return productUrlDAO;
	}

	public void setProductUrlDAO(ProductUrlDAO productUrlDAO) {
		this.productUrlDAO = productUrlDAO;
	}

	public ProductDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getProductUrlId() {
		return productUrlId;
	}

	public void setProductUrlId(Integer productUrlId) {
		this.productUrlId = productUrlId;
	}

	public File[] getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(File[] fileUpload) {
		this.fileUpload = fileUpload;
	}

	public String[] getFileUploadContentType() {
		return fileUploadContentType;
	}

	public void setFileUploadContentType(String[] fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}

	public String[] getFileUploadFileName() {
		return fileUploadFileName;
	}

	public void setFileUploadFileName(String[] fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}

}
