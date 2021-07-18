package com.spring.tacocloud.service;

import com.spring.tacocloud.bean.Ingredient;
import com.spring.tacocloud.mapper.IngredientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IngredientService {
    public List<Ingredient> findAll();
    public Ingredient findById(String id);
}
