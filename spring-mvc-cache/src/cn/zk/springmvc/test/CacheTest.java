package cn.zk.springmvc.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.zk.springmvc.config.RootConfig;
import cn.zk.springmvc.entity.User;
import cn.zk.springmvc.repository.UserRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=RootConfig.class)
public class CacheTest {

	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void test(){
		//User user=userRepository.getUserByName("AA");
		
		System.out.println(userRepository.getUserByName("AA"));
		System.out.println(userRepository.getUserByName("AA"));
		System.out.println(userRepository.getUserByName("AA"));
		
	}
}
