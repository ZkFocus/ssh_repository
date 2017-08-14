package cn.zk.springmvc.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@Configuration
public class DataSourceConfig {

	@Bean
	public DataSource getDataSource(){
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		//加载mysql驱动
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		//省略的URL形式 jdbc:mysql:///sampledb
		dataSource.setUrl("jdbc:mysql://localhost:3306/sampledb");
		//设置用户名密码
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
	//配置jdbc 模板
	@Bean
	public JdbcOperations jdbcOperations(){
		return new JdbcTemplate(getDataSource());
	}
	
	@Bean
	public DataSourceInitializer dbDataSourceInitializer
			(DataSource dataSource){
		//数据库初始化类
		DataSourceInitializer initializer
			=new DataSourceInitializer();
		//从类路径下加载初始化脚本
		ResourceDatabasePopulator populator 
			=new ResourceDatabasePopulator(
		//ClassPathResource 加载类路径下的资源脚本
						new ClassPathResource("initDB.sql"));
		initializer.setDataSource(dataSource);
		initializer.setDatabasePopulator(populator);
		initializer.setEnabled(false);
		return initializer;
		
	}
	
	
}
