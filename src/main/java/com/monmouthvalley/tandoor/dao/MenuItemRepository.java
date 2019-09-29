package com.monmouthvalley.tandoor.dao;

import com.monmouthvalley.tandoor.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {
}
