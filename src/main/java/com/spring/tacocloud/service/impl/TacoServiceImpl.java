package com.spring.tacocloud.service.impl;

import com.spring.tacocloud.bean.Ingredient;
import com.spring.tacocloud.bean.Taco;
import com.spring.tacocloud.mapper.TacoIngredientMapper;
import com.spring.tacocloud.mapper.TacoMapper;
import com.spring.tacocloud.mapper.TacoOrderTacosMapper;
import com.spring.tacocloud.service.TacoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class TacoServiceImpl implements TacoService {
    @Autowired
    TacoMapper tacoMapper;

    @Autowired
    TacoIngredientMapper tacoIngredientMapper;

    @Override
    public List<Taco> selectTopTacos() {
        List<Taco> allTaco = tacoMapper.selectTopTacos();
        for (Taco taco : allTaco) {
            taco.setIngredients(tacoIngredientMapper.findIngredientByTacoId(taco.getId()));
        }
        return allTaco;
    }

    @Override
    public Taco saveTaco(Taco taco) {
        taco.setCreatedAt(new Date());
        tacoMapper.saveTaco(taco);
        for (Ingredient ingredient : taco.getIngredients()) {
            tacoIngredientMapper.insert(taco.getId(), ingredient.getId());
        }
        log.info("New Taco Created!" + taco.toString());
        return taco;
    }
}
