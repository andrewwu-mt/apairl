package com.apairl.dbo;

import java.util.HashSet;
import java.util.Set;


/**
 * ApSrc entity. @author MyEclipse Persistence Tools
 */

public class Src  implements java.io.Serializable {


    // Fields    

     private Integer srcId;
     private String value;
     private Set productSrcs = new HashSet(0);


    // Constructors

    /** default constructor */
    public Src() {
    }

	/** minimal constructor */
    public Src(String value) {
        this.value = value;
    }
    
    /** full constructor */
    public Src(String value, Set productSrcs) {
        this.value = value;
        this.productSrcs = productSrcs;
    }

   
    // Property accessors

    public Integer getSrcId() {
        return this.srcId;
    }
    
    public void setSrcId(Integer srcId) {
        this.srcId = srcId;
    }

    public String getValue() {
        return this.value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }

	public Set getProductSrcs() {
		return productSrcs;
	}

	public void setProductSrcs(Set productSrcs) {
		this.productSrcs = productSrcs;
	}

}