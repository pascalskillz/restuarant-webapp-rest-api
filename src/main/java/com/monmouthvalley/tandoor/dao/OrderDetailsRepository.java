package com.monmouthvalley.tandoor.dao;

import com.monmouthvalley.tandoor.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {
}
