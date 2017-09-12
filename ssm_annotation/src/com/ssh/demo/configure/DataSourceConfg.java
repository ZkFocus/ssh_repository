package com.ssh.demo.configure;

import java.beans.PropertyVetoException;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@MapperScan(basePackages = { "com.ssh.demo.dao" })
public class DataSourceConfg {

	@Bean
	public ComboPooledDataSource dataSourcePool() throws PropertyVetoException {
		ComboPooledDataSource pooledDataSource = new ComboPooledDataSource();
		pooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
		pooledDataSource.setJdbcUrl("jdbc:mysql:///mybatis");
		pooledDataSource.setUser("root");
		pooledDataSource.setPassword("root");
		return pooledDataSource;
	}

	@Bean
	public SqlSessionFactory getSqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSourcePool());
		Resource[] mapperLocations = new Resource[] { new ClassPathResource("mybatis/mapper/UserMapper.xml") };
		sqlSessionFactoryBean.setMapperLocations(mapperLocations);
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
		sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);// ø™∆ÙÕ’∑Â”≥…‰
		return sqlSessionFactory;
	}

	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager() throws PropertyVetoException {
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
		dataSourceTransactionManager.setDataSource(this.dataSourcePool());
		return dataSourceTransactionManager;
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate() throws Exception {
		return new SqlSessionTemplate(this.getSqlSessionFactory());
	}

}
