package com.spring.tacocloud.service.impl;

import com.spring.tacocloud.bean.Order;
import com.spring.tacocloud.bean.Taco;
import com.spring.tacocloud.mapper.OrderMapper;
import com.spring.tacocloud.mapper.TacoOrderTacosMapper;
import com.spring.tacocloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Autowired
    TacoOrderTacosMapper tacoOrderTacosMapper;

    @Override
    public Order saveOrder(Order order) {
        order.setPlacedAt(new Date());
        orderMapper.saveOrder(order);
        for(Taco taco : order.getTacos()) {
            tacoOrderTacosMapper.saveTacoOrder(order.getId(), taco.getId());
        }
        return order;
    }
}
