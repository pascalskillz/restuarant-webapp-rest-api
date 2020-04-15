package com.monmouthvalley.tandoor.rest;

import com.monmouthvalley.tandoor.entity.Order;
import com.monmouthvalley.tandoor.entity.OrderDetails;
import com.monmouthvalley.tandoor.exception.GenericNotFoundException;
import com.monmouthvalley.tandoor.service.OrderService;
import com.monmouthvalley.tandoor.shared.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:3000", "https://tandoor.netlify.com", "http://tandoor.s3-website-us-east-1.amazonaws.com"})
public class OrderRestController {

    private OrderService orderService;
    private Utils utils;

    @Autowired
    public OrderRestController(OrderService orderService, Utils utils){
        this.orderService = orderService;
        this.utils = utils;
    }

    @GetMapping("/orders")
    public Page<Order> findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10")  int limit){
        if(page > 0) page -= 1; //make page index to start from 1;

        return  orderService.findAll(page, limit);
    }

    @GetMapping("/orders/{orderId}")
    public Order getOrder(@PathVariable int orderId) {

        Order order = orderService.findById(orderId);

        if (order == null) {
            throw new GenericNotFoundException("Item with the id " + orderId + " not found");
        }
        return order;
    }

    @PostMapping("/orders")
    public Order createOrder(@RequestBody Order order){

        if(order == null){
            throw new RuntimeException("invalid order data provided");
        }

        validateOrder(order);

        order.setId(0);

        order.setOrderDate(new Date());

        orderService.save(order);

        //call the websockets here.
        return order;
    }


    @PutMapping("/orders")
    public Order updateOrder(@RequestBody Order order){

        if(order == null){
            throw new RuntimeException("invalid order data provided");
        }

        validateOrder(order);

        order.setOrderDate(new Date());

        orderService.save(order);

        return order;

    }


    @DeleteMapping("/orders/{orderId}")
    public String deleteOrder(@PathVariable int orderId){

        Order order = orderService.findById(orderId);

        if (order == null) {
            throw new GenericNotFoundException("Order with the id " + orderId + " not found");
        }

        orderService.deleteById(orderId);

        return "Deleted Order with id " + orderId;
    }



    private void validateOrder(Order order) {

        List<OrderDetails> orderDetails = order.getOrderDetails();

        for(OrderDetails details : orderDetails){

            utils.validateMenuItem(details.getMenuItemId());

            details.setOrder(order);
        }

        order.setOrderDetails(orderDetails);
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
