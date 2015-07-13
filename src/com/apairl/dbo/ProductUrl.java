package com.apairl.dbo;



/**
 * ApProductSrc entity. @author MyEclipse Persistence Tools
 */

public class ProductUrl  implements java.io.Serializable {


    // Fields    

     private Integer productUrlId;
     private Product product;
     private String urlPath;

 	/** default constructor */
 	public ProductUrl() {
 	}

    // Constructors

    /** full constructor */
    public ProductUrl(Product product, String urlPath) {
        this.product = product;
        this.urlPath = urlPath;
    }

	public Integer getProductUrlId() {
		return productUrlId;
	}

	public void setProductUrlId(Integer productUrlId) {
		this.productUrlId = productUrlId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getUrlPath() {
		return urlPath;
	}

	public void setUrlPath(String urlPath) {
		this.urlPath = urlPath;
	}

}