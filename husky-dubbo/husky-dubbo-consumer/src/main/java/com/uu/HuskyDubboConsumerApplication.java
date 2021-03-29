package com.uu;

import com.alibaba.csp.sentinel.adapter.dubbo.DubboAdapterGlobalConfig;
import com.alibaba.csp.sentinel.adapter.dubbo.fallback.DefaultDubboFallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HuskyDubboConsumerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(HuskyDubboConsumerApplication.class, args);

		registerFallback();
	}

	private static void registerFallback() {
		DubboAdapterGlobalConfig.setConsumerFallback(new DefaultDubboFallback());
	}


}
