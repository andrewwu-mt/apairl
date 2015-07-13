package com.apairl.action;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.apairl.dao.CategoryDAO;
import com.apairl.dao.ColorDAO;
import com.apairl.dao.ProductDAO;
import com.apairl.dao.ProductUrlDAO;
import com.apairl.dao.SizeDAO;
import com.apairl.dao.StockDAO;
import com.apairl.dao.TypeDAO;
import com.apairl.dbo.Color;
import com.apairl.dbo.Product;
import com.apairl.dbo.Size;
import com.apairl.dbo.Stock;
import com.opensymphony.xwork2.ActionSupport;

public class ProductAction extends ActionSupport{
	private static final Logger log = Logger.getLogger(ProductAction.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = -8753468506104304065L;
	
	
	private ProductDAO productDAO;
	private TypeDAO typeDAO;
	private StockDAO stockDAO;
	private CategoryDAO categoryDAO;
	private ProductUrlDAO productSrcDAO;
	private SizeDAO sizeDAO;
	private ColorDAO colorDAO;
	
	private Integer typeId;
	private String productName;
	private String searchKeyword;
	
	
	private Integer sizeId;
	private Integer colorId;
	private Integer productId;
	private Integer categoryId;
	private String name;
	private String description;
	private Integer price;
	private Integer active;
	private String shortName;
	private String aboutProduct;
	
	//upload file
	private File fileUpload;
	private String fileUploadContentType;
	private String fileUploadFileName;
	
	public String homeRecords(){
		List<Product> productList1 = new ArrayList<Product>();
		List<Product> productList2 = new ArrayList<Product>();
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Product> products = productDAO.findByProperty("type.typeId", 1);
		for(int i=0 ; i<products.size() ; i++){
			productList1.add(products.get(i));
			if(productList1.size() > 3){
				break;
			}
		}
		
		products = productDAO.findByProperty("type.typeId", 2);
		for(int i=0 ; i<products.size() ; i++){
			productList2.add(products.get(i));
			if(productList2.size() > 2){
				break;
			}
		}

		
		request.setAttribute("productList1", productList1);
		request.setAttribute("productList2", productList2);
		
		return SUCCESS;
	}
	
	public String allRecords(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Product> productList = productDAO.findAll();
		request.setAttribute("productList", productList);
		
		return SUCCESS;
	}
	
	public String getRecord(){
		Product product = null;

		if(productName != null && !"".equals(productName)){
			product = (Product) productDAO.findByName(productName).get(0);
		} else {
			product = productDAO.findById(productId);
		}
		
		List<Stock> stockList = stockDAO.findByProperty("product.productId", product.getProductId());
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("stockList", stockList);
		
		return SUCCESS;
	}
	
	public String searchRecord(){
		List<Product> productList = productDAO.findByLike("name", searchKeyword);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("searchKeyword", searchKeyword);
		request.setAttribute("productList", productList);
		
		return SUCCESS;
	}
	
	//Admin permission
	
	public String saveRecord(){
		try{
			Product product = new Product();
			product.setName(name);
			product.setDescription(description);
			product.setPrice(price);
			product.setActive(active);
			product.setInsertDate(new Timestamp(System.currentTimeMillis()));
			product.setUpdateDate(new Timestamp(System.currentTimeMillis()));
			productDAO.save(product);
			
			Stock stock = new Stock();
			stock.setQty(0);
			
			Size size = sizeDAO.findById(sizeId);
			stock.setSize(size);
			
			Color color = colorDAO.findById(colorId);
			stock.setColor(color);
			
			stock.setProduct(product);
			stockDAO.save(stock);
			
		}catch(Exception e){
			log.error("Save product failed", e);
			return "saveerror";
		}
		return "successsave";
	}
	
	public String updateRecord(){
		try{
			Product product = productDAO.findById(productId);
			product.setName(name);
			product.setDescription(description);
			product.setPrice(price);
			product.setActive(active);
			productDAO.update(product);
			
		}catch(Exception e){
			log.error("Update product failed", e);
			return "updateerror";
		}
		return SUCCESS;
	}
	
	
	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public ProductDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public TypeDAO getTypeDAO() {
		return typeDAO;
	}

	public void setTypeDAO(TypeDAO typeDAO) {
		this.typeDAO = typeDAO;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public StockDAO getStockDAO() {
		return stockDAO;
	}

	public void setStockDAO(StockDAO stockDAO) {
		this.stockDAO = stockDAO;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}


	public String getAboutProduct() {
		return aboutProduct;
	}

	public void setAboutProduct(String aboutProduct) {
		this.aboutProduct = aboutProduct;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
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

	public CategoryDAO getCategoryDAO() {
		return categoryDAO;
	}

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public ProductUrlDAO getProductSrcDAO() {
		return productSrcDAO;
	}

	public void setProductSrcDAO(ProductUrlDAO productSrcDAO) {
		this.productSrcDAO = productSrcDAO;
	}

	public SizeDAO getSizeDAO() {
		return sizeDAO;
	}

	public void setSizeDAO(SizeDAO sizeDAO) {
		this.sizeDAO = sizeDAO;
	}

	public ColorDAO getColorDAO() {
		return colorDAO;
	}

	public void setColorDAO(ColorDAO colorDAO) {
		this.colorDAO = colorDAO;
	}

	public Integer getSizeId() {
		return sizeId;
	}

	public void setSizeId(Integer sizeId) {
		this.sizeId = sizeId;
	}

	public Integer getColorId() {
		return colorId;
	}

	public void setColorId(Integer colorId) {
		this.colorId = colorId;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public static Logger getLog() {
		return log;
	}
	
}
