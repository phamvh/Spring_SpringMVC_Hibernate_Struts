package org.koushik.javabrains.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.koushik.javabrains.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;

//this is to mark this as a spring bean
//Note that we already specify 
//The default name for this bean is derived from the name of the class, which is "jdbcDaoImpl" - the first letter is not capitalized.
//One can explicitly specify the name of the bean by writing @Component("MyOwnNameForThisBean")
@Component
public class JdbcDaoImpl {
	
	private DataSource dataSource;
	
	//it needs an instance. We will change this later.
	//We will see later, where is the best place to initialize it.
	private JdbcTemplate jdbcTemplate;// = new JdbcTemplate(); 
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	// this provides common methods in both JdbcTemplate and NamedParameterJdbcTemplate
	//Even though it does not all the methods of those two classes, it has sufficient methods for common use.
	private SimpleJdbcTemplate simpleJdbcTemplate; 
	
	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		System.out.println("setDataSource is called.");
		this.dataSource = dataSource; //this is redundant now; just have to keep it to make the method getCircle(int circleId) work.
		jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	
	/**
	 * Old and odd way of querying datbase
	 * @param circleId
	 * @return
	 */
	/*
	public Circle getCircle(int circleId){
		Connection conn = null;
		
		try{
			//// old and odd way of getting a connection
			////String driver = "org.apache.derby.jdbc.ClientDriver";			
			////Class.forName(driver).newInstance();
			////conn = DriverManager.getConnection("jdbc:derby://localhost:1527/db");
			
			
			
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from circle where id = ?");
			ps.setInt(1, circleId);
			
			Circle circle = null;
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				circle = new Circle(circleId, rs.getString("name"));
			}
			rs.close();
			ps.close();
			return circle;
			
		}catch(Exception e){
			throw new RuntimeException(e);
			
		}
		finally{
			//it is a good practice to put conn.close() here
			//because it guarantees that the connection is closed even 
			//in case there is an error.
			try{
			conn.close();
			}catch(SQLException e){
				//there is nothing you can do about this exception here :)
			}
		}
	}
	*/
	public int getCircleCount(){
		System.out.println("dataSource is null? "+(dataSource == null));
		String sql = "select count(*) from circle";
		return jdbcTemplate.queryForInt(sql);
	}
	
	public String getCircleName(int circleId){
		String sql = "select name from circle where id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[]{circleId} ,String.class);
		
	}
	
	/**
	 * return the whole Circle object
	 * @param circleId
	 * @return
	 */
	
	public Circle getCircleForId(int circleId){
		String sql = "select * from circle where id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[]{circleId}, new CircleMapper());
	}
	
	/**
	 * return all rows stored in a list.
	 * @return
	 */
	public List<Circle> getAllCircles(){
		String sql = "select * from circle";
		return jdbcTemplate.query(sql, new CircleMapper());
	}
	private static final class CircleMapper implements RowMapper<Circle>{
		/**
		 * This method is called for EVERY ROW in the result set. 
		 * It is NOT called ONCE for the entire result set.
		 * Thats why there is a rowNumber, which one can use to personalize the returned result.
		 * Most of the time, rows have the same priority, so rowNumber is not used.
		 */

		@Override
		public Circle mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
			//we are not using the row number here.
			Circle circle = new Circle();
			circle.setId(resultSet.getInt("id"));
			circle.setName(resultSet.getString("name"));
			return circle;
		}
		
	}
	
	//DML - Data manipulation language
	public void insertCircle(Circle circle){
		String sql = "insert into circle (id, name) values (?,?)";
		jdbcTemplate.update(sql, new Object[]{circle.getId(), circle.getName()});
	}
	

	//DML - Data manipulation language
	public void insertCircleUsingNamedParameter(Circle circle){
		String sql = "insert into circle (id, name) values (:id,:name)";
		SqlParameterSource namedParameters = 
				new MapSqlParameterSource("id", circle.getId()).
				                 addValue("name", circle.getName());
		namedParameterJdbcTemplate.update(sql, namedParameters);
		
	
	}
	
	//execution - creating a table. This is NOT DML
	public void createTriangleTable(){
		String sql = "create table triangle (id integer, name varchar(50))";
		jdbcTemplate.execute(sql);
		
	}
	

	//never called so far
	public JdbcTemplate getJdbcTemplate() {
		System.out.println("getJdbcTemplate() called");
		return jdbcTemplate;
	}

	//never called so far
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		System.out.println("setJdbcTemplate(JdbcTemplate jdbcTemplate) called");
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
