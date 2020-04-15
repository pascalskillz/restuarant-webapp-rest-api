package com.monmouthvalley.tandoor.service;

import com.monmouthvalley.tandoor.dao.OrderRepository;
import com.monmouthvalley.tandoor.entity.Order;
import com.monmouthvalley.tandoor.exception.GenericNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

   private OrderRepository orderRepository;


    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository){

        this.orderRepository = orderRepository;
    }

    @Override
    public Page<Order> findAll(int page, int limit) {

        Pageable pageableRequest = PageRequest.of(page, limit, Sort.by("orderDate").descending());

        //Slice<Order> paging = orderRepository.findAll(pageableRequest);

        Page<Order> paging = orderRepository.findAll(pageableRequest);

//        if(!paging.hasContent()){
//            return new ArrayList<>();
//        }
        return paging;
    }

    /*@Override
    public Optional<Order> findById(int id) {

        return orderRepository.findById(id);
    }*/

    @Override
    public Order findById(int id) {

        Optional<Order> result = orderRepository.findById(id);

        Order order;

        if(result.isPresent()){
            order = result.get();
        }
        else {
            //order number  not found
            throw new GenericNotFoundException("No order with id " + id);
        }
        return order;
    }


   /* @Override
    public Order findOrderByOrderNumber(String orderNumber){
        //Optional<Order> result = orderRepository.findOrderByOrderNumber(orderNumber);
        //Order order = orderRepository.findOrderByOrderNumber(orderNumber);

        //Order order;

        return orderRepository.findOrderByOrderNumber(orderNumber);
    }*/

    @Override
    public void save(Order order) {
        orderRepository.save(order);

    }

    @Override
    public void deleteById(int id) {

        orderRepository.deleteById(id);
    }
}
