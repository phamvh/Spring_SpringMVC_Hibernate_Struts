package org.koushik.javabrains.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.koushik.javabrains.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {	
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		
		session.beginTransaction(); 
		
		/*
		//Step 1: This is to create some data for the database
		for(int i =1; i <= 10; i++){
			UserDetails user = new UserDetails();
			user.setUserName("User "+i);
			session.save(user);
		}
		*/
		
		/** NAMED HQL
		 * This is how named query is accessed. Named queries are defined in UserDetails class, at the top
		 * so that all queries can be at one place and therefore they can be managed more easily.
		 */
		Query query1 = session.getNamedQuery("UserDetails.byId");
		query1.setInteger(0, 1);
		List<UserDetails> users1 = query1.list();
		for(UserDetails us : users1){
			System.out.println(us.getUserName());
		}
		
		/** NAMED NATIVE SQL
		 *  This is for named SQL, not HQL.
		 *  Check out the syntax of how named sql is defined in class UserDetails, at the top of the class.
		 */
		Query query2 = session.getNamedQuery("UserDetails.byName");
		query2.setString(0, "user 5");
		List<UserDetails> users2 = query2.list();
		for(UserDetails us : users2){
			System.out.println(us.getUserName());
		}
		
		session.getTransaction().commit();
		
		session.close(); //this should normally inside the finally{} block
	
	}

}
