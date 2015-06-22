package org.koushik.javabrains.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.koushik.javabrains.dto.Address;
import org.koushik.javabrains.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		//No need to set ID anymore because it is a surrogate key and hibernate generates it automatically
		user.setUserName("First User");
		
		UserDetails user2 = new UserDetails();
		user2.setUserName("Second User");
		
		Address addr = new Address();
		addr.setStreet("Orange grove");
		addr.setCity("Los Angeles");
		
		Address officeAddr = new Address();
		officeAddr.setStreet("Orange grove Office");
		officeAddr.setCity("Los Angeles Office");
		
		user.setAddress(addr);
		user.setOfficeAddress(officeAddr);
		user2.setAddress(addr);
		user2.setOfficeAddress(officeAddr);
		
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
		session.save(user2);
		session.getTransaction().commit();
		
		session.close(); //this should normally inside the finally{} block
		

	}

}
