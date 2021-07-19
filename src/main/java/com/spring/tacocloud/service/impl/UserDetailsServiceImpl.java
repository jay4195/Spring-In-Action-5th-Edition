package com.spring.tacocloud.service.impl;

import com.spring.tacocloud.bean.User;
import com.spring.tacocloud.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.findByUsername(username);
        log.info("Find User '" + username + "'!");
        if (user != null) {
            log.info(String.format("User founded! Fullname: %s",user.getFullname()));
            return user;
        } else {
            throw new UsernameNotFoundException("User '" + username + "' not found!" );
        }
    }
}
