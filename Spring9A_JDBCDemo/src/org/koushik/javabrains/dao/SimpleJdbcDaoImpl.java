package org.koushik.javabrains.dao;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

/**
 * Note that there are other support classes for each JdbcTemplate and NamedParameterJdbcTemplate
 * They are JdbcTemplateSupport and NamedParameterJdbcTemplateSupport, respectively.
 * @author huypham
 *
 */

public class SimpleJdbcDaoImpl extends SimpleJdbcDaoSupport{

	public int getCircleCount(){
		String sql = "select count(*) from circle";
		
		//The JdbcTemplate of this SimpleJdbcTemplate is initialized in spring.xml
		return this.getJdbcTemplate().queryForInt(sql);
	}
}
