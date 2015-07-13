package com.apairl.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.apairl.dbo.ProductUrl;

/**
 	* A data access object (DAO) providing persistence and search support for ProductUrl entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.apairl.dbo.ProductUrl
  * @author MyEclipse Persistence Tools 
 */
public class ProductUrlDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(ProductUrlDAO.class);
		//property constants



    
    public void save(ProductUrl transientInstance) {
        log.debug("saving ProductUrl instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
    
    
	public void delete(ProductUrl persistentInstance) {
        log.debug("deleting ProductUrl instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public ProductUrl findById( Integer id) {
        log.debug("getting ProductUrl instance with id: " + id);
        try {
            ProductUrl instance = (ProductUrl) getHibernateTemplate()
                    .get("com.apairl.dbo.ProductUrl", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding ProductUrl instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from ProductUrl as model where model." 
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

	public void updateAllPrimary(Integer productId, Integer isPrimary) {
		log.debug("finding all ProductUrl instances");
		try {
			String queryString = "update ap_product_src set is_primary = "+isPrimary+" where product_id = "+productId+" ";
			
			Session session = this.getHibernateTemplate().getSessionFactory().openSession();
			SQLQuery query = session.createSQLQuery(queryString);
			query.executeUpdate();
			session.flush();
			session.clear();
			session.close();
			
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public void updatePrimaryByProductAndSrc(Integer productId, Integer srcId, Integer isPrimary) {
		log.debug("finding all ProductUrl instances");
		try {
			String queryString = "update ap_product_src set is_primary = "+isPrimary+" where product_id = "+productId+" and src_id = "+srcId+" ";
			
			Session session = this.getHibernateTemplate().getSessionFactory().openSession();
			SQLQuery query = session.createSQLQuery(queryString);
			query.executeUpdate();
			session.flush();
			session.clear();
			session.close();
			
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List findAll() {
		log.debug("finding all ProductUrl instances");
		try {
			String queryString = "from ProductUrl";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public ProductUrl merge(ProductUrl detachedInstance) {
        log.debug("merging ProductUrl instance");
        try {
            ProductUrl result = (ProductUrl) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(ProductUrl instance) {
        log.debug("attaching dirty ProductUrl instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(ProductUrl instance) {
        log.debug("attaching clean ProductUrl instance");
        try {
                      	getHibernateTemplate().lock(instance, LockMode.NONE);
                        log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}