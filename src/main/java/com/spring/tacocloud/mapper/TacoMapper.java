package com.spring.tacocloud.mapper;

import com.spring.tacocloud.bean.Taco;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TacoMapper {
    public void insert(Taco taco);
}
