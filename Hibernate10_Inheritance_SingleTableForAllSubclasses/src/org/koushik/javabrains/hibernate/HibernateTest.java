package org.koushik.javabrains.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.koushik.javabrains.dto.FourWheeler;
import org.koushik.javabrains.dto.TwoWheeler;
import org.koushik.javabrains.dto.UserDetails;
import org.koushik.javabrains.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");
		
		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("Bike");
		bike.setSteeringHandle("Bike Steering Handle");
		
		FourWheeler car = new FourWheeler();
		car.setVehicleName("Porsche");
		car.setSteeringWheel("Porsche Steering Wheel");
		
		
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		
		session.beginTransaction(); 		
		session.save(vehicle);
		session.save(bike);
		session.save(car);
		session.getTransaction().commit();
		
		session.close(); //this should normally inside the finally{} block
		
		
	}

}
