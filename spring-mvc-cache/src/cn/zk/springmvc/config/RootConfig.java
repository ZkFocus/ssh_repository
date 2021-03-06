package cn.zk.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("cn.zk.springmvc")
@Import({DataConfig.class, CachingConfig.class})
public class RootConfig {

}
