package com.uu.distribution.分布式锁;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：
 * User Liu PengHao
 * Date 2019/01/30 11:49
 **/
@RestController
@RequestMapping("/redis")
@Slf4j
public class RedisController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 可约数量
     */
    private static final int suscribeCount = 3;

    @PostMapping(value = "/subscribe")
    public Map<String, Object> subscribe(Subscribe subscribe) {
        String schoolId = subscribe.getSchoolId();
        String coachId = subscribe.getCoachId();
        String subjectId = subscribe.getSubjectId();
        String start = subscribe.getStart();
        String end = subscribe.getEnd();
        // 参数判空忽略 -- 开发中自行加上

        String key = schoolId + "_" + coachId + "_" + subjectId + "_" + start + "_" + end;
        RedisDistributeLock<String> redisLock = new RedisDistributeLock<>(redisTemplate, key);

        try {
            boolean lock = redisLock.lock();
            if (lock) {
                return handleData(subscribe);

            }
            return handleResult("1", "系统繁忙");

        } catch (InterruptedException e) {
            return handleResult("1", "获取redis锁异常");
        } finally {
            redisLock.unlock();
        }
    }

    /**
     * 具体业务 处理,根据需要自行更改
     *
     * @param subscribe subscribe
     * @return 相应体
     * @throws InterruptedException InterruptedException
     */
    private Map<String, Object> handleData(Subscribe subscribe) throws InterruptedException {
        log.error("----> 正在处理 <-----");
        // 业务处理,假设需要1秒
        Thread.sleep(200);

        long count = mongoTemplate.count(new Query(), Subscribe.class);
        if (count == suscribeCount) {
            return handleResult("1", "该时段已约满");
        } else {
            mongoTemplate.insert(subscribe);
            return handleResult("0", "成功");
        }
    }

    @PostMapping(value = "/subscribe/nolock")
    public Map<String, Object> subscribeNoLock(Subscribe subscribe) throws InterruptedException {
        return handleData(subscribe);
    }

    /**
     * 封装返回数据
     *
     * @param code 响应码
     * @param data 数据
     * @return map
     */
    public Map<String, Object> handleResult(String code, Object data) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("errorcode", code);
        map.put("data", data);
        return map;
    }
}
