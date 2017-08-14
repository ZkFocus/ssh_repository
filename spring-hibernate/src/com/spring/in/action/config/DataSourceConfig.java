package com.spring.in.action.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.springframework.transaction.interceptor.TransactionInterceptor;

@Configuration
@ComponentScan(basePackages = "com.spring.in.action.*")
@EnableTransactionManagement
public class DataSourceConfig implements TransactionManagementConfigurer {


	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/sampledb");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}

	@Bean
	public SessionFactory sessionFactoryBean() {
		try {
			LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
			lsfb.setDataSource(dataSource());
			lsfb.setPackagesToScan("com.spring.in.action.entity");
			Properties props = new Properties();
			props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
			props.setProperty("hibernate.show_sql", "true");
			props.setProperty("hibernate.format_sql", "true");
			lsfb.setHibernateProperties(props);
			lsfb.afterPropertiesSet();
			SessionFactory object = lsfb.getObject();
			return object;
		} catch (IOException e) {
			return null;
		}
	}

	@Bean
	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactoryBean());
		return transactionManager;
	}

	@Bean
	public TransactionInterceptor transactionInterceptor() {
		Properties attributes = new Properties();
		attributes.setProperty("purchase", "PROPAGATION_REQUIRES_NEW");
		TransactionInterceptor txAdvice = new TransactionInterceptor(annotationDrivenTransactionManager(), attributes);
		return txAdvice;
	}

	@Bean
	public AspectJExpressionPointcut aspectJExpressionPointcut() {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		String transactionExecution = "execution(* com.spring.in.action.service.*.*(..))";
		pointcut.setExpression(transactionExecution);
		return pointcut;
	}

	@Bean
	public DefaultPointcutAdvisor defaultPointcutAdvisor() {
		DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
		advisor.setPointcut(aspectJExpressionPointcut());
		advisor.setAdvice(transactionInterceptor());
		return advisor;
	}

}
