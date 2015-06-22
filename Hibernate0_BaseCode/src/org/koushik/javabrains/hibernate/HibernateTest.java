package org.koushik.javabrains.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.koushik.javabrains.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		user.setUserId(1);
		user.setUserName("First User");
		
		/**
		 * This SessionFactory is expensive and takes a lot of sources, so it should be created only once per application
		 * 
		 */
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction(); 
		
		/**
		 * use session to store object to DB
		 */
		session.save(user);
		session.getTransaction().commit();
		
		session.close(); //this should normally inside the finally{} block

	}

}
