package com.spring.tacocloud.mapper;

import com.spring.tacocloud.bean.Taco;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TacoMapper{
    List<Taco> selectTopTacos();
    void saveTaco(Taco taco);
}
