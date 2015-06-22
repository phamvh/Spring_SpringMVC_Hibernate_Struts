package org.koushik.javabrains.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.koushik.javabrains.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {	
		
		/**
		 * This is so far still a transient object because it has not been saved after it is created
		 */
		UserDetails user = new UserDetails();
		user.setUserName("Test user");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		
		session.beginTransaction(); 
		
		session.save(user); //From now on this object becomes PERSISTANT. Anychange to this object before session.close() will be stored to database.
		
		user.setUserName("Updated name 1");
		user.setUserName("Updated name 2");
	
		session.getTransaction().commit();
		
		user.setUserName("Updated name 3"); //this will have no effect. In fact, user becomes a DETACHED object after the commit() function is called.
		
		session.close(); //this should normally inside the finally{} block
		
		//After session.close(), the user object becomes a DETACHED object. Changes to it will no longer be updated to the database.
		user.setUserName("Updated name 4"); //this will have no effect.
		
	}

}
