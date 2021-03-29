package com.uu.config;

import org.apache.dubbo.config.ApplicationConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @desc dubbo 配置
 * @author liuph
 * @date 2021/03/22 16:06
 */
@Configuration
public class DubboConfiguration {

    @Bean
    public ApplicationConfig applicationConfig(){
        ApplicationConfig config = new ApplicationConfig();
        config.setName("sentinel-provider");
        config.setOwner("Mic");
        return config;
    }
}
