package cn.zk.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DataSourceConfig.class)
@ComponentScan(basePackages="cn.zk.springmvc")
public class RootConfig {

}
