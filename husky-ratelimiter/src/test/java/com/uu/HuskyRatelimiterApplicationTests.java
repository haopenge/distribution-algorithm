package com.uu;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class HuskyRatelimiterApplicationTests {

	@Autowired
	private RedisTemplate redisTemplate;

	private DefaultRedisScript<Long> getRedisScript;

	@Before("")
	public void init() {
		getRedisScript = new DefaultRedisScript<>();
		getRedisScript.setResultType(Long.class);
		getRedisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("META-INF/rateLimiter.lua")));
	}

	@Test
	void contextLoads() {
		List<String> keyList = new ArrayList<>();
		keyList.add("test");
		long expireTime = 1;
		long limitTimes = 2;

		redisTemplate.execute(getRedisScript, keyList, expireTime, limitTimes);
	}


}
