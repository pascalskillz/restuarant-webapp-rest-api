package com.monmouthvalley.tandoor.dao;

import com.monmouthvalley.tandoor.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query("select order from Order order where order.orderNumber = ?1")
    Order findOrderByOrderNumber(String orderNumber);

}
