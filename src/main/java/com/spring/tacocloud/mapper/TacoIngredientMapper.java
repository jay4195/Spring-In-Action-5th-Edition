package com.spring.tacocloud.mapper;

import com.spring.tacocloud.bean.Ingredient;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TacoIngredientMapper {
    List<Ingredient> findIngredientByTacoId(Long id);
    void insert(Long tacoId, String ingredientId);
}
