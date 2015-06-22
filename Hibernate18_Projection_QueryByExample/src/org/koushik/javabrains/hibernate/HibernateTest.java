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
		 * This will return a list of Integers
		 */
		Criteria criteria = session.createCriteria(UserDetails.class)
									.setProjection(Projections.property("userId"))
									.addOrder(Order.desc("userId"));
		
		//Or this example:
		/*
		List results = session.createCriteria(Cat.class)
			    .setProjection( Projections.projectionList()
			        .add( Projections.rowCount() )
			        .add( Projections.avg("weight") )
			        .add( Projections.max("weight") )
			        .add( Projections.groupProperty("color") )
			    )
			    .list();
			    
			    
		List results = session.createCriteria(Cat.class)
			    .setProjection( Projections.rowCount() )
			    .add( Restrictions.eq("color", Color.BLACK) )
			    .list();
		*/
		
		
		//=================  Query by example ==============================
		/**
		 * This is an example object, which will be passed to hibernate
		 * Hibernate will 
		 */
		UserDetails exampleUser = new UserDetails();
		exampleUser.setUserId(5); //this one will have no effect because hibernate does not consider example for PRIMARY KEY
		exampleUser.setUserName("User 1%");
		
		/**
		 * This creates an example for hibernate from exampleUser, 
		 * exclude any property we don't want to consider in the example,
		 * and enable "like" because we use the percentage sign in the example's userName
		 */
		Example example = Example.create(exampleUser).excludeProperty("userId").enableLike();
		
		Criteria criteria1 = session.createCriteria(UserDetails.class)
									.add(example);
		
		
		
		session.getTransaction().commit();
		
		session.close(); //this should normally inside the finally{} block
	
	}

}
