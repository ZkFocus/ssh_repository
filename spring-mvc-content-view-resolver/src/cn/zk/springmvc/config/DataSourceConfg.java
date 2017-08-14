package cn.zk.springmvc.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataSourceConfg {

	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///sampledb");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
	@Bean
	public JdbcOperations jdbcOperations(){
		return new JdbcTemplate(dataSource());
	}
	
}
