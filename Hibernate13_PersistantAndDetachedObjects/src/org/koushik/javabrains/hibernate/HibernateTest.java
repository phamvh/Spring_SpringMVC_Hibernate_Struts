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
		
		//NOTE: there must be a user in the database with ID=1 for this to work.
		UserDetails user = (UserDetails)session.get(UserDetails.class,1); //From now on this object becomes PERSISTANT. Anychange to this object before session.close() will be stored to database.
	
		session.getTransaction().commit();
		session.close();
		/**
		 * after this point, the object user becomes DETACHED!!!!!!!!!!!! from session.
		 */
		
		user.setUserName("John"); //this is a new update to the object user.
		
		session = sessionFactory.openSession();
		session.beginTransaction(); 
		/**
		 * Use session.update() to change the state of user object from DETACHED to PERSISTANT
		 * Now, this will force hibernate to update user, even if there has been no changes made 
		 * to object user at all since it was retrieved from db. 
		 * To avoid this, or in other words, to force hibernate to update user only if there is changes to object user,
		 * we need to give a specification to class UserDetails. Check out class UserDetails for annotation: 
		 * @org.hibernate.annotations.Entity(selectBeforeUpdate=true)
		 */
		session.update(user);
		session.getTransaction().commit();
		session.close();
		
	}

}
