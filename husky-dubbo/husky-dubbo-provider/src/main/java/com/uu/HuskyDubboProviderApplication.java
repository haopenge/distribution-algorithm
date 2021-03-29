package com.uu;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Collections;

@SpringBootApplication
@DubboComponentScan(basePackages = "com.uu.service")
public class HuskyDubboProviderApplication {

	private static final String RES_KEY = "com.uu.service.IUserService:getUserInfo(java.lang.Integer)";
	private static final String INTERFACE_RES_KEY = "com.uu.service.IUserService";


	public static void main(String[] args) {
		// Users don't need to manually call this method.

	//	InitExecutor.doInit();

		initFlowRule();
		ConfigurableApplicationContext context = SpringApplication.run(HuskyDubboProviderApplication.class, args);

		System.out.println("Service provider is ready");
	}

	private static void initFlowRule() {
		FlowRule flowRule = new FlowRule();
		flowRule.setResource(RES_KEY);
		flowRule.setCount(1);
		flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
		flowRule.setLimitApp("dubbo-test-consumer-1");
		FlowRuleManager.loadRules(Collections.singletonList(flowRule));
	}



}
