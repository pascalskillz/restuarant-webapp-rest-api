package com.monmouthvalley.tandoor.dao;

import com.monmouthvalley.tandoor.entity.SimilarItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SimilarItemRepository extends JpaRepository<SimilarItem, Integer> {

    @Query("select item from SimilarItem item where item.similarMenuItemId = ?1 and item.parentMenuItemId=?2")
    public SimilarItem findSimilarItemBySimilarMenuItemIdAndParentMenuItemId(int similarMenuItemId, int parentMenuItemId);

    @Query("delete from SimilarItem item where item.similarMenuItemId = ?1 and item.parentMenuItemId=?2")
    public SimilarItem deleteSimilarItemBySimilarMenuItemIdAndParentMenuItemId(int similarMenuItemId, int parentMenuItemId);
}
