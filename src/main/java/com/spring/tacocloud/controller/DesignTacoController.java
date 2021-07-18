package com.spring.tacocloud.controller;

import com.spring.tacocloud.bean.Ingredient;
import com.spring.tacocloud.bean.Ingredient.Type;
import com.spring.tacocloud.bean.Order;
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
@SessionAttributes("order")
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

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    //tag::showDesignForm[]
    @GetMapping
    public String showDesignForm(Model model) {
        model.addAttribute("design", new Taco());
        return "design";
    }

    @PostMapping()
    public String processDesign(@Valid @ModelAttribute("design") Taco design, Errors errors, @ModelAttribute Order order) {
        if (errors.hasErrors()) {
            return "design";
        }
        Taco tacoSaved = tacoService.save(design);
        order.addDesign(tacoSaved);
        log.info("Processing design : " + tacoService.save(design));
        return "redirect:/orders/current";
    }

    private List<Ingredient> filterByType (List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type)).collect(Collectors.toList());
    }
}
