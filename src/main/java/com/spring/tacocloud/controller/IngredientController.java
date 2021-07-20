package com.spring.tacocloud.controller;

import com.spring.tacocloud.bean.Ingredient;
import com.spring.tacocloud.service.IngredientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "/ingredientsx",
        produces = "application/json")
@CrossOrigin(origins = "*")
public class IngredientController {
    @Autowired
    IngredientService ingredientService;

    @GetMapping
    public Iterable<Ingredient> listIngredient() {
        return ingredientService.findAll();
    }

}
