package com.apairl.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.apairl.dbo.Size;

/**
 * A data access object (DAO) providing persistence and search support for Size
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired Size
 * of transaction control.
 * 
 * @see com.apairl.dbo.Size
 * @author MyEclipse Persistence Tools
 */
public class SizeDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(SizeDAO.class);
	// property constants
	public static final String NAME = "name";

	protected void initDao() {
		// do nothing
	}

	public void save(Size transientInstance) {
		log.debug("saving Size instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Size persistentInstance) {
		log.debug("deleting Size instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Size findById(java.lang.Integer id) {
		log.debug("getting Size instance with id: " + id);
		try {
			Size instance = (Size) getHibernateTemplate().get(
					"com.apairl.dbo.Size", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Size instance) {
		log.debug("finding Size instance by example");
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
		log.debug("finding Size instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Size as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findAll() {
		log.debug("finding all Size instances");
		try {
			String queryString = "from Size";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Size merge(Size detachedInstance) {
		log.debug("merging Size instance");
		try {
			Size result = (Size) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Size instance) {
		log.debug("attaching dirty Size instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}	
	}

	public void attachClean(Size instance) {
		log.debug("attaching clean Size instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SizeDAO getFromApplicationContext(ApplicationContext ctx) {
		return (SizeDAO) ctx.getBean("SizeDAO");
	}
}