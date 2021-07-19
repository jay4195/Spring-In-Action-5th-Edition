package com.spring.tacocloud.mapper;

import com.spring.tacocloud.bean.Taco;
import com.spring.tacocloud.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public User findByUsername(String username);
    public void save(User user);
}
