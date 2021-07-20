package com.spring.tacocloud.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TacoOrderTacosMapper {
    public void saveTacoOrder(Long tacoOrderId, Long tacoId);
}
