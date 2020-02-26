package com.monmouthvalley.tandoor.service;

import com.monmouthvalley.tandoor.entity.MenuItem;
import com.monmouthvalley.tandoor.entity.SimilarItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MenuItemService {

    //Page<MenuItem> findAll(int page, int size);

    List<MenuItem> findAll(int page, int limit);

    MenuItem findById(int id);


//    @Query("select item from MenuItem u where u.emailAddress = ?1")
//    public MenuItem findByName(String name);

    void save(MenuItem menuItem);

    void deleteById(int id);

    /*public void save(SimilarItem similarItem);*/

    /*public SimilarItem findSimilarItem(
            int similarMenuItemId, int parentMenuItemId
    );
    public void deleteSimilarItem(
            int similarMenuItemId, int parentMenuItemId
    );*/

//    public void deleteSimilarItem();
}
