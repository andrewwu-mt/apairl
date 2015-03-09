package com.apairl.action;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.apairl.dao.ProductDAO;
import com.apairl.dao.ProductSrcDAO;
import com.apairl.dao.SrcDAO;
import com.apairl.dbo.Product;
import com.apairl.dbo.ProductSrc;
import com.apairl.dbo.ProductSrcId;
import com.apairl.dbo.Src;
import com.opensymphony.xwork2.ActionSupport;

public class ProductSrcAction extends ActionSupport{

	private ProductSrcDAO productSrcDAO;
	private ProductDAO productDAO;
	private SrcDAO srcDAO;
	
	private Integer productId;
	private Integer srcId;

	//upload file
	private File fileUpload;
	private String fileUploadContentType;
	private String fileUploadFileName;
	
	public String getRecordsByProductId(){
		List productSrcList = productSrcDAO.findByProperty("id.product.productId", productId);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("productSrcList", productSrcList);
		request.setAttribute("productId", productId);
		
		return SUCCESS;
	}
	
	public String savePrimaryThumbnail(){
		try{
			Product product = productDAO.findById(productId);
			Src src = srcDAO.findById(srcId);
			product.setSrc(src.getValue());
			productDAO.update(product);
		}catch(Exception e){
			return "saveerror";
		}
		
		
		return SUCCESS;
	}
	
	public Src saveSrc(){
		Src src = new Src();
		try{
			String osName = System.getProperty("os.name");
			String path = "C:/apache-tomcat-7.0.54/webapps/apairl/products/";
			if(!osName.contains("Windows")) path = "/usr/share/tomcat/webapps/apairl/products/";
	
			File file = new File(path, fileUploadFileName);
	        if(fileUploadFileName.contains(".jpg") || fileUploadFileName.contains(".jpeg")){
	        	FileUtils.copyFile(fileUpload, file);
	        	src.setValue("products/" + fileUploadFileName);
	        	srcDAO.save(src);
	        }
		} catch(Exception e){
			return null;
		}
        return src;
	}
	
	public String saveRecord(){
		if(fileUploadFileName != null){
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("productId", productId);
			
			try{
				Product product = productDAO.findById(productId);
				Src src = saveSrc();
				ProductSrc productSrc = new ProductSrc();
				ProductSrcId id = new ProductSrcId();
				id.setProduct(product);
				id.setSrc(src);
				productSrc.setId(id);
				productSrcDAO.save(productSrc);

			}catch(Exception e){
				return "saveerror";
			}
		}
		return "savesuccess";
	}
	
	public String deleteBySrcId(){
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("productId", productId);
		
		try{
			productSrcDAO.deleteBySrcId(srcId);
			Src src = srcDAO.findById(srcId);
			srcDAO.delete(src);
		}catch(Exception e){
			return "deleteerror";
		}
		return "successdelete";
	}

	public ProductSrcDAO getProductSrcDAO() {
		return productSrcDAO;
	}

	public void setProductSrcDAO(ProductSrcDAO productSrcDAO) {
		this.productSrcDAO = productSrcDAO;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getSrcId() {
		return srcId;
	}

	public void setSrcId(Integer srcId) {
		this.srcId = srcId;
	}

	public ProductDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	public SrcDAO getSrcDAO() {
		return srcDAO;
	}

	public void setSrcDAO(SrcDAO srcDAO) {
		this.srcDAO = srcDAO;
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
