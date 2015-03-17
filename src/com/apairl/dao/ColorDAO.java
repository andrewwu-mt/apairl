package com.apairl.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.apairl.dbo.Color;

/**
 * A data access object (DAO) providing persistence and search support for Color
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired Color
 * of transaction control.
 * 
 * @see com.apairl.dbo.Color
 * @author MyEclipse Persistence Tools
 */
public class ColorDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(ColorDAO.class);
	// property constants
	public static final String NAME = "name";

	protected void initDao() {
		// do nothing
	}

	public void save(Color transientInstance) {
		log.debug("saving Color instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Color persistentInstance) {
		log.debug("deleting Color instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Color findById(java.lang.Integer id) {
		log.debug("getting Color instance with id: " + id);
		try {
			Color instance = (Color) getHibernateTemplate().get(
					"com.apairl.dbo.Color", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Color instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Color as model where model."
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
		log.debug("finding all Color instances");
		try {
			String queryString = "from Color";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Color merge(Color detachedInstance) {
		log.debug("merging Color instance");
		try {
			Color result = (Color) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Color instance) {
		log.debug("attaching dirty Color instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}	
	}

	public void attachClean(Color instance) {
		log.debug("attaching clean Color instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ColorDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ColorDAO) ctx.getBean("ColorDAO");
	}
}