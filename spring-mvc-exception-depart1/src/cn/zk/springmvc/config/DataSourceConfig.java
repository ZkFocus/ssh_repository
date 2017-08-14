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
		//����mysql����
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		//ʡ�Ե�URL��ʽ jdbc:mysql:///sampledb
		dataSource.setUrl("jdbc:mysql://localhost:3306/sampledb");
		//�����û�������
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
	//����jdbc ģ��
	@Bean
	public JdbcOperations jdbcOperations(){
		return new JdbcTemplate(getDataSource());
	}
	
	@Bean
	public DataSourceInitializer dbDataSourceInitializer
			(DataSource dataSource){
		//���ݿ��ʼ����
		DataSourceInitializer initializer
			=new DataSourceInitializer();
		//����·���¼��س�ʼ���ű�
		ResourceDatabasePopulator populator 
			=new ResourceDatabasePopulator(
		//ClassPathResource ������·���µ���Դ�ű�
						new ClassPathResource("initDB.sql"));
		initializer.setDataSource(dataSource);
		initializer.setDatabasePopulator(populator);
		initializer.setEnabled(false);
		return initializer;
		
	}
	
	
}
