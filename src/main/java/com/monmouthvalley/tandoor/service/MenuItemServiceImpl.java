package com.monmouthvalley.tandoor.service;

import com.monmouthvalley.tandoor.dao.MenuItemRepository;
import com.monmouthvalley.tandoor.dao.SimilarItemRepository;
import com.monmouthvalley.tandoor.entity.MenuItem;
import com.monmouthvalley.tandoor.entity.SimilarItem;
import com.monmouthvalley.tandoor.exception.GenericNotFoundException;
import com.monmouthvalley.tandoor.shared.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    private MenuItemRepository menuItemRepository;
    private SimilarItemRepository similarItemRepository;

    private Utils utils;

    @Autowired
    public MenuItemServiceImpl(MenuItemRepository theMenuItemRepository,
                               SimilarItemRepository theSimilarItemRepository,
                                Utils utils){

        menuItemRepository = theMenuItemRepository;
        similarItemRepository = theSimilarItemRepository;
        this.utils =  utils;
    }

    @Override
    public List<MenuItem> findAll() {

        return menuItemRepository.findAll();
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
                //here we are adding each similarItem to this item similarItem's list

                //item.addSimilarItem(similarItem);

                //item.getSimilarItems().add(similarItem);

                similarItem.setMenuItem(item);

                //similarItem.setParentMenuItemId(item.getId());
            }
            item.setSimilarItems(similarItems);
        }

        //item.setId(0);

        item.setDateCreated(new Date());

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
