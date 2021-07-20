package com.spring.tacocloud.service;

import com.spring.tacocloud.bean.Ingredient;

import java.util.List;

public interface IngredientService {
    List<Ingredient> findAll();
}
