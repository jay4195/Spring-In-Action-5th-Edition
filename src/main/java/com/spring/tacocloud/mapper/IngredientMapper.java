package com.spring.tacocloud.mapper;

import com.spring.tacocloud.bean.Ingredient;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IngredientMapper {
    public List<Ingredient> findAll();
    public Ingredient findById(String id);
}
