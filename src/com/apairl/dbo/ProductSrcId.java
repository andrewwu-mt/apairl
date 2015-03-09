package com.apairl.dbo;



/**
 * ApProductSrcId entity. @author MyEclipse Persistence Tools
 */

public class ProductSrcId  implements java.io.Serializable {


    // Fields    

    private Product product;
    private Src src;


    // Constructors

    /** default constructor */
    public ProductSrcId() {
    }

    
    /** full constructor */
    public ProductSrcId(Product product, Src src) {
        this.product = product;
        this.src = src;
    }

   
    // Property accessors

    public Product getProduct() {
    	return product;
	}
	
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	public Src getSrc() {
		return src;
	}
	
	
	public void setSrc(Src src) {
		this.src = src;
	}

   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ProductSrcId) ) return false;
		 ProductSrcId castOther = ( ProductSrcId ) other; 
         
		 return ( (this.getProduct()==castOther.getProduct()) || ( this.getProduct()!=null && castOther.getProduct()!=null && this.getProduct().equals(castOther.getProduct()) ) )
				 && ( (this.getSrc()==castOther.getSrc()) || ( this.getSrc()!=null && castOther.getSrc()!=null && this.getSrc().equals(castOther.getSrc()) ) );
   }
   

   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getProduct() == null ? 0 : this.getProduct().hashCode() );
         result = 37 * result + ( getSrc() == null ? 0 : this.getSrc().hashCode() );
         return result;
   }   





}