package com.apairl.dbo;



/**
 * ApProductSrc entity. @author MyEclipse Persistence Tools
 */

public class ProductSrc  implements java.io.Serializable {


    // Fields    

     private ProductSrcId id;

 	/** default constructor */
 	public ProductSrc() {
 	}

    // Constructors

    /** full constructor */
    public ProductSrc(ProductSrcId id) {
        this.id = id;
    }

   
    // Property accessors

    public ProductSrcId getId() {
        return this.id;
    }
    
    public void setId(ProductSrcId id) {
        this.id = id;
    }

}