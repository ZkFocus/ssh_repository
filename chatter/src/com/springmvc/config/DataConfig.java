package com.springmvc.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@Configuration
public class DataConfig {

  @Bean
  public DataSource dataSource() {
	  /*return new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.H2)
            .addScript("schema.sql")
            .build();*/
	  DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springmvc");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
  }
  
  @Bean
  public JdbcOperations jdbcTemplate(DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }
  
  //http://www.javarticles.com/2015/01/example-of-spring-datasourceinitializer.html
  
  @Bean
  public DataSourceInitializer dataSourceInitializer(DataSource dataSource){
	  
	  DataSourceInitializer daInitializer=new DataSourceInitializer();
	  ResourceDatabasePopulator rPopulator=new ResourceDatabasePopulator(new ClassPathResource("initmysql.sql"));
	  daInitializer.setDataSource(dataSource);
	  daInitializer.setDatabasePopulator(rPopulator);
	  daInitializer.setEnabled(true);
	  return daInitializer;
  }

}
