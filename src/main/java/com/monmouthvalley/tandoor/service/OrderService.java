package com.monmouthvalley.tandoor.service;

import com.monmouthvalley.tandoor.entity.Order;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    //List<Order> findAll(int page, int limit);

    Page<Order> findAll(int page, int limit);

    Order findById(int id);

   /* Order findOrderByOrderNumber(String orderNumber);*/

    void save(Order order);

    void deleteById(int id);
}
