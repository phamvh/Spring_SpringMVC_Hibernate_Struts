package org.koushik.javabrains.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.koushik.javabrains.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {	
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		/*
		//Step 1: This is to create some data for the database
		for(int i =1; i <= 10; i++){
			UserDetails user = new UserDetails();
			user.setUserName("User "+i);
			session.save(user);
		}
		*/		
		
		/**
		 * This application configured hibernate to use ehcache, which is an external lib, for second-level caching.
		 * Check out how cache is enabled and how hibernate is configured in the hibernate.cfg.xml to use ehcache.
		 * Also, check the class UserDetails to see how it has to be configured to be cacheable. It is needed 
		 * for both this query cache and second-level cache in the previous tutorial
		 * 
		 * So in two different sessions,  two queries are created but only one "select ..." statement is executed
		 * because in the second retrieval, the object is retrieved from cache, not from db.
		 * 
		 * This cache works across different sessions
		 */
		
		Session session = sessionFactory.openSession();
		session.beginTransaction(); 		
		
		Query query = session.createQuery("from UserDetails user where user.userId=1");
		query.setCacheable(true);
		query.list();
		
		session.getTransaction().commit();		
		session.close(); //this should normally inside the finally{} block
	
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction(); 		
		
		Query query2 = session2.createQuery("from UserDetails user where user.userId=1");
		query2.setCacheable(true);
		query2.list();
		
		session2.getTransaction().commit();		
		session2.close(); 
	}

}
