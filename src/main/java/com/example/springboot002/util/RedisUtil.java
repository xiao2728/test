package com.example.springboot002.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author Leon
 * @Description: TODO
 * @date 2021/7/2015:35
 */
@Component
public class RedisUtil {

    @Autowired(required = false)
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 保持指定key-value信息
     *
     * @param key
     * @param value
     */
    public void putValue(String key, String value) {
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.set(key, value);
        System.out.println("Redis存储：key-" + key + ": value-" + value);
    }

    /**
     * 保存key-Object信息
     *
     * @param key
     * @param object
     * stringRedisTemplate.opsForValue()操作redis值的对象
     */
    public void putValue(String key, Object object) {
        stringRedisTemplate.opsForValue().set(key, JSONObject.toJSONString(object));
        System.out.println("Redis存储：key-" + key + ": object-" + object.toString());
    }

    /**
     * 保存Key-value信息，并制定time为失效时间
     *
     * @param key
     * @param value
     * @param time  单位为秒
     */
    public void putValue(String key, String value, long time,TimeUnit timeUnit) {
        stringRedisTemplate.opsForValue().set(key, value, time, timeUnit);
        System.out.println("Redis存储：key-" + key + ": value-" + value + " ：失效时间为-" + time);
    }

    /**
     * 获取指定key的值
     *
     * @param key
     */
    public String getValue(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * 删除指定key对应的信息
     *
     * @param key
     */
    public void deleteValue(String key) {
        stringRedisTemplate.delete(key);
    }

    /**
     * 获取指定key的信息，并转化为指定对象
     *
     * @param key
     * @return
     */
    public <T> T getValue(String key, Class<T> value) {
        return JSONObject.parseObject(stringRedisTemplate.opsForValue().get("user"), value);
    }

    /**
     * 更新指定key的失效时间，单位设置为秒
     *
     * @param key
     * @param time
     */
    public void updateExpireTime(String key, long time) {
        stringRedisTemplate.expire("name", time, TimeUnit.SECONDS);
    }
}
