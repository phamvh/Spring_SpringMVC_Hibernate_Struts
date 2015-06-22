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
		
		/**
		 * Note that UserDetails is the name of the class, not the name of the table in MySQL
		 */
		Query query = session.createQuery("from UserDetails where userId > 0"); //Note that userId is the property's name in the UserDetails Class, not the column name in the MySQL table
		
		/**
		 * Other posible queries:
		 * session.createQuery("select userName from UserDetails where userId > 0"); This will create a list of String: List<String> in query.list()
		 * session.createQuery("select userId, userName from UserDetails"); this will create a list of list: all properties in each record are represented in a list
		 * session.createQuery("select new map(userId, userName) from UserDetails where userId > 0"); this will create a list of maps
		 * session.createQuery("select max(userId) from UserDetails"); this "PROBABLY" will create a list that contains one single integer. Haven't checked yet. Try it!
		 */
		
		query.setFirstResult(5); //Skip the first 5 records in the returned list.
		query.setMaxResults(4); //return up to 4 records. In combination withsetFirstResult(5), this will return users 6,7,8, and 9.
		
		//This returns all the records in the table that match the query's criteria.
		List<UserDetails> users = query.list();
		
        for(UserDetails u: users){
        	System.out.println(u.getUserName());
        }
		
		session.getTransaction().commit();
		
		session.close(); //this should normally inside the finally{} block
		
		///==================================================================///
		///   SQL Injection and parameter binding
		/**
		 * This section shows how SQL can be injected by hackers to retrieve unauthorized data from db.
		 * And how parameter binding can help eliminate such leakage.
		 */
		session = sessionFactory.openSession();		
		session.beginTransaction(); 
		String minId = "5";
		String userName = "User 9";
		
		/**
		 * This is where SQL injection can be done. It can be done by setting minId = "5 or 1=1", which will return all the records in the table, which is not good.
		 */
		Query query1 = session.createQuery("from UserDetails where userId >= "+" 5 or 1=1");
		List<UserDetails> usersOfQuery1 = query1.list();
		System.out.println("Users of query1 =====================");
		for(UserDetails us : usersOfQuery1){
			System.out.println(us.getUserName());
		}
		/**
		 * Binding parameter using question mark ?
		 */
		Query query2 = session.createQuery("from UserDetails where userId >= ? and userName = ?");
		query2.setInteger(0, Integer.parseInt(minId)); //NOTE that the index starts from 0, not 1.
		query2.setString(1, userName);
		List<UserDetails> usersOfQuery2 = query2.list();
		System.out.println("Users of query2 =====================");
		for(UserDetails us : usersOfQuery2){
			System.out.println(us.getUserName());
		}
		
		/**
		 * Binding parameter using String
		 */
		Query query3 = session.createQuery("from UserDetails where userId >= :minimumId and userName = :nameOfUser");
		query3.setInteger("minimumId", Integer.parseInt(minId)); //the first argument is the string in the query, which follows a colon :
		query3.setString("nameOfUser", userName);
		List<UserDetails> usersOfQuery3 = query3.list();
		System.out.println("Users of query3 ======================");
		for(UserDetails us : usersOfQuery3){
			System.out.println(us.getUserName());
		}
		
		/**
		 * Try to inject an SQL query into a parameter-binding query and see what happens.
		 */
		Query query4 = session.createQuery("from UserDetails where userName = ?");
		/**
		 * This is where SQL is injected at the end of the original query.
		 * Hibernate will simply return an empty list of this.
		 * Try, alternatively, session.createQuery("from UserDetails where userName = 'User 9' or 1=1"); -->>> this will return all the records in the table.
		 */
		query4.setString(0, userName +" or 1=1"); 
		List<UserDetails> usersOfQuery4 = query4.list();
		System.out.println("Users of query4 =====================");
		for(UserDetails us : usersOfQuery4){
			System.out.println(us.getUserName());
		}
		
	}

}
