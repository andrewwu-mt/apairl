package com.apairl.dao;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.apairl.dbo.OrderProduct;

/**
 * A data access object (DAO) providing persistence and search support for OrderProduct
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.apairl.dbo.OrderProduct
 * @author MyEclipse Persistence Tools
 */
public class OrderProductDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(OrderProductDAO.class);
	// property constants
	public static final String AMOUNT = "amount";
	public static final String TYPE = "type";
	public static final String PRICE = "price";

	protected void initDao() {
		// do nothing
	}

	public void save(OrderProduct transientInstance) {
		log.debug("saving OrderProduct instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(OrderProduct persistentInstance) {
		log.debug("deleting OrderProduct instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public OrderProduct findById(java.lang.Integer id) {
		log.debug("getting OrderProduct instance with id: " + id);
		try {
			OrderProduct instance = (OrderProduct) getHibernateTemplate().get(
					"com.apairl.dbo.OrderProduct", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(OrderProduct instance) {
		log.debug("finding OrderProduct instance by example");
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
		log.debug("finding OrderProduct instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from OrderProduct as model left join fetch model.customer as c left join fetch model.product as p where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAmount(Object amount) {
		return findByProperty(AMOUNT, amount);
	}

	public List findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	public List findAll() {
		log.debug("finding all OrderProduct instances");
		try {
			String queryString = "from OrderProduct";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public OrderProduct merge(OrderProduct detachedInstance) {
		log.debug("merging OrderProduct instance");
		try {
			OrderProduct result = (OrderProduct) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(OrderProduct instance) {
		log.debug("attaching dirty OrderProduct instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(OrderProduct instance) {
		log.debug("attaching clean OrderProduct instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static OrderProduct getFromApplicationContext(ApplicationContext ctx) {
		return (OrderProduct) ctx.getBean("OrderProductDAO");
	}
}