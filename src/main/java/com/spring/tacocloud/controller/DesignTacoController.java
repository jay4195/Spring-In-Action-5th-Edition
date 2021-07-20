package com.spring.tacocloud.controller;

import com.spring.tacocloud.bean.Ingredient;
import com.spring.tacocloud.bean.Ingredient.Type;
import com.spring.tacocloud.bean.Order;
import com.spring.tacocloud.bean.Taco;
import com.spring.tacocloud.mapper.IngredientMapper;
import com.spring.tacocloud.mapper.TacoIngredientMapper;
import com.spring.tacocloud.mapper.TacoMapper;
import com.spring.tacocloud.service.TacoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping(path = "/design",
                produces = "application/json")
@CrossOrigin(origins = "*")
public class DesignTacoController {
    @Autowired
    TacoService tacoService;

    @GetMapping("/recent")
    public Iterable<Taco> recentTacos() {
        return tacoService.selectTopTacos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Taco processTaco(@RequestBody Taco taco) {
        return tacoService.saveTaco(taco);
    }
}
