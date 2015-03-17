package com.apairl.dbo;



/**
 * ApProductSrc entity. @author MyEclipse Persistence Tools
 */

public class ProductSrc  implements java.io.Serializable {


    // Fields    

     private ProductSrcId id;
     private Short isPrimary;

 	/** default constructor */
 	public ProductSrc() {
 	}

    // Constructors

    /** full constructor */
    public ProductSrc(ProductSrcId id, Short isPrimary) {
        this.id = id;
        this.isPrimary = isPrimary;
    }

   
    // Property accessors

    public ProductSrcId getId() {
        return this.id;
    }
    
    public void setId(ProductSrcId id) {
        this.id = id;
    }

	public Short getIsPrimary() {
		return isPrimary;
	}

	public void setIsPrimary(Short isPrimary) {
		this.isPrimary = isPrimary;
	}

}