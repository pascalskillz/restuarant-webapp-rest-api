package com.monmouthvalley.tandoor.service;

import com.monmouthvalley.tandoor.dao.MenuItemRepository;
import com.monmouthvalley.tandoor.dao.SimilarItemRepository;
import com.monmouthvalley.tandoor.entity.MenuItem;
import com.monmouthvalley.tandoor.entity.SimilarItem;
import com.monmouthvalley.tandoor.exception.GenericNotFoundException;
import com.monmouthvalley.tandoor.shared.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    private MenuItemRepository menuItemRepository;

    private Utils utils;

    @Autowired
    public MenuItemServiceImpl(MenuItemRepository theMenuItemRepository, Utils utils){

        menuItemRepository = theMenuItemRepository;
        this.utils =  utils;
    }

    @Override
    public List<MenuItem> findAll(int page, int limit) {

        Pageable pageableRequest = PageRequest.of(page, limit);

        Slice<MenuItem> paging = menuItemRepository.findAll(pageableRequest);

        if(!paging.hasContent()){
            return new ArrayList<MenuItem>();
        }
        return paging.getContent();
    }

    @Override
    public MenuItem findById(int id) {

        //using optional so we don't have to specifically check for null

        MenuItem menuItem = utils.validateMenuItem(id);

        return menuItem;
    }

 /*   @Override
    public MenuItem findByName(String name) {
        menuItemRepository;
    }*/

    @Override
    public void save(MenuItem item) {

        if(!(item.getSimilarItems() == null)){

            List<SimilarItem> similarItems = item.getSimilarItems();

            for(SimilarItem similarItem: similarItems){

                int similarMenuItemId = similarItem.getSimilarMenuItemId();

                utils.validateMenuItem(similarMenuItemId);

                //menu item has a list of similar items and
                //here we are adding each similarItem to the item's similarItem list

                similarItem.setMenuItem(item);

            }
            item.setSimilarItems(similarItems);
        }

        //item.setId(0);

        menuItemRepository.save(item);

    }

    @Override
    public void deleteById(int id) {
        menuItemRepository.deleteById(id);
    }


    /*private void validateSimilarItem(SimilarItem item) {

        int similarMenuItemId = item.getSimilarMenuItemId();

        Optional<MenuItem> result = menuItemRepository.findById(similarMenuItemId);

        MenuItem similarItem;

        if(result.isPresent()){
            similarItem = result.get();
        }
        else {
            //meunItem not found
            throw new GenericNotFoundException("No menu item with id " + similarMenuItemId);

        }
    }*/

    /*public MenuItem validateMenuItem(int menuItemId) {

        Optional<MenuItem> result = menuItemRepository.findById(menuItemId);

        MenuItem menuItem;

        if(result.isPresent()){
            menuItem = result.get();
        }
        else {
            //meunItem not found
            throw new GenericNotFoundException("No menu item with id " + menuItemId);
        }
        return menuItem;
    }*/


//    // saving a similar item
//    @Override
//    public void save(SimilarItem similarItem) {
//
//        similarItemRepository.save(similarItem);
//
//    }

   /* @Override
    public SimilarItem findSimilarItem(int similarMenuItemId, int parentMenuItemId) {

        SimilarItem result = similarItemRepository
                .findSimilarItemBySimilarMenuItemIdAndParentMenuItemId(similarMenuItemId, parentMenuItemId);

        if(result == null){
            throw new GenericNotFoundException("No similar item with id " + similarMenuItemId);
        }

        return result;
    }

    @Override
    @Transactional
    public void deleteSimilarItem(int similarMenuItemId, int parentMenuItemId) {

       similarItemRepository
               .deleteSimilarItemBySimilarMenuItemIdAndParentMenuItemId(similarMenuItemId, parentMenuItemId);
    }*/

    /*@Override
    public void deleteSimilarItem(int similarMenuItemId, int parentMenuItemId) {


    }*/
}
