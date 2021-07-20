package com.spring.tacocloud.service;

import com.spring.tacocloud.bean.Order;

public interface OrderService {
    Order saveOrder(Order order);
}
