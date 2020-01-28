package com.monmouthvalley.tandoor.rest;

import com.monmouthvalley.tandoor.entity.Order;
import com.monmouthvalley.tandoor.exception.GenericNotFoundException;
import com.monmouthvalley.tandoor.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderRestController {

    private OrderService orderService;

    @Autowired
    public OrderRestController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public List<Order> findAll(){
        return  orderService.findAll();
    }

    @GetMapping("/orders/{orderNumber}")
    public Order getOrder(@PathVariable String orderNumber){

        Order order  = orderService.findOrderByOrderNumber(orderNumber);

        if(order == null){
            throw new GenericNotFoundException("order with the id " + orderNumber + " not found");
        }
        return order;
    }
}
