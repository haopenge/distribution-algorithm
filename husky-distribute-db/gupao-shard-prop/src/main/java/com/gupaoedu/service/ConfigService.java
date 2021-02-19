package com.gupaoedu.service;

import com.gupaoedu.entity.Config;
import com.gupaoedu.mapper.ConfigMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;


@Service
public class ConfigService {
    @Resource
    ConfigMapper configMapper;

    public static Long configId = 1L;

    public void insert() {
        for (int i = 1; i <= 10; i++) {
            Config config = new Config();
            config.setConfigId(i);
            config.setParaName("name"+i);
            config.setParaValue("value"+i);
            config.setParaDesc("desc"+i);
            configId++;
            configMapper.insert(config);
        }
    }

    public void update(Integer configId) {
        Config config = configMapper.selectByPrimaryKey(configId);
        config.setParaDesc("after modified. 0711");
        configMapper.updateByPrimaryKey(config);
    }

    public Config geConfigById(Integer id){
        return configMapper.selectByPrimaryKey(id);
    }

}
