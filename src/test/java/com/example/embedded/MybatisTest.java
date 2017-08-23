package com.example.embedded;

import com.example.mapper.UserMapper;
import com.example.model.User;
import com.example.web.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by JasonZh on 2017/8/18.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTest {

    private final static Logger logger = LoggerFactory.getLogger(MybatisTest.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private CacheManager cacheManager;

    @Before
    public void before() {
        userMapper.insert("AAA", 10);
    }

    @Test
    @Rollback
    public void findByName() throws Exception {
        userMapper.insert("AAA", 20);
        User u = userMapper.findByName("AAA");

        logger.info("{}", u);

        Assert.assertEquals(20, u.getAge().intValue());
    }


    @Test
    public void testCache() throws Exception {
        logger.debug("{}", cacheManager);

        User u1 = userService.findByName("AAA");
        System.out.println("第一次查询：" + u1.getAge());

        User u2 = userService.findByName("AAA");
        System.out.println("第二次查询：" + u2.getAge());

        u1.setAge(30);
        userService.update(u1);
        User u3 = userService.findByName("AAA");
        System.out.println("第三次查询：" + u3.getAge());

    }

}
