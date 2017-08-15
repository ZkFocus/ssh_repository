package com.spring.in.action.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.in.action.config.DataSourceConfig;
import com.spring.in.action.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=DataSourceConfig.class)
@ActiveProfiles("dev")
public class SpringProfileTest {

	
	@Autowired
	private UserRepository userRepository;
	
	
	@Test
	public void testUserRepository(){
		System.out.println(userRepository.get(1));
	}
	
}
