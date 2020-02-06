package com.monmouthvalley.tandoor.rest;

import com.monmouthvalley.tandoor.entity.Order;
import com.monmouthvalley.tandoor.entity.OrderDetails;
import com.monmouthvalley.tandoor.exception.GenericNotFoundException;
import com.monmouthvalley.tandoor.service.OrderService;
import com.monmouthvalley.tandoor.shared.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderRestController {

    private OrderService orderService;
    private Utils utils;

    @Autowired
    public OrderRestController(OrderService orderService, Utils utils){
        this.orderService = orderService;
        this.utils = utils;
    }

    @GetMapping("/orders")
    public List<Order> findAll(){
        return  orderService.findAll();
    }

    @GetMapping("/order/{orderId}")
    public Order getItem(@PathVariable int orderId) {

        Order order = orderService.findById(orderId);

        if (order == null) {
            throw new GenericNotFoundException("Item with the id " + orderId + " not found");
        }
        return order;
    }

    @PostMapping("/orders")
    public Order addOrder(@RequestBody Order order){

        if(order == null){
            throw new RuntimeException("invalid order data provided");
        }

        order.setId(0);

        List<OrderDetails> orderDetails = order.getOrderDetails();

        for(OrderDetails details : orderDetails){

            details.setOrder(order);

            utils.validateMenuItem(details.getMenuItemId());
        }


        order.setOrderDate(new Date());

        orderService.save(order);

        return order;
    }

    /*@GetMapping("/orders/{orderNumber}")
    public Order getOrder(@PathVariable String orderNumber){

        Order order  = orderService.findOrderByOrderNumber(orderNumber);

        if(order == null){
            throw new GenericNotFoundException("order with the id " + orderNumber + " not found");
        }
        return order;
    }*/
}
