package com.monmouthvalley.tandoor.service;

import com.monmouthvalley.tandoor.entity.MenuItem;
import com.monmouthvalley.tandoor.entity.SimilarItem;

import java.util.List;

public interface MenuItemService {

    public List<MenuItem> findAll();

    public MenuItem findById(int id);

    public void save(MenuItem menuItem);

    public void deleteById(int id);

    public void save(SimilarItem similarItem);

}
