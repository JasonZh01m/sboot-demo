package com.example.embedded;

import com.example.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by JasonZh on 2017/8/18.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void test() throws Exception {
        // 保存字符串
        stringRedisTemplate.opsForValue().set("hello redis", "Say hello to redis");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("hello redis"));
    }

    @Test
    public void test2() throws Exception {
        // 保存对象
        User user = new User("超人", 20);
        redisTemplate.opsForValue().set(user.getUsername(), user);
        user = new User("蝙蝠侠", 30);
        redisTemplate.opsForValue().set(user.getUsername(), user);
        user = new User("蜘蛛侠", 40);
        redisTemplate.opsForValue().set(user.getUsername(), user);
        Assert.assertEquals(20, ((User) redisTemplate.opsForValue().get("超人")).getAge().longValue());
        Assert.assertEquals(30, ((User) redisTemplate.opsForValue().get("蝙蝠侠")).getAge().longValue());
        Assert.assertEquals(40, ((User) redisTemplate.opsForValue().get("蜘蛛侠")).getAge().longValue());
    }

}
