package com.monmouthvalley.tandoor.dao;

import com.monmouthvalley.tandoor.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
