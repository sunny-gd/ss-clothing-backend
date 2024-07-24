package com.example.first.util;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class DbConnection {
	
	@Autowired
	private Environment env;
	
	public Connection connection = null;
	
	public Connection getConnection() {
		
		final String url = env.getProperty("spring.datasource.url");
		final String userid = env.getProperty("spring.datasource.username");
		final String password = env.getProperty("spring.datasource.password");
		
		try {
			connection = DriverManager.getConnection(url, userid, password);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return connection;
	}	
}
