package com.uu.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * redis 操作实现  自定义【根据项目已有的 redis 配置生成此类】
 * @author liuph
 * @date 2021/05/30 21:40
 */
@Service
public class AbstractRedisServiceImpl implements AbstractRedisService{

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public String getHVal(String key, String innerKey) {
        if(key == null || key.trim().equals("") || innerKey == null || innerKey.trim().equals("")){
           return null;
        }
        Object obj = redisTemplate.opsForHash().get(key, innerKey);
        return Objects.isNull(obj)? null : obj.toString();
    }

    @Override
    public List execLua(String luaStr, List<String> keys, Object... luaArgs) {
        DefaultRedisScript<List> script = new DefaultRedisScript<>();
        script.setResultType(List.class);
        script.setScriptText(luaStr);
        return redisTemplate.execute(script, keys, luaArgs);
    }

    @Override
    public String getVal(String key) {
        if(key == null || key.trim().equals("")){
            return null;
        }
        Object val = redisTemplate.opsForValue().get(key);
        return Objects.isNull(val) ? null : val.toString();
    }

    @Override
    public void setVal(String key, String value,long expire) {
        if(key == null || key.trim().equals("")){
            return ;
        }
        redisTemplate.opsForValue().set(key,value,expire, TimeUnit.SECONDS);
    }
}
