package com.spring.tacocloud.converter;

import com.spring.tacocloud.bean.Ingredient;
import com.spring.tacocloud.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * 表单中提交的是 List<String>要转换成 List<Ingredient>
 */
@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
    @Autowired
    private IngredientService ingredientService;

    @Override
    public Ingredient convert(String id) {
        return ingredientService.findById(id);
    }
}
