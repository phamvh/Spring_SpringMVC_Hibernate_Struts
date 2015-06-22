package org.koushik.javabrains.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
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
		
		/**
		 * A criteria is more like a WHERE statement. You can specify the conditions here.
		 */
		Criteria criteria = session.createCriteria(UserDetails.class);
		//add an EQUAL statement
		criteria.add(Restrictions.like("userName", "%User %0"))
				 .add(Restrictions.gt("userId", 5))
				 .add(Restrictions.between("userId", 5, 20));
		
		
		/*  we can add an OR clause like this:
		criteria.add(Restrictions.or(Restrictions.between(propertyName, lo, hi), 
				 					Restrictions.ge(propertyName, value)));
		*/
		
		List<UserDetails> users = (List<UserDetails>)criteria.list();
		for(UserDetails user : users){
			System.out.println(user.getUserName());
		}
		
		session.getTransaction().commit();
		
		session.close(); //this should normally inside the finally{} block
	
	}

}
