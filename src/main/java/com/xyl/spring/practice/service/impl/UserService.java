package com.xyl.spring.practice.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.xyl.spring.practice.entity.User;


@Repository
public class UserService {
	
	private JdbcTemplate jdbcTemplate;
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		DataSourceUtils.getConnection(dataSource);
	}
	
	/**
	 * 创建表
	 */
	public void createTable(){
		
		String sql = "create table user_info (id bigint, name varchar(255),primary key(id))";
		jdbcTemplate.execute(sql);
		
	}
	
	
	public int getUserCount(){
		String sql = "select count(*) from user_info";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	/**
	 *  增加用户并返回实际id
	 * @param userName
	 * @return
	 */
	public long insertUser(String userName){
		String addSql = "insert into user_info(name) values(:name)"; 
		User user = new User();
		user.setName(userName);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(user);
		this.namedParameterJdbcTemplate.update(addSql, sqlParameterSource, keyHolder);//使用该方式需要主要参数占位不用? 而用 :paramName
		return keyHolder.getKey().longValue();
	}
	
	/**
	 * 增加用户并返回实际id
	 * @param userName
	 * @return
	 */
	public long addUser(String userName){
		
		String addSql = "insert into user_info(name) values(?)"; 
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator(){

			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(addSql, new String[] {"name"});
				ps.setString(1, userName);
				return ps;
			}
			
		}, keyHolder);

		return keyHolder.getKey().longValue();
	}
	
	
	/**
	 * 查询所有用户信息
	 * @return
	 */
	public List<User> getAllUser(){
		
		String querySql = "select * from user_info ";
		return this.jdbcTemplate.query(querySql,new UserMapper());
		
	}
	
	@Transactional
	public void updateUserName(Long userId, String newName) throws Exception{
		
		String updateSql = "update user_info set name = ? where id = ?";
		
		this.jdbcTemplate.update(updateSql, new Object[]{newName, userId});
		
		throw new RuntimeException("测试事务运行时异常");
//		throw new Exception("测试事务运行时异常");
		
	}
	
	
	private static final class 	UserMapper implements RowMapper<User>{

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getLong("id"));
			user.setName(rs.getString("name"));
			return user;
		}
		
	}
	
}
