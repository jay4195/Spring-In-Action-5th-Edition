package com.spring.tacocloud.service.impl;

import com.spring.tacocloud.bean.Ingredient;
import com.spring.tacocloud.bean.Taco;
import com.spring.tacocloud.mapper.TacoIngredientMapper;
import com.spring.tacocloud.mapper.TacoMapper;
import com.spring.tacocloud.service.TacoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class TacoServiceImpl implements TacoService {
    @Autowired
    TacoMapper tacoMapper;

    @Autowired
    TacoIngredientMapper tacoIngredientMapper;

    @Override
    public Taco save(Taco taco) {
        taco.setCreatedAt(new Date());
        tacoMapper.insert(taco);
        for (Ingredient ingredient : taco.getIngredients()) {
            System.out.println(ingredient);
        }
        return taco;
    }
}
