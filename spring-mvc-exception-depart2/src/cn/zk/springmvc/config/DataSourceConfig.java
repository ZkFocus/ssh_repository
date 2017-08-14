package cn.zk.springmvc.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataSourceConfig {

	@Bean
	public DataSource getDataSource(){
		DriverManagerDataSource dataSource
			=new DriverManagerDataSource();
		//1 加载mysql的驱动
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		//2 配置数据库地址
		dataSource.setUrl("jdbc:mysql://localhost:3306/sampledb");
		//3 配置用户名密码
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
	/**
	 * 配置JDBC模板
	 * @return
	 */
	@Bean
	public JdbcOperations jdbcOperations(){
		return new JdbcTemplate(getDataSource());
	}
}
