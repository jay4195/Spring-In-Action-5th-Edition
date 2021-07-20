package com.spring.tacocloud.service.impl;


import com.spring.tacocloud.bean.Ingredient;
import com.spring.tacocloud.mapper.IngredientMapper;
import com.spring.tacocloud.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {
    @Autowired
    IngredientMapper ingredientMapper;

    @Override
    public List<Ingredient> findAll() {
        return ingredientMapper.findAll();
    }
}
