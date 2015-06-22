package org.koushik.javabrains.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.koushik.javabrains.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {	
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		
		session.beginTransaction(); 
		
		/* Step 1: This is to create some data for the database
		for(int i =0; i < 10; i++){
			UserDetails user = new UserDetails();
			user.setUserName("User "+i);
			session.save(user);
		}
		*/
		
		UserDetails  user  = (UserDetails)session.get(UserDetails.class, 1);
		/*
		session.delete(user);
		*/
		user.setUserName("updated name");
		session.update(user);
		
		/**
		 * Note that even without called session.update, any changes to the object that was previously retrived 
		 * using session.get() will get stored in the database, which is quite WEIRD.
		 * 
		 * For example: If we have:
		 * ========
		 * UserDetails  user  = (UserDetails)session.get(UserDetails.class, 1);
		 * user.setUserName("Another updated name");
		 * session.getTransaction().commit();
		 * session.close();
		 * =========
		 * then the new name "Another updated name" will get updated to database, even though we did not call session.update()
		 * So be CAREFUL!!!!
		 * Make sure to call commit() and session.close() before doing any updates that you don't want to be stored in DB.
		 * 
		 */
		
		session.getTransaction().commit();
		user.setUserName("fifth updated name"); //this will have no effect
		session.close(); //this should normally inside the finally{} block
		user.setUserName("sixth updated name"); //this will have no effect either
		
	}

}
