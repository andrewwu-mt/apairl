package com.apairl.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.apairl.dbo.Src;

/**
 	* A data access object (DAO) providing persistence and search support for Src entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.apairl.dbo.Src
  * @author MyEclipse Persistence Tools 
 */
public class SrcDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(SrcDAO.class);
		//property constants
	public static final String VALUE = "value";


	public void attachDirty(Src instance) {
		log.debug("attaching dirty Adaptor instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
    
    public void save(Src transientInstance) {
        log.debug("saving Src instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Src persistentInstance) {
        log.debug("deleting Src instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Src findById( java.lang.Integer id) {
        log.debug("getting Src instance with id: " + id);
        try {
            Src instance = (Src) getHibernateTemplate()
                    .get("com.apairl.dbo.Src", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public Src findByValue(String value){
    	String queryString = "from Src as model where model.value = ? ";
    	List list = this.getHibernateTemplate().find(queryString, value);
    	if(list.size() != 0){
    		return (Src) list.get(0);
    	} else {
    		return null;
    	}
    	
    }
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Src instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Src as model where model." 
         						+ propertyName + "= ?";
         
		 return getHibernateTemplate().find(queryString);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findAll() {
		log.debug("finding all Src instances");
		try {
			String queryString = "from Src";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}