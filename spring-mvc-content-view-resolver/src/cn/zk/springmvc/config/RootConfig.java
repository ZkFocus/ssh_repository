package cn.zk.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages="cn.zk.springmvc")
@Import(DataSourceConfg.class)
public class RootConfig {

}
