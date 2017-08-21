package com.example.mapper;

import com.example.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by JasonZh on 2017/8/21.
 */
public interface UserMapper {

    @Select("SELECT * FROM USER WHERE NAME = #{name} order by id desc limit 1")
    User findByName(@Param("name") String name);

    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

    @Update("UPDATE user SET age=#{age} WHERE name=#{name}")
    void update(User user);

    @Delete("DELETE FROM user WHERE id =#{id}")
    void delete(Long id);

    /**
     * 而对于“查”操作，我们往往需要进行多表关联，汇总计算等操作，那么对于查询的结果
     * 往往就不再是简单的实体对象了，往往需要返回一个与数据库实体不同的包装类，
     * 那么对于这类情况，就可以通过<em>@Results</em>和<em>@Result</em>注解来进行绑定
     * @return
     */
    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })
    @Select("SELECT name, age FROM user")
    List<User> findAll();


}
