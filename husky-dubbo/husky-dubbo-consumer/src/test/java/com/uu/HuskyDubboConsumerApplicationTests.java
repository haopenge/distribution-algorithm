package com.uu;

import com.uu.service.IUserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HuskyDubboConsumerApplicationTests {
	
	@DubboReference
	private IUserService userService;

	@Test
	void contextLoads() {
		String login = userService.login("xiaoyuxixi", "pwd");
		System.out.println(login);
	}

}
