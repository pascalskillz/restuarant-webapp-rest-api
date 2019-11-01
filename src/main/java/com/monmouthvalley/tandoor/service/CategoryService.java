package com.monmouthvalley.tandoor.service;

import com.monmouthvalley.tandoor.entity.Category;

import java.util.List;

public interface CategoryService {

    public List<Category> findAll();

    public Category findById(int id);

    public void save(Category category);

    public void deleteById(int id);
}
