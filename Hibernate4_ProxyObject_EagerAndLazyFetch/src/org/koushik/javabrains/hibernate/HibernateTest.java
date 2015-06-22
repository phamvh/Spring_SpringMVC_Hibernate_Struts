package org.koushik.javabrains.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.koushik.javabrains.dto.Address;
import org.koushik.javabrains.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		user.setUserName("First User");
		Address addr = new Address();
		addr.setStreet("Orange grove");
		addr.setCity("Los Angeles");
		addr.setState("California");
		addr.setZipcode("90012");
		
		Address officeAddr = new Address();
		officeAddr.setStreet("Orange grove Office");
		officeAddr.setCity("Los Angeles Office");
		officeAddr.setState("California");
		officeAddr.setZipcode("90012");
		
		user.getListOfAddresses().add(addr);
		user.getListOfAddresses().add(officeAddr);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction(); 
		
		session.save(user);
		session.getTransaction().commit();
		
		session.close(); //this should normally inside the finally{} block

		
		//////////////
		user= null;
		session = sessionFactory.openSession();
		user = (UserDetails) session.get(UserDetails.class, 1);
		/**
		 * Since lazy initialization is by default, this session.close() will close before hibernate tries to retrieve the address 
		 * in the command user.getListOfAddresses(), which is after session.close() and this will cause an exception
		 */
		//session.close();
		
		
		
		System.out.println(user.getListOfAddresses().size());
		
		
		
	}

}
