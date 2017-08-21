package com.example;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
/**
 * 这是因为spring boot默认会加载org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration类，
 * DataSourceAutoConfiguration类使用了@Configuration注解向spring注入了dataSource bean。
 * 因为工程中没有关于dataSource相关的配置信息，当spring创建dataSource bean因缺少相关的信息就会报错。
 * 因为我仅仅只是使用spring boot来写一些很简单的例子来学习它，在Application类上增加 <em>@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})</em>
 * 阻止spring boot自动注入dataSource bean
 * 否则会报：Cannot determine embedded database driver class for database type NONE
 */
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.example.mapper")
public class SbootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbootDemoApplication.class, args);
    }

}
