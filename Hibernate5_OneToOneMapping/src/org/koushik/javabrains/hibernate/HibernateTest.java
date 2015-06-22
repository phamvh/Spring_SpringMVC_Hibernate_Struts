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
		
		user.setVehicle(vehicle);
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction(); 
		
		session.save(user);
		session.save(vehicle);
		session.getTransaction().commit();
		
		session.close(); //this should normally inside the finally{} block
		
		
	}

}
