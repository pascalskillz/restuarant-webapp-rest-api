package com.monmouthvalley.tandoor.dao;

import com.monmouthvalley.tandoor.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {

   /* @Query("select item from SimilarItem where item.similar_menu_item_id = ?1 and item.parent_menu_item_id")
    public void deleteSimilarItem(int similarMenuItemId, int parentMenuItemId);*/
}
