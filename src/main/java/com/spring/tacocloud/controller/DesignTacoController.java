package com.spring.tacocloud.controller;

import com.spring.tacocloud.bean.Ingredient;
import com.spring.tacocloud.bean.Ingredient.Type;
import com.spring.tacocloud.bean.Taco;
import com.spring.tacocloud.service.IngredientService;
import com.spring.tacocloud.service.TacoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {
    @Autowired
    IngredientService ingredientService;

    @Autowired
    TacoService tacoService;

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = ingredientService.findAll();
        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }

    //tag::showDesignForm[]
    @GetMapping
    public String showDesignForm(Model model) {
        model.addAttribute("design", new Taco());
        return "design";
    }

    @PostMapping()
    public String processDesign(@Valid @ModelAttribute("design") Taco design, Errors errors) {
        if (errors.hasErrors()) {
            return "design";
        }
//        log.info("Processing design : " + design);
        log.info("Processing design : " + tacoService.save(design));
        return "redirect:/orders/current";
    }

    private List<Ingredient> filterByType (List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type)).collect(Collectors.toList());
    }
}
