package com.apairl.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.apairl.dbo.Slide;

/**
 * A data access object (DAO) providing persistence and search support for Slide
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired Slide
 * of transaction control.
 * 
 * @see com.apairl.dbo.Slide
 * @author MyEclipse Persistence Tools
 */
public class SlideDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(SlideDAO.class);
	// property constants
	public static final String NAME = "name";

	protected void initDao() {
		// do nothing
	}

	public void save(Slide transientInstance) {
		log.debug("saving Slide instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Slide persistentInstance) {
		log.debug("deleting Slide instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Slide findById(java.lang.Integer id) {
		log.debug("getting Slide instance with id: " + id);
		try {
			Slide instance = (Slide) getHibernateTemplate().get(
					"com.apairl.dbo.Slide", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Slide instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Slide as model where model."
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
		log.debug("finding all Slide instances");
		try {
			String queryString = "from Product";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Slide merge(Slide detachedInstance) {
		log.debug("merging Slide instance");
		try {
			Slide result = (Slide) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Slide instance) {
		log.debug("attaching dirty Slide instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}	
	}

	public void attachClean(Slide instance) {
		log.debug("attaching clean Slide instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SlideDAO getFromApplicationContext(ApplicationContext ctx) {
		return (SlideDAO) ctx.getBean("SlideDAO");
	}
}