package com.example.embedded;

import com.example.mapper.UserMapper;
import com.example.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by JasonZh on 2017/8/18.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MybatisTest {

    private final static Logger logger = LoggerFactory.getLogger(MybatisTest.class);

    @Autowired
    private UserMapper userMapper;

    @Test
    @Rollback
    public void findByName() throws Exception {
        userMapper.insert("AAA", 20);
        User u = userMapper.findByName("AAA");

        logger.info("{}", u);

        Assert.assertEquals(20, u.getAge().intValue());
    }

}
