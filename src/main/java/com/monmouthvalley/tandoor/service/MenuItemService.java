package com.monmouthvalley.tandoor.service;

import com.monmouthvalley.tandoor.entity.MenuItem;
import com.monmouthvalley.tandoor.entity.SimilarItem;

import java.util.List;

public interface MenuItemService {

    public List<MenuItem> findAll();

    public MenuItem findById(int id);

//    @Query("select item from MenuItem u where u.emailAddress = ?1")
//    public MenuItem findByName(String name);

    public void save(MenuItem menuItem);

    public void deleteById(int id);

    /*public void save(SimilarItem similarItem);*/

    /*public SimilarItem findSimilarItem(
            int similarMenuItemId, int parentMenuItemId
    );
    public void deleteSimilarItem(
            int similarMenuItemId, int parentMenuItemId
    );*/

//    public void deleteSimilarItem();
}
