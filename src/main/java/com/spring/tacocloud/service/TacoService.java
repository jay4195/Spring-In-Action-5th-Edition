package com.spring.tacocloud.service;

import com.spring.tacocloud.bean.Ingredient;
import com.spring.tacocloud.bean.Taco;

import java.util.List;

public interface TacoService {
    List<Taco> selectTopTacos();
    Taco saveTaco(Taco taco);
}
