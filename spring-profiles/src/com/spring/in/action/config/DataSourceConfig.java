package com.spring.in.action.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@ComponentScan(basePackages="com.spring.in.action")
@Configuration
public class DataSourceConfig {

	@Bean
	@Profile("dev")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///sampledb");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}

	@Bean
	@Profile("prod")
	public DataSource jndiDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///springmvc");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
	
	 @Bean
	  public JdbcOperations jdbcTemplate(DataSource dataSource) {
	    return new JdbcTemplate(dataSource);
	  }
}
