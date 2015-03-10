package com.apairl.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.apairl.dbo.ProductSrc;

/**
 	* A data access object (DAO) providing persistence and search support for ProductSrc entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.apairl.dbo.ProductSrc
  * @author MyEclipse Persistence Tools 
 */
public class ProductSrcDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(ProductSrcDAO.class);
		//property constants



    
    public void save(ProductSrc transientInstance) {
        log.debug("saving ProductSrc instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(ProductSrc persistentInstance) {
        log.debug("deleting ProductSrc instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ProductSrc findById( com.apairl.dbo.ProductSrcId id) {
        log.debug("getting ProductSrc instance with id: " + id);
        try {
            ProductSrc instance = (ProductSrc) getHibernateTemplate()
                    .get("com.apairl.dbo.ProductSrc", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding ProductSrc instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ProductSrc as model where model." 
         						+ propertyName + "= ?";
         
			return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


    public void deleteBySrcId(Integer srcId){
    	String queryString = "delete ap_product_src where src_id = "+srcId+" ";
    	
    	Session session = this.getHibernateTemplate().getSessionFactory().openSession();
    	SQLQuery query = session.createSQLQuery(queryString);
    	query.executeUpdate();
    	session.flush();
    	session.clear();
    	session.close();
    }
    
	public List findAll() {
		log.debug("finding all ProductSrc instances");
		try {
			String queryString = "from ProductSrc";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public ProductSrc merge(ProductSrc detachedInstance) {
        log.debug("merging ProductSrc instance");
        try {
            ProductSrc result = (ProductSrc) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(ProductSrc instance) {
        log.debug("attaching dirty ProductSrc instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ProductSrc instance) {
        log.debug("attaching clean ProductSrc instance");
        try {
                      	getHibernateTemplate().lock(instance, LockMode.NONE);
                        log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}