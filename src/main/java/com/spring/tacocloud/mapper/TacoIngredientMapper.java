package com.spring.tacocloud.mapper;

import com.spring.tacocloud.bean.Ingredient;
import com.spring.tacocloud.bean.Taco;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TacoIngredientMapper {
    public void insert(Long tacoId, String ingredientId);
}
