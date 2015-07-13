package com.apairl.action;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

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
	private File fileUpload;
	private String fileUploadContentType;
	private String fileUploadFileName;
	
	public String getRecordsByProductId(){
		List productUrlList = productUrlDAO.findByProperty("product.productId", productId);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("productUrlList", productUrlList);
		request.setAttribute("productId", productId);
		
		return SUCCESS;
	}
	
	public String saveUrl(){
		try{
			String osName = System.getProperty("os.name");
			String path = "C:/apache-tomcat-7.0.54/webapps/apairl/products/";
			if(!osName.contains("Windows")) path = "/usr/share/tomcat/webapps/apairl/products/";
	
			File file = new File(path, fileUploadFileName);
	        if(fileUploadFileName.contains(".jpg") || fileUploadFileName.contains(".jpeg")){
	        	FileUtils.copyFile(fileUpload, file);
	        }
		} catch(Exception e){
			return null;
		}
        return "products/" + fileUploadFileName;
	}
	
	public String saveRecord(){
		if(fileUploadFileName != null){
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("productId", productId);
			
			try{
				Product product = productDAO.findById(productId);
				String urlPath = saveUrl();
				ProductUrl productUrl = new ProductUrl();
				productUrl.setProduct(product);
				productUrl.setUrlPath(urlPath);
				productUrlDAO.save(productUrl);
			}catch(Exception e){
				e.printStackTrace();
				return "saveerror";
			}
		}
		return "successsave";
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

	public File getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}

	public String getFileUploadContentType() {
		return fileUploadContentType;
	}

	public void setFileUploadContentType(String fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}

	public String getFileUploadFileName() {
		return fileUploadFileName;
	}

	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}

}
