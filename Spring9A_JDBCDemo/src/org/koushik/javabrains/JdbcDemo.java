package org.koushik.javabrains;

import org.koushik.javabrains.dao.JdbcDaoImpl;
import org.koushik.javabrains.dao.SimpleJdbcDaoImpl;
import org.koushik.javabrains.model.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcDemo {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		//now use getBean to get the DAO
		JdbcDaoImpl dao = ctx.getBean("jdbcDaoImpl", JdbcDaoImpl.class);
		
		//dao.insertCircle(new Circle(3,"Third Circle"));
		//dao.insertCircleUsingNamedParameter(new Circle(5, "Fifth Circle"));
		
		System.out.println(dao.getCircleCount()+" -- using JdbcTemplate - simple query");
		System.out.println(dao.getCircleName(1)+" -- using JdbcTemplate - more complex query");
		System.out.println(dao.getCircleForId(1).getName()+" -- using JdbcTemplate with RowMapper");
		System.out.println(dao.getAllCircles().size()+" -- return a list");
		
		SimpleJdbcDaoImpl simpleDao = ctx.getBean("simpleJdbcDaoImpl", SimpleJdbcDaoImpl.class) ;
		System.out.println(simpleDao.getCircleCount() +" -- using the DAO support class for SimpleJdbcDaoSupport");
		
		//dao.createTriangleTable();
		
		
		
		//Circle circle = dao.getCircle(1);
		
		
		//Old way of getting object
		/* 
		Circle circle = new JdbcDaoImpl().getCircle(1);
		*/
		//System.out.println(circle.getName());
		
		
	}
}
