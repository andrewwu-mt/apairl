package com.apairl.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.apairl.dbo.Featured;

/**
 * A data access object (DAO) providing persistence and search support for Featured
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.apairl.dbo.Featured
 * @author MyEclipse Persistence Tools
 */
public class FeaturedDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(FeaturedDAO.class);
	// property constants
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";

	protected void initDao() {
		// do nothing
	}

	public void save(Featured transientInstance) {
		log.debug("saving Featured instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Featured persistentInstance) {
		log.debug("deleting Featured instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Featured findById(java.lang.Integer id) {
		log.debug("getting Featured instance with id: " + id);
		try {
			Featured instance = (Featured) getHibernateTemplate().get(
					"com.apairl.dbo.Featured", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Featured instance) {
		log.debug("finding Featured instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Featured instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Featured as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}

	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public void deleteAllRecords(){
		Session session = this.getHibernateTemplate().getSessionFactory().openSession();
		try{
			String queryString = "delete ap_featured";
			SQLQuery query = session.createSQLQuery(queryString);
			query.executeUpdate();
			session.flush();
			session.clear();
		}catch(Exception e){
			log.error("", e);
		} finally{
			session.close();
		}
		
	}
	
	public List findAll() {
		log.debug("finding all Featured instances");
		try {
			String queryString = "from Featured";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Featured merge(Featured detachedInstance) {
		log.debug("merging Featured instance");
		try {
			Featured result = (Featured) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Featured instance) {
		log.debug("attaching dirty Featured instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Featured instance) {
		log.debug("attaching clean Featured instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static FeaturedDAO getFromApplicationContext(ApplicationContext ctx) {
		return (FeaturedDAO) ctx.getBean("FeaturedDAO");
	}
}