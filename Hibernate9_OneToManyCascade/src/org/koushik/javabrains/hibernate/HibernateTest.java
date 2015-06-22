package org.koushik.javabrains.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.koushik.javabrains.dto.UserDetails;
import org.koushik.javabrains.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		user.setUserName("First User");
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Toyota");
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Jeep");
		
		//one to many
		user.getVehicle().add(vehicle);
		user.getVehicle().add(vehicle2);
		
	
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction(); 
		
		/**
		 * Note that method pesist() is used here instead of save()
		 */
		session.persist(user); 
		
		/*
		 * This code is no longer needed because cascading saving is used.
		session.save(vehicle);
		session.save(vehicle2);
		*/
		session.getTransaction().commit();
		
		session.close(); //this should normally inside the finally{} block
		
		
	}

}
