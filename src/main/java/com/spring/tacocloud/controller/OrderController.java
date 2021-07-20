package com.spring.tacocloud.controller;

import com.spring.tacocloud.bean.Order;
import com.spring.tacocloud.bean.Taco;
import com.spring.tacocloud.mapper.OrderMapper;
import com.spring.tacocloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Slf4j
@RestController
@RequestMapping(path = "/orders",
        produces = "application/json")
@CrossOrigin(origins = "*")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order processTaco(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }
}
