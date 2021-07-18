package com.spring.tacocloud.mapper;

import com.spring.tacocloud.bean.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    public void save(Order order);
}
