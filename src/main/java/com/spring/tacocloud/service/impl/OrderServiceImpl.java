package com.spring.tacocloud.service.impl;

import com.spring.tacocloud.bean.Order;
import com.spring.tacocloud.bean.Taco;
import com.spring.tacocloud.mapper.OrderMapper;
import com.spring.tacocloud.mapper.TacoOrderTacosMapper;
import com.spring.tacocloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    TacoOrderTacosMapper tacoOrderTacosMapper;

    @Override
    public void save(Order order) {
        order.placedAt();
        orderMapper.save(order);
        List<Taco> tacos = order.getTacos();
        for (Taco taco : tacos) {
            tacoOrderTacosMapper.saveTacoToOrder(order.getId(), taco.getId());
        }
    }
}
