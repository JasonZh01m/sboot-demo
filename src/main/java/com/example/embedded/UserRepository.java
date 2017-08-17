package com.example.embedded;

import com.example.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by JasonZh on 2017/8/16.
 */
public interface  UserRepository extends MongoRepository<User, Long> {

    User findByUsername(String username);
}
