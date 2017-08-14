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
		//1 ����mysql������
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		//2 �������ݿ��ַ
		dataSource.setUrl("jdbc:mysql://localhost:3306/sampledb");
		//3 �����û�������
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
	/**
	 * ����JDBCģ��
	 * @return
	 */
	@Bean
	public JdbcOperations jdbcOperations(){
		return new JdbcTemplate(getDataSource());
	}
}
