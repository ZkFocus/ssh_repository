package com.ssh.demo.configure;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.ssh.demo", 
	excludeFilters = {
		@Filter(type = FilterType.ANNOTATION, 
					value = org.springframework.stereotype.Controller.class) 
					}
				)
@Import(DataSourceConfg.class)
public class RootConfig {

}
